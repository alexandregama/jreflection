package com.jreflection.core;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Optional;

import org.junit.Test;

import com.jreflection.exceptions.ReflectionsException;
import com.jreflection.exceptions.ReflectionsNoSuchMethodException;

public class ReflectiontsTest {

	@Test
	public void shouldInvokeMethodSuccessfully() throws Exception {
		WhiteColor whiteColor = new WhiteColor();

		Color desiredColor = Color.WHITE;

		Reflections
			.on(whiteColor)
			.call("printColor")
			.with(desiredColor);
	}

	@Test
	public void shouldInvokeMethodSuccessfullyAndReturnAValue() throws Exception {
		WhiteColor whiteColor = new WhiteColor();

		Color desiredColor = Color.WHITE;

		Optional<Object> methodResult = Reflections
			.on(whiteColor)
			.call("getColor")
			.with(desiredColor);

		assertTrue(methodResult.isPresent());
	}

	@Test(expected = ReflectionsNoSuchMethodException.class)
	public void shouldThrowsAnReflectionsNoSuchMethodExceptionWhenTheMethodIsPrivate() throws Exception {
		WhiteColor whiteColor = new WhiteColor();

		Color desiredColor = Color.WHITE;

		Reflections
			.on(whiteColor)
			.call("privatePrintColor")
			.with(desiredColor);
	}

	@Test(expected = ReflectionsNoSuchMethodException.class)
	public void shouldThrowsAnReflectionsNoSuchMethodExceptionWhenTheMethodIsProtected() throws Exception {
		WhiteColor whiteColor = new WhiteColor();

		Color desiredColor = Color.WHITE;

		Reflections
			.on(whiteColor)
			.call("protectedPrintColor")
			.with(desiredColor);
	}

	@Test(expected = ReflectionsNoSuchMethodException.class)
	public void shouldThrowsAnReflectionsNoSuchMethodExceptionWhenTheMethodIsPackage() throws Exception {
		WhiteColor whiteColor = new WhiteColor();

		Color desiredColor = Color.WHITE;

		Reflections
			.on(whiteColor)
			.call("packagePrintColor")
			.with(desiredColor);
	}

	@Test(expected = ReflectionsException.class)
	public void shouldThrowsAnExceptionWhenTheObjectIsNull() throws Exception {
		WhiteColor whiteColor = null;

		Color desiredColor = Color.WHITE;

		Reflections
			.on(whiteColor)
			.call("printColor")
			.with(desiredColor);
	}

	@Test(expected = ReflectionsException.class)
	public void shouldThrowsAnExceptionWhenTheMethodIsNull() throws Exception {
		WhiteColor whiteColor = null;

		Color desiredColor = Color.WHITE;

		String method = null;

		Reflections
			.on(whiteColor)
			.call(method)
			.with(desiredColor);
	}

	@Test(expected = ReflectionsException.class)
	public void shouldThrowsAnExceptionWhenTheArgumentIsNull() throws Exception {
		WhiteColor whiteColor = null;

		Color desiredColor = null;

		Reflections
			.on(whiteColor)
			.call("printColor")
			.with(desiredColor);
	}

}

class WhiteColor {

	public void printColor(Color color) {
		System.out.println("Printing the color: " + color);
	}

	@SuppressWarnings("unused")
	private void privatePrintColor(Color color) {
		System.out.println("Printing the color: " + color);
	}

	protected void protectedPrintColor(Color color) {
		System.out.println("Printing the color: " + color);
	}

	void packagePrintColor(Color color) {
		System.out.println("Printing the color: " + color);
	}

	public Color getColor(Color color) {
		return color;
	}

}