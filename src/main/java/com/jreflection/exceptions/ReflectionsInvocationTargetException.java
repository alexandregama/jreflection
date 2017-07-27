package com.jreflection.exceptions;

import java.lang.reflect.InvocationTargetException;

public class ReflectionsInvocationTargetException extends RuntimeException {

	private static final long serialVersionUID = 6350591821450998786L;

	public ReflectionsInvocationTargetException(String errorMessage, InvocationTargetException exception) {
		super(errorMessage, exception);
	}

}
