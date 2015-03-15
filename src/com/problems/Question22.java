package com.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
/*
 * REVIEW MERGESORT AGAIN. HAD DIFFICULT TIME DOING IT.
 * REVIEW QUICKSORT . HAD DIFFICULTY IN IMPLEMENTING IT.
 * 
 */
public class Question22 {

	public static void main(String[] args) {
		Question22 q = new Question22();
		String [] namesArray = q.getNames();
		String [] tempArray = q.getCopy(namesArray);
		
		//q.quickSortArray(namesArray, 0, tempArray.length - 1); // namesArray is sorted.
		q.mergeSort(tempArray, namesArray, 0, tempArray.length - 1); // namesArray is sorted.
		
		int totalRank = 0;
		for (int i = 0; i < namesArray.length; i++) {
			String s = namesArray[i];
			int rank = q.getRank(s);
			totalRank = totalRank + rank * (i + 1);
//			//System.out.println(namesArray[i]);
//			if (namesArray[i].equals("COLIN")) {
//				System.out.println(i + 1);
//				System.out.println(q.getRank(namesArray[i]));
//			}
		}
		System.out.println(totalRank);
		
		
		
	}
	
	private int getRank(String s) {
		char [] charArr = s.toCharArray();
		int rank = 0;
		int charRank = 0;
		for (int i =0; i < charArr.length; i++) {
			charRank = charArr[i] - 64;
			rank = charRank + rank;
		}
		return rank;
	}
	
	public void mergeSort(String [] tempArray, String [] namesArray, int start, int end) {
		
		if (start == end) {
			return;
		}
			int middle = (start + end) / 2;
			mergeSort(tempArray, namesArray, start, middle);
			mergeSort(tempArray, namesArray, middle + 1 , end); 
			merge(tempArray, namesArray, start, middle, end);
		}
		
	private void merge(String [] tempArray, String [] namesArray, int start, int middle, int end) {
		int helperLeft = start;
		int helperRight = middle + 1;
		int index = start;
		
		// copy the sorted array into tempArray
		for (int i = start; i <= end; i++) {
			tempArray[i] = namesArray[i];
		}
		
		
		while (helperLeft <= middle && helperRight <= end) {
			if (tempArray[helperLeft].compareTo(tempArray[helperRight]) < 0) {
				namesArray[index ++] = tempArray[helperLeft++];
			} else {
				namesArray[index++] = tempArray[helperRight++];
			}
		}
		while (helperLeft <= middle) {
			namesArray[index++] = tempArray[helperLeft++];
		}	
	}
	
	private String[] getCopy(String [] namesArray) {
		String [] tempArray = new String [namesArray.length];
		
		for (int i = 0; i < namesArray.length;i++) {
			tempArray[i] = namesArray[i];
		}
		return tempArray;
	}

	
	// sort the array of Strings
	public void quickSortArray(String [] namesArray, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int index = partition(namesArray, start, end);
		
		// sort the left half.
		quickSortArray(namesArray, start, index -1);
		
		//sort the right half
		quickSortArray(namesArray, index, end);
		
	}
	
	
	private int partition(String [] arr, int left, int right) {
		String pivot = arr[(left + right) / 2];
		while (left <= right) {
			while (arr[left].compareTo(pivot) < 0) {
				left++;
			}
			
			while (arr[right].compareTo(pivot) > 0) {
				right--;
			}
			if (left <= right) {
				swap(arr, left,right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	private void swap(String [] namesArray, int leftP, int rightP) {
		String temp = namesArray[leftP];
		namesArray[leftP] = namesArray[rightP];
		namesArray[rightP] = temp;
	}
	// read names from text doc and get into the arraylist.
	public String [] getNames() {
		String [] namesArray = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					new File("/Users/admin/Documents/CommonWorkSpace/ProjectEuler/Files/question22.txt")));
			String s = null;
			int lines = 0;
			while ((s = reader.readLine()) != null) {
				s = s.replaceAll("\"", "");
				namesArray = s.split(",");
				lines++;
				if (lines > 1) {
					System.out.println("error");
					break;
				}
			}
			return namesArray;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return namesArray;
	}
}
