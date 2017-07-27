package com.jreflection.exceptions;

public class ReflectionsNoSuchMethodException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ReflectionsNoSuchMethodException(String errorMessage, NoSuchMethodException exception) {
		super(errorMessage, exception);
	}

}
