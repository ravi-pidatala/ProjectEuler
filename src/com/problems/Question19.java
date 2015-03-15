package com.problems;

/**
 * leap year has 366 days .. 1900 is not a leap year .. 
 * Jan 1st 1900 --monday  - 0th day 
 * Jan 7th 1900 -- sunday. -- 6th day (6 % 7 = 6) 
 * Dec 1st 1900 -- 334th day
 * Dec 31st 1900 -- 364th day 
 * jan 1st 1901 --  365th day i.e. (365) % 7 = 1 i.e monday 
 *
 */
public class Question19 {

	public static void main(String[] args) {
		Question19 q = new Question19();
		System.out.println(q.getNumberOfFirstMonthSunday(334, 1901, 2000, 1, 12));
	}
	
	
	 public int getNumberOfFirstMonthSunday(int days, int startYear, int endYear, int startMonth, int endMonth) {
		 	//TODO validate inputs.
		 	int result = 0;
		 	int month = startMonth;
		 	int year = startYear;
		 	
		 	while (year < endYear || (year == endYear && month <= endMonth)) {
		 		switch (month) {
		 		// jan, march, may, july, aug, oct, dec has 31 days
		 			case 2 : // if current month is feb, calculate number of days in jan.
		 			case 4 :// if current month is april, calculate number of days in march.
		 			case 6 : 
		 			case 8 :
		 			case 9 :
		 			case 11 :
		 			case 1:
						 days = days + 31;
						 if (days % 7 == 6) {
							 System.out.println("year:" + year + " month :" + month);
						 	result ++;
						 }				
		 			month++;
		 			break;
		 			case 12 :
		 				days = days + 30; // prev month , nov has 30 days
							 if (days % 7 == 6) {
								 System.out.println("year:" + year + " month :" + month);
						 		result ++;
						 	}				
		 				month = 1;
		 				year++;
		 				break;
		 			case  3: 
		 				boolean leapYear = false;
		 				if (year % 4 == 0) {
		 					if (year % 100 == 0) {
		 						//CENTURY . 
		 						if (year % 400 == 0) {
		 							leapYear = true;
		 						} else {
		 							leapYear = false;	
		 						}
		 					} else {
		 						leapYear = true;
		 					}
		 				} else {
		 					leapYear = false;
		 				}	
		 			
		 				if (leapYear) {
		 					days = days + 29;
		 				} else {
		 					days = days + 28;
		 				}
		 				if (days % 7 == 6) {
		 					System.out.println("year:" + year + " month :" + month);
							result++;
		 				}
		 				month++;
		 				break;
		 				
		 				//april, june, sep  has 30 days.
		 			case 5:
		 			case 7 :
		 			case 10:
		 				 days = days + 30;
						 if (days % 7 == 6) {
							System.out.println("year:" + year + " month :" + month);
						 	result ++;
						 }				
		 			month++;
		 			break;
		 			
		 			default:
		 				System.out.println("invalid month");
		 				month = 1;
		 				break;
		 			}			
		 		}
		 	return result;
		 	} 
		 }
