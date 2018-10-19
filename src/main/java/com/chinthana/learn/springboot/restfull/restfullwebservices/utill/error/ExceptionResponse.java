package com.chinthana.learn.springboot.restfull.restfullwebservices.utill.error;

import java.util.Date;

public class ExceptionResponse extends RuntimeException {
	
	private Date timestamp;
	private String errorMessage;
	private String errorDetails;

	public ExceptionResponse(Date timestamp, String errorMessage, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}	

	public String getErrorDetails() {
		return errorDetails;
	}

}
