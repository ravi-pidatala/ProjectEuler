package com.problems;
/*
 * Could solve it after viewing answer online.
 * better to be solved on paper. 
 */
import java.util.ArrayList;
import java.util.List;

public class Question24 {

	private static int index = 32319; // 32320 - 1
	
	public static void main(String[] args) {
		Question24 q = new Question24();
		List<String> permutations = new ArrayList<String>();
		String s = "01345689";
		char [] cArray = s.toCharArray();
		q.listPermutations(cArray, permutations, 0);
		String [] permutationsArray = new String[permutations.size()];
		permutationsArray = permutations.toArray(permutationsArray);
		System.out.println("converted arraylist into array");
		
		q.quickSort(permutationsArray, 0, permutationsArray.length - 1);
		
		for(int i = 0; i < permutationsArray.length; i++) {
			System.out.print(permutationsArray[i] + ",");
		}
		System.out.println();
		System.out.println(permutationsArray[index]);
		
	}
	
	public void listPermutations(char [] cArray, List<String> permutations, int start) {
 	 	 if (start == cArray.length - 1) {
	 	 	String s = new String(cArray);
	 	 	permutations.add(s);
	 	 	return;
	 	 }
	 	   
	 	   for (int i = start; i < cArray.length; i++) {
	 	  		listPermutations(cArray, permutations, start + 1);
	 	  		rotate(cArray, start);  
	 	   }
	 }
	 
	 private void rotate(char [] cArray, int start) {
	 	char temp = cArray[start];
	 	for (int i = start; i < cArray.length - 1; i++) {
	 		cArray[i] = cArray[i + 1];
	 	}	
	 	cArray[cArray.length - 1] = temp;
	 }
	 
	 public void quickSort(String [] permutationsArray, int start, int end) {
		 if (start >= end) {
			 return;
		 }
		 
		 // consider pivot as middle element. put it onto last.
		 int pI = (start + end) / 2;
		 swap(permutationsArray, pI, end);
		 
		 String pivotString = permutationsArray[end];
		 
		 int left = start;
		 int right = end - 1;
		 while (left <= right) {
			 while (left <= right && permutationsArray[left].compareTo(pivotString) < 0) {
				 left++;
			 }
			 while (left <= right && permutationsArray[right].compareTo(pivotString) > 0) {
				 right--;
			 }
			 if (left <= right) {
				 swap(permutationsArray, left, right);
			 }
		 }
		 
		 // swap pivot and left
		 swap(permutationsArray, left, end);
		 
		 //System.out.println("pivot index is " + left + " value is " + permutationsArray[left]);
		 
		 quickSort(permutationsArray, start, left - 1);
		 quickSort(permutationsArray, left + 1, end);
		 
	 }
	 
	 private void swap(String [] permutationsArray, int left, int right) {
		 String temp = permutationsArray[left];
		 permutationsArray[left] = permutationsArray[right];
		 permutationsArray[right] = temp;
	 }
}
