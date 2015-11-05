package com.mulesoft.raml1.java.parser.core;

import java.util.List;

public interface IJavaElementNode extends IJavaNode {

	List<ValidationIssue> getErrors();

}
