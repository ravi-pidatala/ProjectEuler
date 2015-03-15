package com.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question13 {

	public static void main(String[] args) {
		Question13 q13 = new Question13();
		List<String> numberStringList = new ArrayList<String>();
		numberStringList = q13.getNumberString("/Users/admin/Documents/CommonWorkSpace/ProjectEuler/Files/question13.txt");
		int sum = q13.getCarryOverSum(numberStringList);
		int [] digits = new int[10];
		
		for (int i = 9; i >= 0; i--) {
			for (String s: numberStringList) {
				String digit = s.substring(i, i + 1);
				int number = Integer.parseInt(digit);
				sum = sum + number;
				
			}
			digits[i] = sum % 10;
			sum = sum / 10;
		}
		StringBuffer sb = new StringBuffer(new Integer(sum).toString());
		
		for (int i = 0; i < digits.length; i++) {
			sb.append(digits[i]);
		}
		
		if (sb.length() >= 10) {
			System.out.println(sb.toString().substring(0, 10));
		} else {
			System.out.println("error occured"); // write good error message
		}
	}
	
	public List<String> getNumberString(String path) {
		List<String> numberStringList = new ArrayList<String>();
		BufferedReader reader = null;
		String s = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			while ((s = reader.readLine()) != null) {
				s = s.trim();
				if (s.length() != 50 || s.substring(0, 1).equals("0")) {
					System.out.println("invalid string" + s);
				} else {
					numberStringList.add(s);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return numberStringList;
	}

	public int getCarryOverSum(List<String> numberStringList) {
		int sum = 0;
		int number = 0;
		for (int i = 49; i > 9; i--) {
			for (String s: numberStringList) {
				String digit = s.substring(i, i + 1);
				try {
					number = Integer.parseInt(digit);
					
				} catch (NumberFormatException e) {
					System.err.println(e);
					
					number = 0;
				}
				sum = sum + number;
			}
			sum = sum / 10;
		}
		return sum;
	}
}
