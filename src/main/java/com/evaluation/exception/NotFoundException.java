package com.evaluation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		this("Resource not found");
	}

	public NotFoundException(String message) {
		this("NOT_FOUND", message);
	}

	public NotFoundException(String code, String message) {
		super(HttpStatus.NOT_FOUND, code, message);
	}

}
