package com.problems;

public class Question1 {
	// get sum of multiples of 3  -s1
	// get sum of multiples of 5 - s2
	// get sum of multiples of 15 - s3
	// s1 + s2 - s3
	public static void main(String[] args) {
		int number = 1000;
		int s1 = getSumOfMultiples(number, 3);
		int s2 = getSumOfMultiples(number, 5);
		int s3 = getSumOfMultiples(number, 15);
		
		System.out.println("answer is " +  (s1 + s2 - s3));
	}

	// returns sum of multiples of all x below n
	private static int getSumOfMultiples(int n, int x) {
		int numberOfMultiples = n / x;
		if (n % x == 0) {
			numberOfMultiples--;
		}
		int sum = x * getSumOfIntegers(numberOfMultiples);
		return sum;
	}
	
	private static int getSumOfIntegers(int x) {
		// returns sum of numbers from 1 to x;
		if (x <= 0) {
			return 0;
		}
		return (x * (x + 1)) / 2;
	}
}
