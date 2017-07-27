package com.jreflection.exceptions;

public class ReflectionsArgumentException extends RuntimeException {

	private static final long serialVersionUID = 1485608476605336853L;

	public ReflectionsArgumentException(String errorMessage, IllegalArgumentException exception) {
		super(errorMessage, exception);
	}

}
