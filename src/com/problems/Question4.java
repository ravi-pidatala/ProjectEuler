package com.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * saw how its done on internet and tried it  . Even then got the logic wrong for the first time . 
 * Needs review 
 */
public class Question4 {

	public static void main(String[] args) {
		Question4 q = new Question4();
		
		List<Integer> pallindromes = q.getPallindromicNumber();
		
		int maximum = 0;
		
		for (int x: pallindromes) {
			if (x > maximum) {
				maximum = x;
			}
		}
		System.out.println(maximum);
	}
	
	public List<Integer> getPallindromicNumber() {
		List<Integer> pallindromes = new ArrayList<Integer>();
		for (int i = 999; i >= 100; i--) {
			for (int j = 999; j >= 100; j--) {
				if (isPallindrome(i * j)) {
					System.out.println("numbers are " + i + ", " + j);
					pallindromes.add(i*j);
				}
			}
		}
		return pallindromes;
	}
	
	private boolean isPallindrome(int i) {
		StringBuffer s = new StringBuffer(i + "");
		if (s.toString().equals(s.reverse().toString())) {
			return true;
		} else {
			return false;
		}
	}

}
