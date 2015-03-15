package com.problems;

/*
 * Almost gave up on it . Found the procedure after i searched for it online.
 */
public class Question3 {

	public static void main(String[] args) {
		long n = 600851475143L;
		n = 21L;
		Question3 q = new Question3();
		System.out.println(q.getLargestPrimeFactor(n));
	}
	
	private boolean isPrime(long n) {
		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}


	public long getLargestPrimeFactor(long n) {
		long largestPrimeFactor = 1;
		for (long i = 3; i <= Math.sqrt(n); i = i + 2) {
			if (n % i == 0) {
				if (isPrime(i)) {
				   if (i > largestPrimeFactor) {
						largestPrimeFactor = i;
					}
					double j = n / i;
					if (j % 1 != 0) {
						continue;
					}
					if (isPrime((long)j)) {
						if (j > largestPrimeFactor) {
							largestPrimeFactor = (long)j;
						}
					}
				}
			}
		}
		return largestPrimeFactor;
	}
}