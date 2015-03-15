package com.problems;

public class Question7 {

	public static void main(String[] args) {
		int maximum = Integer.MAX_VALUE;
		boolean [] compositeArray = getCompositeArray(maximum/2);
		int count = 0;
		for (int i = 2; i < maximum/2; i++) {
			if (!compositeArray[i]) {
				count++; //prime number found
			}
			if (count == 10001) {
				System.out.println("10001 proime number is " + i);
				break;
			}
		}
	}
	
	public static boolean [] getCompositeArray(int n) {
		boolean [] compositeArray = new boolean[n];
		int temp = (int)Math.sqrt(n);
		for (int i = 2; i <= temp; i++) {
			if (!compositeArray[i]) {
				for (int j = 2; i * j < n; j++) {
					compositeArray[i * j] = true;// cross off all the composite numbers.
				}
			}
 		}
		return compositeArray;
	}

}
