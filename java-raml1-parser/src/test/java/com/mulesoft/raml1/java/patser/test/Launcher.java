package com.mulesoft.raml1.java.patser.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.api.ApiImpl;
import com.mulesoft.raml1.java.parser.model.api.Api;

public class Launcher {
	
	public static void main(String[] args) {
		JavaNodeFactory f = new JavaNodeFactory();
		Api api = f.createApi("C:/work/apis/Instagram/api.raml");
		print(api);
	}

	private static void print(Api api) {
		String str = ((ApiImpl)api).toJSON();
		File f = new File("C:/work/apis/Instagram/api.json");
		f.getParentFile().mkdirs();
		if(f.exists()){
			f.delete();
		}
		try {
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(str.getBytes("UTF-8"));
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println(str);
	}
}
