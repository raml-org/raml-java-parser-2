package com.mulesoft.raml1.java.patser.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.core.ValidationIssue;
import com.mulesoft.raml1.java.parser.impl.api.ApiImpl;
import com.mulesoft.raml1.java.parser.model.api.Api;

public class Launcher {
	
	public static void main(String[] args) {
		JavaNodeFactory f = new JavaNodeFactory();
		Api api = f.createApi("C:/GIT-repos/raml-labs/automation/input/staging/Parse_1/parse.raml");
		List<ValidationIssue> errors = api.getErrors();
		for(ValidationIssue vi : errors){
			System.out.println(vi.toString());			
		}
		print(api);
	}

	private static void print(Api api) {
		String str = ((ApiImpl)api).toJSON();
		File f = new File("C:/workspaces/JavaRamlScript/java-raml1-parser/out/api.json");
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
