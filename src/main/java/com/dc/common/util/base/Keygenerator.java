package com.dc.common.util.base;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Keygenerator {
	private static final String FORMAT = "yyyyMMddHHmmssSSS";
    
    private final static int NUMBER_LENGTH = 14;
    
    private final static String PREFIX_REQUEST_NO = "R";
    
	private static  String generate(String prefix){
		 Date date = new Date();
		 StringBuilder sb = new StringBuilder();
		 sb.append(prefix);
		 sb.append(new SimpleDateFormat(FORMAT).format(date));
		 String uuid_hex = UUID.randomUUID().toString().replaceAll("-", "").substring(0,NUMBER_LENGTH).toUpperCase();
		 String uuid = String.format("%015d", Long.valueOf(uuid_hex,16)).substring(0,NUMBER_LENGTH-prefix.length()+1).toUpperCase();
		 sb.append(uuid);
		 String substring = sb.substring(0, 28);
		 return substring.toString();
	}


	public static String generateRandomDigitString(int aLength) {
		SecureRandom tRandom = new SecureRandom();
		String aString = "";
		tRandom.nextLong();
		long tLong = Math.abs(tRandom.nextLong());

		for(aString = String.valueOf(tLong).trim(); aString.length() < aLength; aString = aString + String.valueOf(tLong).trim()) {
			tLong = Math.abs(tRandom.nextLong());
		}

		aString = aString.substring(0, aLength);
		return aString;
	}


	/**
	 * 
	* @author 作者 : Tank
	* 方法说明 :生成32位请求ID
	 */
	public static String generateRequestNo(){
		return generate(PREFIX_REQUEST_NO);
	}
	
	/**
	 * 生成自定义前缀ID
	 * @param prefix
	 * @return
	 */
	public static String generateIdWithPrefix(String prefix){
		if (DataUtil.isNotEmpty(prefix)) {
			return generate(prefix);
		}
		return generate("");
	}
	
	/**
	 * 生成UUID
	 * @return
	 */
	public static String generateUUID(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	
	public static void main(String[] args) {
		System.err.println(generateIdWithPrefix("person"));
		System.err.println(generateIdWithPrefix("company"));
	}
}
