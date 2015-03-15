package com.problems;

import java.math.BigInteger;

/*
 * Got the idea to use biginteger when looked at a blog . How ever got the implementation
 * from oracle documentation.
 *TODO .. try it without using biginteger.
 */
public class Question16 {

	public static void main(String[] args) {
		BigInteger index = new BigInteger("2");
		BigInteger value = index.pow(1000);
		BigInteger ten = new BigInteger("10");
		BigInteger sum = BigInteger.ZERO;
		
		while (value.compareTo(BigInteger.ZERO) > 0) {
			BigInteger [] array = value.divideAndRemainder(ten);
			BigInteger quotient = array[0];
			BigInteger reminder = array[1];
			value = quotient;
			sum = sum.add(reminder);
		}
		System.out.println(sum.toString());
		
	}

}
