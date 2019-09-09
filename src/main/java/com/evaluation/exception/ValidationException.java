package com.evaluation.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends ApiException {
	
	private static final long serialVersionUID = 1L;

	public ValidationException() {
		this("INVALID_ARGUMENT");
	}

	public ValidationException(String message) {
		this("INVALID_ARGUMENT", message);
	}

	public ValidationException(String code, String message) {
		super(HttpStatus.BAD_REQUEST, code, message);
	}

}
