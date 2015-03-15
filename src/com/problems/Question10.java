package com.problems;

// Sieve of Eratosthenes
// got it wrong first time because i took sum variable as an int.
public class Question10 {

	public static void main(String[] args) {
		Question10 q = new Question10();
		int n = 2000000;
		boolean [] composites = q.getCompositeArray(n);
		
		long sum = 0;
		int numberOfPrimes = 0;
		for(int i = 2; i < n; i++) {
			if (!composites[i]) { // i is prime if i >=2 and this condition is satisfied
				numberOfPrimes++;
				sum = sum + i;
			}
		}
		System.out.println(sum);
		System.out.println(numberOfPrimes);
	
	}
	
	public boolean [] getCompositeArray(int n) {
		boolean [] composites = new boolean[n]; // not including n
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			for (int j = i; j * i < n; j++) {
				composites[i * j] = true;
			}
		}
		return composites;
	}

}
