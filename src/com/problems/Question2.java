package com.problems;

/*
 *  sum of even numbers till n in fibonocci series is sum of all the terms till (n -1) if n is even.
 *  and sum of all the terms till n - 2 if n is odd
 */

public class Question2 {
	private int NUMBER = 54;
	private long [] fib = new long [NUMBER];
	
	public static void main(String[] args) {
		Question2 q2 = new Question2();
		
		long termValue = 0; // this is term less than 4 million
		int n = 0;
		while (termValue <= q2.NUMBER) {
			termValue = q2.getFib(++n);
		}
		System.out.println("the term order in fibonocci series where term is less than or equal to  " + 
		q2.NUMBER + " is " + --n + " term is " + q2.fib[n]);
		// n such that tn< NUMBER and tn+1 >= NUMBER
		
		if (n % 2 == 0) {
			System.out.println(q2.getSum(n - 1) + 1);
		} else {
			System.out.println(q2.getSum(n - 2) + 1);
		}
	}
	
	// returns nth term in fibonocci series
	private long getFib (int n) {
		if (n == 1 || n == 2) {
			fib[n] = n;
			return fib[n];
		}
		fib[n] = fib[n - 1] + fib[n - 2];
		return fib[n];
	}
	
	// returns sum of first n terms in fibonocci series
	private long getSum (int n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (fib[i] <= 0) {
				fib[i] = getFib(i);
			}
			sum = sum + fib[i];
		}
		return sum;
	}
}