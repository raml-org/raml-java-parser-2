package com.mulesoft.raml1.java.parser.core;

public class ValidationIssue {
	
	public ValidationIssue(IssueCode code, String message, String path, Integer start, Integer end, boolean isWarning) {
		super();
		this.code = code;
		this.message = message;
		this.path = path;
		this.start = start;
		this.end = end;
		this.isWarning = isWarning;
	}

	private IssueCode code;
	
	private String message;

	private String path;
	
	private Integer start;
	
	private Integer end;
	
	private boolean isWarning;

	public IssueCode getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getEnd() {
		return end;
	}

	public boolean isWarning() {
		return isWarning;
	}
	
	@Override
	public String toString() {
		
		StringBuilder bld = new StringBuilder(isWarning?"Warning: " : "Error: ");
		bld.append(this.code != null ? this.code.name() : "NULL").append(": ")
			.append(this.message!=null ? this.message : "NULL")
			.append("; positions: ")
			.append(this.start!=null ? this.start : "NULL")
			.append("-")
			.append(this.end!=null ? this.end : "NULL");			
		String result = bld.toString();
		return result;
	}

	

}
