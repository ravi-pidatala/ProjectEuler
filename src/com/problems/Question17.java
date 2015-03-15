package com.problems;

// solved it wrong for the first time . Later solved it myself.
public class Question17 {

	int hundredAnd = 10;
	int hundredAndsum = 90 * hundredAnd;
	int firstDigitSum = (getOneToTen() - 3) * 10;
	
	public static void main(String[] args) {
		Question17 q = new Question17();
		int a1 = q.getAllFirstTens();
		int a2 = q.getAllSecondTens();
		int a3 = q.getAllthirdTens();
		int a4 = q.getAllFourTens();
		int a5 = q.getAllFiveTens();
		int a6 = q.getAllSixTens();
		int a7 = q.getAllSevenTens();
		int a8 = q.getAllEightTens();
		int a9 = q.getAllNineTens();
		int a10 = q.getAllTenNines();
		int a11 = q.getHundredFactorSum();
		
		System.out.println(a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + a11);
	}
	
	private int getOneToTen() {
		return 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4 + 3;
	}
	
	private int getElevenToTwenty() {
		return 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8 + 6;
	}
	
	/*
	 * twenty one,
	 * twenty two
	 * twenty three
	 * thenty four 
	 * 
	 * 
	 * twenty nine
	 * thirty 
	 *    = getSumOfOneToNine + 6 * 9(i.e. sum of twenty 9 times)  + 6 (i.e. value of thirty)
	 */
	private int getTwentyOnetoThirty() {
		return (getOneToTen() - 3) + (6 * 9) + 6;  // "twenty" = 6, thirty = 6
	}

	private int getThirtyOnetoForty() {
		return (getOneToTen() - 3) + 6 * 9 + 5; // "forty" = 5, "thirty" = 6 
 	}
	
	private int getFortyOnetoFifty() {
		return (getOneToTen() - 3) + 5 * 9 + 5;  // fifty = 5
	}
	
	private int getFiftyOnetoSixty() {
		return getFortyOnetoFifty(); // sixty = 5
	}
	
	private int getSixtyOnetoSeventy() {
		return (getOneToTen() - 3) + 5 * 9 + 7; // seventy = 7
	}
	
	private int getSeventyOnetoEighty() {
		return (getOneToTen() - 3) + 7 * 9 + 6; // eighty = 6
	}
	
	private int getEightyOnetoNinety() {
		return (getOneToTen() - 3) + 6 * 9 + 6; // ninenty = 6. 
	}
	
	/*
	 * ninety one 
	 * ninety two
	 * ninety three
	 * 
	 * ninety nine
	 */
	private int getNinetyOneToNinentyNine() {
		return (getOneToTen() - 3) + 6 * 9;
	}
	
	
	/*
	 * one hundred
	 * two hundred
	 * three hundred
	 * 
	 * 
	 * nine hundered
	 * one thousand - 3 + 8
	 */
	private int getHundredFactorSum() {
		return (getOneToTen() - 3) + 7 * 9 + 3 + 8;// including "one thousand" = 8; "hundred"=7
	}
	
/*
 * 1 to 10 ,101 to 110, 201 to 210, 301 to 310, 401 to 410, 501 to 510, 601 to 610 ... 901 to 910.
 */
	private int getAllFirstTens() {
		int lastdigitSum = 10 * getOneToTen();
		return firstDigitSum + hundredAndsum + lastdigitSum;
	}
	
	private int getAllSecondTens() {
		int lastdigitSum = 10 * getElevenToTwenty();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	
	private int getAllthirdTens() {
		int lastdigitSum = 10 * getTwentyOnetoThirty();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	
	private int getAllFourTens() {
		int lastdigitSum = 10 * getThirtyOnetoForty();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	
	private int getAllFiveTens() {
		int lastdigitSum = 10 * getFortyOnetoFifty();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	private int getAllSixTens() {
		int lastdigitSum = 10 * getFiftyOnetoSixty();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	private int getAllSevenTens() {
		int lastdigitSum = 10 * getSixtyOnetoSeventy();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	private int getAllEightTens() {
		int lastdigitSum = 10 * getSeventyOnetoEighty();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	
	private int getAllNineTens() {		
		int lastdigitSum = 10 * getEightyOnetoNinety();
		return firstDigitSum + lastdigitSum + hundredAndsum;
	}
	
	// 91 to 99, 191 to 199, 291 to 299, 391 to 399, 491 to 499,  ... ,991 to 999
	private int getAllTenNines() {
		int firstDigitSum = (getOneToTen() - 3) * 9;
		int hundredAndSum = hundredAnd * 9 * 9;
		int lastdigitsum = 10 * getNinetyOneToNinentyNine();
		return firstDigitSum + hundredAndSum + lastdigitsum;
	}
}
