package com.jreflection.exceptions;

public class ReflectionsSecurityException extends RuntimeException {

	private static final long serialVersionUID = 3654781785755795225L;

	public ReflectionsSecurityException(String errorMessage, SecurityException exception) {
		super(errorMessage, exception);
	}

}
