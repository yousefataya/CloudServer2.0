package com.experts.core.biller.statemachine.api.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(final String message) {
		super(message);
	}
}
