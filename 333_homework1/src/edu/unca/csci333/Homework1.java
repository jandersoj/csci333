package edu.unca.csci333;

/*
 * Josie Anderson
 * 08/29/2024
 * CSCI333
 * Homework 1
 * 
 * Contains and tests a "trinary search" method. 
 */

public class Homework1 {

	/**
	 * Main method, instantiates arrays of integers and tests trinarySearch method
	 * @param args Any command line arguments
	 */
	public static void main(String[] args) {
		int[] test1 = {2,3,4,5,6,7,8,9,10,12,13,14,15,17,17,20,21,22,24,25,27};
		int[] test2 = {1,1,7,9,10,14,14,15,17,19,20,20,21,22,22,24,26,26,33,33,37,39,39,40,41,42,43,45,47,48,52,58,64,66,71,74,77,78,79,79,80,82,87,88,89,93,96,96,97,100};
		int[] test3 = {7};
		int[] test4 = {2,31,31,58};
		int[] test5 = {2,12};


		trinarySearch(test1, 17, 0, 20);
		trinarySearch(test1, 11, 0, 20);
		
		trinarySearch(test2, 33, 0, 49);
		trinarySearch(test2, 76, 0, 49);

		trinarySearch(test3, 18, 0, 0);
		
		trinarySearch(test4, 58, 0, 3);
		
		trinarySearch(test5, 12, 0, 1);
		trinarySearch(test5, 14, 0, 1);
	}
	
	/**
	 * Completes a "trinary search" of a given sorted array, splitting it into three 
	 * subsections and recursively searching each one until the leftmost instance of 
	 * the queried value is found. Returns the index of the found value, or -1 if not found.
	 * 
	 * @param arr The array in which to search for the value.
	 * @param val The integer value being searched for.
	 * @param index1 The index of arr at which to begin searching.
	 * @param index2 The index or arr  at which to stop searching.
	 * @return The index of the value's leftmost instance, if found. Otherwise returns -1.	 
	 */
	
	public static int trinarySearch(int[] arr, int val, int index1, int index2) {
		
		int subsection = index2 - index1;
		
		System.out.println("Searching " + toString(arr, index1, index2) + " for " + val);
//		System.out.println("Subsection size: "+subsection);
		
//		If the section is too small to be split further AND val is > its smallest member
		if(subsection < 3 && arr[index1] <= val) {
			for(int i = index1; i <= index2; i++) { //iterate through and check each index
//				System.out.println("Checking "+arr[i]);
				if(arr[i] == val) {
					System.out.println("Found "+val+" at i="+i);
					System.out.println();
					return i;
				}
			}
		}
		
		if(subsection >= 3) { //If it is large enough to be split into 3
			int split1 = index1 + (subsection/3); //calculating fairly even boundaries
			int split2 = index2 - (subsection/3);
			
//			System.out.println("Subsections: "+arr[index1]+ "-"+arr[split1]+", "+ arr[split1+1] +"-"+arr[split2]+", "+ arr[split2+1] +"-"+ arr[index2]);
			
			if(arr[index1] <= val && arr[split1] >= val) { //if val could be in leftmost section
				return trinarySearch(arr, val, index1, split1);
			}
			
			if(arr[split1] < val && arr[split2] >= val) { //if it could be in the center
				return trinarySearch(arr, val, split1+1, split2);
			}
			
			if(arr[split2] < val && arr[index2] >= val) { //if it could be in the rightmost
				return trinarySearch(arr, val, split2+1, index2);
			}
		}
		
		//finally, if it couldn't be in any of them;
		System.out.println("Not found!");
		System.out.println();
		return -1;
	}
	
	
	//just a toString to print arrays for testing
	private static String toString(int[] array, int index1, int index2) {
		String out = "[";
		for(int i = index1; i < index2; i++) {
			out += array[i] +",";
		}
		out += array[index2] + "]";
		
		return out;
	}
}




