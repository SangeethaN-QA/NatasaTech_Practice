package com.companyJavaLogic;

public class TestDemo {

	public static void main(String[] args) {

		String a = "Am Hai Hello Good";
		String[] b = a.split("Hai Hello");
		String b1 = b[0];
		String b2 = b[1];
		System.out.println(b1);
		
		String wordByStar = a.replaceAll( "[A-Za-z0-9]", "*" );
		System.out.println(wordByStar);
		
	}
	
	
}
