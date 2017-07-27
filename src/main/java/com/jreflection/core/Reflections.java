package com.jreflection.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import com.jreflection.exceptions.ReflectionsArgumentException;
import com.jreflection.exceptions.ReflectionsException;
import com.jreflection.exceptions.ReflectionsIllegalAccessException;
import com.jreflection.exceptions.ReflectionsInvocationTargetException;
import com.jreflection.exceptions.ReflectionsNoSuchMethodException;
import com.jreflection.exceptions.ReflectionsSecurityException;

public class Reflections {

	public static ClassCaller on(Object object) {
		if (object == null) {
			throw new ReflectionsException("Your object can not be null");
		}
		return new ClassCaller(object);
	}

	public static class ClassCaller {

		private Object object;

		public ClassCaller(Object object) {
			this.object = object;
		}

		public ArgumentClass call(String method) {
			if (method == null) {
				throw new ReflectionsException("Your method can not be null");
			}
			return new ArgumentClass(object, method);
		}

	}

	public static class ArgumentClass {

		private String method;
		private Object object;

		public ArgumentClass(Object object, String method) {
			this.object = object;
			this.method = method;
		}

		public Optional<Object> with(Object argument) {
			if (argument == null) {
				throw new ReflectionsException("Your argument can not be null");
			}
			try {
				Class<?> clazz = object.getClass();

				Method classMethod = clazz.getMethod(method, new Class[] {argument.getClass()});

				Object methodResult = classMethod.invoke(object, new Object[] {argument});

				return Optional.ofNullable(methodResult);
			} catch (NoSuchMethodException e) {
				throw new ReflectionsNoSuchMethodException("Make sure that the method exists in the target class. Remember: You can't access private, protected or package visibility methods", e);
			} catch (SecurityException e) {
				throw new ReflectionsSecurityException("There is a Security Violations in your access", e);
			} catch (IllegalAccessException e) {
				throw new ReflectionsIllegalAccessException("You can not access the method. Make sure that the method is public", e);
			} catch (IllegalArgumentException e) {
				throw new ReflectionsArgumentException("Your argument is illegal for the method invocation", e);
			} catch (InvocationTargetException e) {
				throw new ReflectionsInvocationTargetException("There is an error while trying to invoke the target method", e);
			}
		}

	}


}
