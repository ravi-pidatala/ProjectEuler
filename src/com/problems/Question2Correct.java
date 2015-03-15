package com.problems;

// understood question wrong for the first time . 
public class Question2Correct {
	private int NUMBER = 4000000;
	private long [] fib = new long [NUMBER];
	
	public static void main(String[] args) {
		long term = 0;
		long sum = 0;
		int n = 1;
		Question2Correct q2c = new Question2Correct();
		
		while (term <= q2c.NUMBER) {
			if (term % 2 == 0) {
				// add to sum if the term in fib series is even
				System.out.println("adding" + term + " to sum ");
				sum = sum + term;
			} 
			term = q2c.getFib(n++);
		}
		System.out.println("sum of even terms whose value does not exceed " + q2c.NUMBER + " is " + sum);
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

}
