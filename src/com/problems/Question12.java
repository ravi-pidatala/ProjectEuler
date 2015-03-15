package com.problems;

public class Question12 {

	public static void main(String[] args) {
		Question12 q = new Question12();
		
		for (int i = 2;;i++) {
			long triangularNumber = q.getTriangularNumber(i);
			
			int numberOfDivisors = q.getNumberOfDivisors(triangularNumber);
			if (numberOfDivisors > 500) {
				System.out.println("triangular number is " + triangularNumber);
				break;
			}
		}
	}

	private long getTriangularNumber(int n) {
		return n * (n + 1) / 2;
	}

	private int getNumberOfDivisors(long n) {
		int numberOfDivisors = 2; // 1 and itself are two divisors.
		for(int i = 2; i <= Math.sqrt(n); i++ ) {
			if (n % i == 0) {
				if ( i == Math.sqrt(n)) {
					numberOfDivisors++;
				} else {
					numberOfDivisors = numberOfDivisors + 2;
				}
			}
		}
		return numberOfDivisors;
	}
}
