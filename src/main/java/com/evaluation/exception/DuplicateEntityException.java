package com.evaluation.exception;

import org.springframework.http.HttpStatus;

public class DuplicateEntityException extends ApiException {
	
	private static final long serialVersionUID = 1L;

	public DuplicateEntityException() {
		this("Duplicate entity");
	}

	public DuplicateEntityException(String message) {
		this("DUPLICATE_ENTITY", message);
	}

	public DuplicateEntityException(String code, String message) {
		super(HttpStatus.CONFLICT, code, message);
	}

}
