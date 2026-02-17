package com.stringProgram.www;

public class firstUpperCase {
	public static void main(String[] args) {
		String str = "hello there how are you";
		String[] arr = str.split(" ");
		for (String s : arr) {
			 firstCharUpperCase(s);
		}
	}
	
	private static void firstCharUpperCase(String str) {
		String res = "";
		String first=""+str.charAt(0);
		
//		if (str.length() > 1) {
//			for (int i = 1; i < str.length(); i++) {
//				res = res + str.charAt(i);
//			}
//			String first=""+str.charAt(0);			
//			System.out.print (first.toUpperCase()+res+" ");
//		}
		
		System.out.print(first.toUpperCase()+str.substring(1)+" ");

	}
}
