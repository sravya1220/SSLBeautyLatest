package com.sslweb.automation.util;

import com.sslweb.automation.util.exceptions.AssertException;

/**
 * 
 * @author sairam.p
 *
 */
public class Assert {

	private Assert() {}
	
	public static void assertTrue(boolean val, String msg) {
		if(!val) {
			throw new AssertException(msg);
		}
	}
	
	public static void assertTrue(boolean val) {
		if(!val) {
			throw new AssertException();
		}
	}
	
	public static void assertEquals(String actual, String expected, String msg) {
		if(!actual.equals(expected)) {
			throw new AssertException(msg);
		}
	}
	
	public static void assertEqualsIgnore(String actual, String expected, String msg) {
		if(!actual.equalsIgnoreCase(expected)) {
			throw new AssertException(msg);
		}
	}
	
	public static void assertEquals(String actual, String expected) {
		if(!actual.equals(expected)) {
			throw new AssertException();
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void assertEquals(String actual, String[] expected, String msg) {
		if(!actual.equals(expected)) {
			throw new AssertException(msg);
		}
	}
	
}
