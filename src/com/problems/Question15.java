package com.problems;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;

// First time did not get the concept .This is a simple one which does not need program , needs just logic
// I am unable to calculate the value of 40C20 . got it from online . try calculating it .
public class Question15 {
	
	static long ways = 0;
	Map<Integer,Long> factorialMap = new HashMap<>();
	
	public static void main(String[] args) {
//		ways = 0;
//		getWays(10,10);
//		System.out.println(ways);
		
		// it is number of ways of selecting 20 items from 40 items.
//		Question15 q = new Question15();
//		long numerator = q.getFactorial(40);
//		long denominator = q.getFactorial(20);
//		System.out.println("factorial 40 is " + q.getFactorial(40));
//		
//		System.out.println(numerator / (denominator * denominator));
		
		System.out.println((long)16 * 39 * 37 * 11 * 31 * 29 * 25 * 23 * 21);
	}
	
	private long getFactorial(int n) {
		if (factorialMap.get(n) == null) {
			if (n == 1) {
				return 1;
			}
			long factorial = n * getFactorial(n - 1);
			factorialMap.put(n, factorial);
			return factorial;
		} else {
			return factorialMap.get(n);
		}
	}
	
	private static void getWays(int x, int y) {
		// base case
		if (x == 0 || y == 0) {
			ways++;
			return;
		}
		if (x > 0) {
			getWays(x - 1, y);
		}
		
		if (y > 0) {
			getWays(x, y - 1);
		}
	}
}

