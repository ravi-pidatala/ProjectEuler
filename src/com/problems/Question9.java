package com.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * solved partly myself and partly by looking internet . Forgot to cast double value.needs review.
 */
public class Question9 {

	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 1; i <= 499; i++) {
			
			int numerator =  (500000 - (1000 * i));
			int denominator = 1000 - i;
			
			double value = (double)numerator /denominator;
//			int intValue = (int) value;
//			
//			if (value == intValue) {
//				values.add(intValue);
//			}
			if (value % 1 == 0) {

				// exactly two numbers will get into the list
				values.add((int)value);
			}
		}
		
		for (int x: values) {
			System.out.println(x);
		}
		int a = values.get(0);
		int b = values.get(1);
		int c = 1000 - a - b;
		
		System.out.println(a * b * c);
	}

}
