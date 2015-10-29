package com.mulesoft.raml.webpack.holders;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptEngine;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class JSRequest extends AbstractJSWrapper {
	private HashMap<String, Object> handlers = new HashMap<String, Object>();
	
	private String host;
	private String port;
	private String path;
	private String method;
	
	private boolean ssl;
	
	public Object responseHandler; 
	
	private Map<String, String> headers = new HashMap<String, String>();
			
	@SuppressWarnings("restriction")
	public JSRequest(Object options, Object responseHandler, boolean ssl, ScriptEngine engine) {
		super(engine);
		
		this.responseHandler = responseHandler;
		
		this.ssl = ssl;
		
		Bindings bindings = getBindings();
		
		bindings.put("owner", this);
		bindings.put("opts", options);
		
		eval("owner.setHost(opts.host);", bindings);
		eval("owner.setPort(opts.port);", bindings);
		eval("owner.setPath(opts.path);", bindings);
		eval("owner.setMethod(opts.method);", bindings);
		
		eval("for(var key in opts.headers) { owner.putHeader(key, opts.headers[key]);};", bindings);
	}
	
	public JSRequest on(Object options, Object callback) {
		handlers.put(options.toString(), callback);
		
		return this;
	}
	
	public void putHeader(String name, String value) {
		headers.put(name, value);
	}
	
	private String body;
	
	public void end(Object obj){
		write(obj);
		end();
	}
	
	public void end() {
		String url = (ssl ? "https://" : "http://") + host + path;
		
		try {
			if(this.method.trim().toLowerCase().equals("get")&&this.body!=null){
				executeGetRequestWithBody(url);
			}
			else{
				executeRequest(url);
			}
		} catch (Throwable t) {
			onError(new JSError());
		} finally {
			onEnd();
			
			System.out.println("Succesfully performed call: " + method.toUpperCase() + " '" + url + "'");
		}
	}
	
	private void executeGetRequestWithBody(String url)
			throws IOException, MalformedURLException, UnsupportedEncodingException, ProtocolException, Throwable {
		
		System.out.println("Performing call: " + method.toUpperCase() + " '" + url + "'");
		
		EntityEnclosingMethod getMethod = new EntityEnclosingMethod(url) {
			
			@Override
			public String getName() {
				return "GET";
			}
		};
		
		String contentType = "text/plain";
		for(Map.Entry<String,String> e : this.headers.entrySet()){
			String name = e.getKey();
			String value = e.getValue();
			getMethod.setRequestHeader(name, value);
			if(name.trim().toLowerCase().equals("content-type")){
				contentType = value;
			}
		}
		
		getMethod.setRequestEntity(new StringRequestEntity(this.body, contentType, "UTF-8"));
		
		HttpClient httpClient = new HttpClient();
		int status = httpClient.executeMethod(getMethod);
		
		String responseText = getMethod.getResponseBodyAsString();
		
		Header[] respHeaders = getMethod.getResponseHeaders();
		
		HashMap<String, String> responseHeaders = new HashMap<String, String>();
		
		for(Header h : respHeaders) {
			responseHeaders.put(h.getName(), h.getValue());
		}
		
		getMethod.releaseConnection();
		
		JSResponse response = new JSResponse(engine, responseText, ""+status, responseHeaders);
  
		onSuccess(response);
		
		response.end();
	}

	private void executeRequest(String url)
			throws IOException, MalformedURLException, UnsupportedEncodingException, ProtocolException, Throwable {
		System.out.println("Performing call: " + method.toUpperCase() + " '" + url + "'");
		
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		
		if(this.body!=null){
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Length", ""+this.body.getBytes("UTF-8").length);
		}
				    	    
		connection.setDoInput(true);
		
		connection.setRequestMethod(method.toUpperCase());
		
		for(String header: headers.keySet()) {
			connection.setRequestProperty(header, headers.get(header));
		}
		
		String responseText = getResponseText(connection);
		
		Map<String, List<String>> map = connection.getHeaderFields();
		
		HashMap<String, String> responseHeaders = new HashMap<String, String>();
		
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			responseHeaders.put(entry.getKey(), entry.getValue().toString());
		}
		
		JSResponse response = new JSResponse(engine, responseText, connection.getResponseCode() + "", responseHeaders);
  
		onSuccess(response);
		
		response.end();
	}
	
	private void onError(JSError error) {
		Bindings bindings = getBindings();
		
		if(handlers.get("error") != null) {
			bindings.put("callback", handlers.get("error"));
			bindings.put("error", error);
			
			eval("callback(error);", bindings);
		}
	}
	
	private void onSuccess(JSResponse response) {
		Bindings bindings = getBindings();
		
		if(responseHandler != null) {
			bindings.put("callback", responseHandler);
			bindings.put("response", response);
			
			eval("callback(response);", bindings);
		}
	}
	
	private void onEnd() {
		Bindings bindings = getBindings();
		
		if(handlers.get("end") != null) {
			bindings.put("callback", handlers.get("end"));
			
			eval("callback();", bindings);
		}
	}
	
	private static void writeRequestBody(URLConnection connection, String text) throws Throwable {
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		
        writer.write(text);
        writer.close();
	}
	
	private String getResponseText(URLConnection connection) throws Throwable {
		if(this.body!=null){
			DataOutputStream dos = new DataOutputStream(connection.getOutputStream());			
	        dos.writeBytes(this.body.toString());
	        dos.flush ();
	        dos.close();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    
	    ArrayList<String> lines = new ArrayList<String>();
	    
	    StringBuilder stringBuilder = new StringBuilder("");
	    
	    int count = 0;
	    		    		    
	    for(String line = reader.readLine(); line != null; line = reader.readLine()) {
	    	lines.add(line);
	    }
	    
	    for(String line: lines) {
	    	count++;
	    	
	    	stringBuilder.append(line);
	    	
	    	stringBuilder.append(lines.size() == count ? "" : "\n");
	    }
	    		    		    		    
	    reader.close();
	    
	    return stringBuilder.toString();
	}
	
	
	public boolean write(Object obj,Object obj1,Object obj2){
		return write(obj);
	}
	
	public boolean write(Object obj,Object obj1){
		return write(obj);
	}
	
	public boolean write(Object obj){
		if(this.body==null){
			this.body = "";
		}
		this.body += obj.toString();
		return true;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}