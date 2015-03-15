package com.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// did not think fully for the first time and made a mistake . Second time , could do it by myself.
public class Question11 {
	
	private int n = 20;
	private int getGreatestRightProduct(int[][] a, int greatestProduct) {

		int product = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 3; j++) {
				product = a[i][j] * a[i][j + 1] * a[i][j + 2] * a[i][j + 3];
				if (product > greatestProduct) {
					greatestProduct = product;
				}
			}

		}
		return greatestProduct;
	}

	private int getGreatestDownProduct(int[][] a, int greatestProduct) {
		int product = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - 3; i++) {
				product = a[i][j] * a[i + 1][j] * a[i + 2][j] * a[i + 3][j];
				if (product > greatestProduct) {
					greatestProduct = product;
				}
			}
		}
		return greatestProduct;
	}

	private int getGreatestDiagnolDownProduct(int[][] a, int greatestProduct) {
		int product = 0;
		for (int i = 0; i < n - 3; i++) {
			for (int j = 0; j < n - 3; j++) {
				product = a[i][j] * a[i + 1][j + 1] * a[i + 2][j + 2]
						* a[i + 3][j + 3];
				if (product > greatestProduct) {
					greatestProduct = product;
				}
			}
		}
		return greatestProduct;

	}
	
	private int getGreatestDiagnolTopProduct(int [][] a, int greatestProduct) {
		int product = 0;
		for (int i = n - 1; i > 2; i--) {
			for (int j = 0; j < n - 3; j++) {
				product = a[i][j] * a[i - 1][j + 1] * a[i - 2][j + 2] * a[i - 3][j + 3];
				if (product > greatestProduct) {
					greatestProduct = product;
				}
			}
		}
		return greatestProduct;
	}
	
	
	public static void main(String [] args) {
		Question11 q = new Question11();
		
		int greatestProduct = 0;
		
		// populate int array
		int [][] a = q.populateArray();
		
		for (int i = 0; i < q.n; i++) {
			for (int j = 0; j < q.n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		greatestProduct = q.getGreatestRightProduct(a, greatestProduct); 
		greatestProduct = q.getGreatestDownProduct(a, greatestProduct);
		greatestProduct = q.getGreatestDiagnolDownProduct(a, greatestProduct);
		greatestProduct = q.getGreatestDiagnolTopProduct(a, greatestProduct);
		
		System.out.println("greatest product is " + greatestProduct);
	}
	
	
	// required validations
	private int [][]  populateArray() {
		int [][] a = new int [n][n];
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader (new File
					("/Users/admin/Documents/CommonWorkSpace/ProjectEuler/Files/Question11.txt")));
			String s = null;
			int row = -1;
			while ((s = fileReader.readLine()) != null) {
				String [] array = s.split(" ");
				row ++;
				for (int j = 0; j < n; j++) {
					Integer value = 0;
					try {
						value = Integer.parseInt(array[j]);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						value = 0;
					}
					a[row][j] = value;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader == null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return a;
	}
}