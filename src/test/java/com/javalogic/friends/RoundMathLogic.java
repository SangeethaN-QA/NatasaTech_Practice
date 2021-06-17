package com.javalogic.friends;

public class RoundMathLogic {

	public static void main(String[] args) {

		int finalValue;
		double sameValue;
		double num1 = 12.96;
		System.out.println(Math.round(num1));

		//		      float num2 = 1337.345523f;
		//		      System.out.println(Math.round(num2));

		String doubleNumber = Double.toString(num1); 
		System.out.println("covert ::: " +doubleNumber);

		String[] doubleArr = doubleNumber.split("\\.");
		//System.out.println("size ---- " +doubleArr.length);

		String beforedigit = doubleArr[0];

		String afterdigit = doubleArr[1];

		System.out.println("before digit ::: " +beforedigit);
		System.out.println("after digit ::: " +afterdigit);

		char afterdigitSecondValue = afterdigit.charAt(1);
		System.out.println("afterdigitSecondValue --- " +afterdigitSecondValue);

		if(afterdigitSecondValue>=6)
		{
			finalValue = (int) Math.round(num1);
			System.out.println("final value ---- " +finalValue);
		}else if(afterdigitSecondValue<6)
		{
			sameValue = num1;
			System.out.println("final value ---- " +sameValue);
		}else {
			System.out.println("check");
		}



	}
}
