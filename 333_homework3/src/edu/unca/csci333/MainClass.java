package edu.unca.csci333;

/**
 * Josie Anderson
 * 09/20/2024
 * CSCI333
 * Homework 3
 */

/**
 * Public Main class containing instantiations of new Quicksort objects
 * and tests of public methods in the Quicksort class.
 */
public class MainClass {
	
	/**
	 * Public main method creates and tests Quicksort objects and methods
	 */
	public static void main(String[] args) {
		System.out.println("quicksortNaive:");
		Integer[] arr1 = new Integer[] {8,41,1,35,32,13,44,7,29,30,9,3,42,43,11,34,22,49,33,39};
		Integer[] arr2 = new Integer[] {34,36,4,7,26,25,5,28,18,33,10,21,48,35,45};
		Integer[] arr3 = new Integer[] {49,9,28,14,42,25,41,36,38,11,4,33,34,8,2};
		Integer[] arr4 = new Integer[] {17,6,34,14,16,5,37,19,41,33,48,50,20,38,24};
		Integer[] arr5 = new Integer[] {49,31,11,17,12,47,48,20,38,8,22,27,23,7,21};
			
		Quicksort q1 = new Quicksort(arr1);
		Quicksort q2 = new Quicksort(arr2);
		Quicksort q3 = new Quicksort(arr3);
		Quicksort q4 = new Quicksort(arr4);
		Quicksort q5 = new Quicksort(arr5);
		
		q1.printArr();
		q1.quicksortNaive();
		q1.printArr();
		System.out.println();

		q2.printArr();
		q2.quicksortNaive();
		q2.printArr();
		System.out.println();

		q3.printArr();
		q3.quicksortNaive();
		q3.printArr();
		System.out.println();

		q4.printArr();
		q4.quicksortNaive();
		q4.printArr();
		System.out.println();

		q5.printArr();
		q5.quicksortNaive();
		q5.printArr();
		
		System.out.println();
		
		
		
		System.out.println("quicksortRandomized:");
		arr1 = new Integer[] {8,41,1,35,32,13,44,7,29,30,9,3,42,43,11,34,22,49,33,39};
		arr2 = new Integer[] {34,36,4,7,26,25,5,28,18,33,10,21,48,35,45};
		arr3 = new Integer[] {49,9,28,14,42,25,41,36,38,11,4,33,34,8,2};
		arr4 = new Integer[] {17,6,34,14,16,5,37,19,41,33,48,50,20,38,24};
		arr5 = new Integer[] {49,31,11,17,12,47,48,20,38,8,22,27,23,7,21};
		
		q1 = new Quicksort(arr1);
		q2 = new Quicksort(arr2);
		q3 = new Quicksort(arr3);
		q4 = new Quicksort(arr4);
		q5 = new Quicksort(arr5);

		
		q1.printArr();
		q1.quicksortRandomized();
		q1.printArr();
		System.out.println();

		q2.printArr();
		q2.quicksortRandomized();
		q2.printArr();
		System.out.println();

		q3.printArr();
		q3.quicksortRandomized();
		q3.printArr();
		System.out.println();

		q4.printArr();
		q4.quicksortRandomized();
		q4.printArr();
		System.out.println();

		q5.printArr();
		q5.quicksortRandomized();
		q5.printArr();
		
		
		System.out.println();
		
		
		
		System.out.println("quicksortBestOfThree:");
		arr1 = new Integer[] {8,41,1,35,32,13,44,7,29,30,9,3,42,43,11,34,22,49,33,39};
		arr2 = new Integer[] {34,36,4,7,26,25,5,28,18,33,10,21,48,35,45};
		arr3 = new Integer[] {49,9,28,14,42,25,41,36,38,11,4,33,34,8,2};
		arr4 = new Integer[] {17,6,34,14,16,5,37,19,41,33,48,50,20,38,24};
		arr5 = new Integer[] {49,31,11,17,12,47,48,20,38,8,22,27,23,7,21};
		q1 = new Quicksort(arr1);
		q2 = new Quicksort(arr2);
		q3 = new Quicksort(arr3);
		q4 = new Quicksort(arr4);
		q5 = new Quicksort(arr5);
		
		q1.printArr();
		q1.quicksortBestOfThree();
		q1.printArr();
		System.out.println();

		q2.printArr();
		q2.quicksortBestOfThree();
		q2.printArr();
		System.out.println();

		q3.printArr();
		q3.quicksortBestOfThree();
		q3.printArr();
		System.out.println();

		q4.printArr();
		q4.quicksortBestOfThree();
		q4.printArr();
		System.out.println();

		q5.printArr();
		q5.quicksortBestOfThree();
		q5.printArr();
		
		System.out.println();
				
	}

}
