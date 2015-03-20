package com.problems;

import java.math.BigInteger;

/*
 * Got the idea to use biginteger when looked at a blog . How ever got the implementation
 * from oracle documentation.
 * Got it without using big integer.
 */
public class Question16 {

	// implementation using big integer
//	public static void main(String[] args) {
//		BigInteger index = new BigInteger("2");
//		BigInteger value = index.pow(1000);
//		BigInteger ten = new BigInteger("10");
//		BigInteger sum = BigInteger.ZERO;
//		
//		while (value.compareTo(BigInteger.ZERO) > 0) {
//			BigInteger [] array = value.divideAndRemainder(ten);
//			BigInteger quotient = array[0];
//			BigInteger reminder = array[1];
//			value = quotient;
//			sum = sum.add(reminder);
//		}
//		System.out.println(sum.toString());
//		
//	}

	public static void main(String [] args) {
		Question16 q = new Question16();
		int [] intArray = {2};
		BigInt b = new BigInt(intArray);
		for (int i = 1; i < 1000; i++) {
			b = q.multiplyBytwo(b);
		}
		
		int [] result = b.getIntArray();
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			System.out.println("adding" + result[i]);
			sum = sum + result[i];
		}
		System.out.println("sum is " + sum);
	}
	
	private BigInt multiplyBytwo(BigInt b) {
		BigInt temp = new BigInt(b.getIntArray()); 
		b = add(b, temp);
		return b;
	}
	
	public BigInt add(BigInt b1, BigInt b2) {
	// validate for null.
		int [] a = null;
		int [] b = null;
		
		if (b1.getIntArray().length >= b2.getIntArray().length) {
			a = b1.getIntArray();
			b = b2.getIntArray();
		} else {
			a = b2.getIntArray();
			b = b1.getIntArray();	
		}
		int cOver = 0;
		int temp = 0;
		int j = b.length - 1;
		
		int [] c = new int [a.length + 1];
		
		for (int i = a.length - 1; i >= 0; i--) {
			if (j >= 0) {
				temp = a[i]+ b[j] + cOver;
				cOver = 0;
				if (temp >= 10) {
					cOver = temp / 10;
					temp = temp % 10;
				}
				j--;
			} else {
				temp = a[i] + cOver;
				cOver = 0;
				if (temp >= 10) {
					cOver = temp / 10;
					temp = temp % 10;
				}
				
			}
			c[i + 1] = temp;
		}
		c[0] = cOver;
		
		BigInt c1 = new BigInt(c);
		return c1;
	}
}

class BigInt {
	private int [] intArray;
	
	BigInt(int [] intArray) {
		this.intArray = intArray;
	}
	
	public void setIntArray(int [] intArray) {
		this.intArray = intArray;
	}
	
	public int [] getIntArray() {
		return intArray;
	}
}
