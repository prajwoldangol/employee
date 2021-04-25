package com.registerlogin.helper;

public class ValidateData {
	
	public static boolean isValidNum( String data ) {

		return data.matches("[0-9]+");

	}
	public static boolean isValidPhoneNum( String data) {

		return  data.length() == 10 && data.matches("[0-9]+") ;
	}

	public static boolean isGreaterThan( int i , int j ) {

		return i > j ;
	}
	
	public static boolean isLengthGreaterThan( String data,int limit ) {
		
		return data.length() > limit ;
	}
	
	
	

}
