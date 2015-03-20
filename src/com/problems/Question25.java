package com.problems;

import java.util.HashMap;
import java.util.Map;


public class Question25 {

	private Question16 q16 = new Question16();
	
	public static void main(String[] args) {
		int n = 1;
		BigInt result = null;
		Question25 q = new Question25();
		Map<Integer, BigInt> fibMap = new HashMap<>();
		
		while (true) {
			result = q.getFibTerm(n, fibMap);
			if(q.getNumberOfDigits(result) == 1000) {
				break;
			}
			n++;
		}
		System.out.println("fibonocci number is"  );
		for (int i = 0; i < result.getIntArray().length ;i++) {
			System.out.print(result.getIntArray()[i]);
		}
		System.out.println();
		System.out.println(n);
	}

	public BigInt getFibTerm(int n, Map<Integer, BigInt> fibMap) {
		if (fibMap.get(n) != null) {
			return fibMap.get(n);
		}
		
		//base case
		if (n ==1 || n ==2) {
			int [] array = {1};
			fibMap.put(n,  new BigInt(array));
			return fibMap.get(n);
		}
		
		BigInt result = q16.add(getFibTerm(n - 1, fibMap), getFibTerm(n - 2, fibMap));
		result = removeStartZeros(result);
		fibMap.put(n, result);
		return result;
		
	}
	/*
	 * while adding two big int numbers , sometimes zero could be inserted in the start. remove them.
	 */
	private BigInt removeStartZeros(BigInt b) {
		int numberOfSartZeros = 0;
		int [] intArray = b.getIntArray();
		
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] > 0) {
				numberOfSartZeros = i;
				break;
			}
		}
		int newLength = intArray.length - numberOfSartZeros;
		
		int [] newArray = new int [newLength];
		for (int i = 0; i < newLength; i++) {
			newArray[i] = intArray[numberOfSartZeros + i];
		}
		BigInt newResult = new BigInt(newArray);
		b = null;
		return newResult;
	}
	
	public int getNumberOfDigits(BigInt b) {
		int [] intArray = b.getIntArray();
		int totalDigits = intArray.length;
		return totalDigits;
		
	}
}
