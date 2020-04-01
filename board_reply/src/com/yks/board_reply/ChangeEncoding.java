package com.yks.board_reply;

import java.io.UnsupportedEncodingException;

public class ChangeEncoding {

	public ChangeEncoding() {
	}
	
	// java => mySQL에 저장
	public static String toLatin(String str) {
		
		try {
			byte[] b = str.getBytes();
			return new String(b, "ISO-8859-1");
		} catch (UnsupportedEncodingException uee) {
			System.out.println(" Encoding ERR : toLatin()" + uee.getMessage());
			return null;
		}
		
	}
	
	// mySQL => Java 로 저장
	public static String toUnicode(String str) {
		byte[] b;
		try {
			b = str.getBytes("ISO-8859-1");
			return new String(b);
		} catch (UnsupportedEncodingException uee) {
			System.out.println("Encoding ERR : toUnicode() " + uee.getMessage());
			return null;
		}
		
	}
}