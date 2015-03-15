package com.problems;


/*
 * Got logic right . How ever made a mistake that I took variable n into int . it exceed int value range at one point 
 * so program never ended . I had to look into Internet and search a big deal to find out the bug.
 */
public class Question14 {

	public static void main(String[] args) {
		int result = 1;
		long chainLength = 0;
		long longestChainLength = 0;
		Question14 q = new Question14();
		
		for (int i = 2; i < 1000000 ; i++) {
			chainLength = q.getChainLength(i);
			if (chainLength > longestChainLength) {
				longestChainLength = chainLength;
				result = i;
				System.out.println("longest chain length is " + longestChainLength + " for " + result);
			}
		}
	}
	
	private int getChainLength(int n) {
		long k = n;
		if (k < 0) {
			return 0;
		}
		int chainLength = 0;
		while ( k != 1) {
			if (k % 2 == 0) {
				k = k / 2;
			} else {
				k = (3 * k) + 1;
			}
			chainLength++;
		}
		return ++chainLength;
	}
}
