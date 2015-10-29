package com.mulesoft.raml1.java.parser.path.resolver;

import java.util.List;

public interface IJavaPathResolver {
	
	String content(String path);
	
	List<String> list(String path);

}
