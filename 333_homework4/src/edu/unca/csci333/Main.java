package edu.unca.csci333;

import java.util.Arrays;
import java.util.Random;

public class Main {
			
	/**
	 * Main method for testing Quickselect and countingSort
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();		
//	Quickselect tests
		System.out.println("Quickselect tests:");
		Integer[] arr1 = randIntegerArray(0, 250);
		Quickselect<Integer> test1 = new Quickselect<Integer>(arr1);
		runTestsQS(test1, arr1.length);
		
		Integer[] arr2 = randIntegerArray(0, 250);
		Quickselect<Integer> test2 = new Quickselect<Integer>(arr2);
		runTestsQS(test2, arr2.length);
		
		Character[] arr3 = randCharacterArray();
		Quickselect<Character> test3 = new Quickselect<Character>(arr3);
		runTestsQS(test3, arr3.length);
		
		Character[] arr4 = randCharacterArray();
		Quickselect<Character> test4 = new Quickselect<Character>(arr4);
		runTestsQS(test4, arr4.length);
		
//	countingSort tests:
		System.out.println("countingSort tests:");
		System.out.println();
		int[] cs1 = randIntArray(0, 250);
		System.out.println("unsorted: "+Arrays.toString(cs1));
		System.out.println("sorted: "+Arrays.toString(countingSort(cs1)));
		
		System.out.println();
		int[] cs2 = randIntArray(0, 250);
		System.out.println("unsorted: "+Arrays.toString(cs2));
		System.out.println("sorted: "+Arrays.toString(countingSort(cs2)));
		
		System.out.println();
		int[] cs3 = randIntArray(0, 250);
		System.out.println("unsorted: "+Arrays.toString(cs3));
		System.out.println("sorted: "+Arrays.toString(countingSort(cs3)));
	}	
	
	/**
	 * Private function to sort an array of int[] from smallest to largest
	 * @param toSort Copied array to be sorted
	 * @param arrOut Sorted array output
	 * @param largestInput The maximum number in the input array. 
	 */
	private static void countingSort(int[] toSort, int[] arrOut, int largestInput) {

		int[] counter = new int[largestInput+1];

		for(int i = 0; i < toSort.length; i++){
			counter[toSort[i]]++;
		}

		for(int i = 1; i <= largestInput; i++) {
			counter[i] += counter[i-1];
		}
		
		for(int i = toSort.length-1; i >=0 ; i--) {
			arrOut[counter[toSort[i]]-1] = toSort[i];
			counter[toSort[i]]--;
		}
	}
		
	/**
	 * Public wrapper for the countingSort method, creates a deep copy of the array to be sorted.
	 * @param arrIn Array to be copied and sorted
	 * @return Sorted array
	 */
	public static int[] countingSort(int[] arrIn) {
		int max = arrIn[0];
		for(int i = 0; i < arrIn.length; i++) {
			if(arrIn[i] > max) max = arrIn[i];
		}
		
		int[] arrOut = new int[arrIn.length];
		
		countingSort(arrIn, arrOut, max);
		return arrOut;
	}
	
	/**
	 * Public printing method
	 * @param <T> Type parameter to work with various types
	 * @param arrIn The array to be printed
	 */
	public static <T> void printArr(T[] arrIn) {
		String str = "[";
		for(int i = 0; i < arrIn.length-1; i++) {
			str += arrIn[i] + ", ";
		}
		str += arrIn[arrIn.length-1] + "]";
		System.out.println(str);
	}
	
	
	/**
	 *Various private methods for testing:
	 */
	private static void runTestsQS(Quickselect<?> in, int len){
		System.out.println("Unsorted array: " + in.toString());
		System.out.println("1st order stat.: " + in.randomizedQuickselect(1));
		System.out.println("10th order stat.: " + in.randomizedQuickselect(10));
		System.out.println("Last order stat.: " + in.randomizedQuickselect(len));
		System.out.println("Median: " + in.randomizedQuickselect((len+1)/2));
		System.out.println();
		System.out.println("------------------------------");
	}
	
 	private static Integer[] randIntegerArray(int min, int max) {
		Random r = new Random();		
		int length = r.nextInt(19)+10;
		Integer[] arr = new Integer[length];
		for(int i = 0; i < length; i++) {
			arr[i] = Integer.valueOf(r.nextInt(max - min + 1) + min);
		}
		return arr;
	}
	
	private static int[] randIntArray(int min, int max) {
		Random r = new Random();	
		int length = r.nextInt(19)+10;
		int[] arr = new int[length];
		for(int i = 0; i < length; i++) {
			arr[i] = r.nextInt(max - min + 1) + max;
		}
		return arr;
	}
	
	private static Character[] randCharacterArray(){
		Random r = new Random();
		int length = r.nextInt(19)+10;
		Character[] arr = new Character[length];
		char c;
		for(int i = 0; i < length; i++) {
			c = (char)(r.nextInt(52)+'A'); //note that capital letters are sorted to the left of lowercase
			arr[i] = Character.valueOf(c);
		}
		return arr;
	}
}
