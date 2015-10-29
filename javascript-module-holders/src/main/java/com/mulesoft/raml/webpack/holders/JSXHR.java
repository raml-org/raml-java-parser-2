package com.mulesoft.raml.webpack.holders;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.methods.OptionsMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;

public class JSXHR extends AbstractJSWrapper {
	
	public JSXHR(ScriptEngine engine) {
		super(engine);
	}


	private HashMap<String, Object> handlers = new HashMap<String, Object>();
	
	private String url;
	private String method;
	
	private Map<String, String> requestHeaders = new HashMap<String, String>();
	
	private Map<String, String> responseHeaders = new HashMap<String, String>();
	
	private Map<String, String> responseHeaders_lc = new HashMap<String, String>();
	
	private boolean async;
	
	public String status;
	
	public String responseText;
	
	public String responseType;
	
	public void open(String method, String url, boolean async){
		this.url = url;
		this.method = method.toUpperCase();
		this.async = async;
	}
	
	public void setRequestHeader(String name, String value){
		this.requestHeaders.put(name, value);
	}
	
	public void send(String body){
		
	}
	
	public void send(){
		
		HttpClient client = new HttpClient();

        String method_lc = this.method.toLowerCase();
        HttpMethod httpMethod = null;
        if(method_lc.equals("get")){
        	httpMethod = new GetMethod(url);
        }
        else if(method_lc.equals("post")){
        	httpMethod = new PostMethod(url);
        }
        else if(method_lc.equals("put")){
        	httpMethod = new PutMethod(url);
        }
        else if(method_lc.equals("delete")){
        	httpMethod = new DeleteMethod(url);
        }
        else if(method_lc.equals("head")){
        	httpMethod = new HeadMethod(url);
        }
        else if(method_lc.equals("options")){
        	httpMethod = new OptionsMethod(url);
        }
        
        for(Map.Entry<String,String> e : this.requestHeaders.entrySet()){
        	httpMethod.setRequestHeader(e.getKey(), e.getValue());        	
        }
        
        try{
            this.status = "" + client.executeMethod(httpMethod);

            System.out.println("Status Code = " + this.status);
            System.out.println("QueryString>>> "+httpMethod.getQueryString());
            System.out.println("Status Text>>>" + HttpStatus.getStatusText(Integer.parseInt(this.status)));

            System.out.println(httpMethod.getResponseBodyAsString());
            byte [] res  = httpMethod.getResponseBody();
            this.responseText = new String(res,"utf-8");
            for(Header h : httpMethod.getResponseHeaders()){
            	this.responseHeaders.put(h.getName(),h.getValue());
            	this.responseHeaders_lc.put(h.getName().toLowerCase(),h.getValue());
            }
            this.responseText = this.getResponseHeader("content-type");
            httpMethod.releaseConnection();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
	}
	
	public String getResponseHeader(String name){
		return this.responseHeaders_lc.get(name.toLowerCase());
	}
	
	
	public String getAllResponseHeaders(){
		StringBuilder bld = new StringBuilder();
		for(Map.Entry<String,String> e : this.responseHeaders.entrySet()){
        	bld.append(e.getKey()).append(":").append(e.getValue()).append("\n");        	
        }
		return bld.toString().trim();
	}

}