package com.csu.party.util;

public class StringUtils {
	public static String deleteBlank(String str) {
		return str == null ? null : str.replace(" ", "");
	}
}
