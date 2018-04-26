package ua.myCinema.service.utils;

import org.apache.commons.lang.RandomStringUtils;

public final class TokenGenerator {
	
	public static String generate() {
		int a = 0;
		int b = 1000000;
		Integer intToken = a + (int) (Math.random() * b);
		String stringToken = String.valueOf(intToken);
		
		return stringToken;
	}
	
	public static String generate(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}	
}
