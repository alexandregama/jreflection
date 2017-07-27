package com.jreflection.exceptions;

public class ReflectionsIllegalAccessException extends RuntimeException {

	private static final long serialVersionUID = -6316310841174927216L;

	public ReflectionsIllegalAccessException(String errorMessage, IllegalAccessException exception) {
		super(errorMessage, exception);
	}

}
