package com.problems;


public class Question20 {

	public static void main(String[] args) {
		Question20 q = new Question20();
		int [] intArray = {1};
		BigInt b = new BigInt(intArray);
		
		for (int i = 2; i <= 100; i++) {
			b = q.getMultiplication(b, i);
		}
		
		int [] digits = b.getIntArray();
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			System.out.println(digits[i]);
			sum = sum + digits[i];
		}

		System.out.println("sum is " + sum);
	}
	
	/*
	 * Multiplies bigInt with integer > 0 && <= 100
	 */
	public BigInt getMultiplication (BigInt b, int n) {
		if (n > 100) {
			System.out.println("error");
			return null;
		}
		int [] a = b.getIntArray();
		int [] c = new int [a.length + 2]; 
		int cOver = 0;
		int product = 0;
		for (int i = a.length - 1; i >=0; i--) {
			product = a[i] * n + cOver;
			cOver = 0;
			if (product > 10) {
				cOver = product / 10;
				product = product % 10;
			}
			c[i + 2] = product;
		}
		c[1] = cOver % 10 ;
		c[0] = cOver / 10;
		
		BigInt result = new BigInt(c);
		return result;
	}
}
