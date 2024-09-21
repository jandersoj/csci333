package edu.unca.csci333;
import java.util.*;

/**
 * Josie Anderson
 * 09/20/2024
 * CSCI333
 * Homework 3
 */

/**
 * Public Quicksort class takes an array in the constructor 
 * and contains methods to sort and print the array.
 */

public class Quicksort<T extends Comparable<T>> {

	private T[] arr;
	
	private Random random;
	
	/**
	 * Public constructor method to construct a new Quicksort
	 * @param arrIn The array of values that Quicksort will copy and operate on.
	 */
	public Quicksort(T[] arrIn) {
		this.arr = arrIn;
		this.random = new Random();
	}
	
	/**
	 * Public method rearranging Quicksort arrays and subproblems so that:
	 * All elements less than or equal to the element at the end index are placed before it.
	 * All elements greater than it are placed after it.
	 *
	 * @param start The index to select the start of the partitioning interval.
	 * @param end The index to select the end of the partitioning interval.
	 * @return The index of the pivot element after being partitioned.
	 */
	private int partition(int start, int end) {
		T pivot = arr[end];
		int i = start-1;
		
		for(int j = start; j < end; j++) { 
		   if(arr[j].compareTo(pivot) <= 0) { // if the value is less than the pivot
		      i++;
		      swap(i, j); //it gets swapped left
		   }
		}
		swap(i+1, end); // put pivot between left and right sides
		return i+1; //returns the pivot point as q for quicksort.
	}
	
	/**
	* Private method that recursively quicksorts the array using the naive method.
	*
	* @param start starting index of the sorting interval.
	* @param end ending index of the sorting interval.
	*/	
	private void quicksortNaive(int start, int end) {
		if(start < end) {  // base case 
			int q = partition(start, end); // split into subproblems at q
			quicksortNaive(start, q - 1); //recursively sort
			quicksortNaive(q + 1, end);
		}
	}
	
	/**
	 * Top level call to quicksort the array with the naive method.
	 */
	public void quicksortNaive() {
		quicksortNaive(0, arr.length-1);
	}
		
	/**
	* Private method to recursively quicksort the array using the best-of-three method.
	*
	* @param start starting index of the sorting interval.
	* @param end ending index of the sorting interval.
	*/	
	private void quicksortBestOfThree(int start, int end) {
		if (start < end) {
			int pivot = arr[start].compareTo(arr[end]) <= 0 ? start : end;
			int middle = (end - start) / 2 + start;
			pivot = arr[start].compareTo(arr[middle]) <= 0 ? pivot : middle;
			swap(pivot, end);
			int q = partition(start, end);
			quicksortBestOfThree(start, q - 1);
			quicksortBestOfThree(q + 1, end);
		}
	}
	
	/**
	 * Top level call to quicksort the array with the best-of-three method.
	 */
	public void quicksortBestOfThree() {
		quicksortBestOfThree(0, arr.length -1);
	}
	
	/**
	* Private method to recursively quicksort the array using the randomized method.
	*
	* @param start starting index of the sorting interval.
	* @param end ending index of the sorting interval.
	*/	
	private void quicksortRandomized(int start, int end) {
		if (start < end){  // base case is the implied empty else case
			int rand = random.nextInt(end - start + 1) + start;// random int between p and r inclusive
			swap(rand, end);
			int q = partition(start, end); // split 2 subproblems at q
		    quicksortRandomized(start, q - 1);
		    quicksortRandomized(q + 1, end);
		}
	}
	
	/**
	 * Top level call to quicksort the array with the randomized method.
	 */
	public void quicksortRandomized() {
		quicksortRandomized(0, arr.length -1);
	}

	/**
	 * Public method to print the array
	 */
	public void printArr() {
		String str = "[";
		for(int i = 0; i < arr.length-1; i++) {
			str += arr[i] + ", ";
		}
		str += arr[arr.length-1] + "]";
	
		System.out.println(str);
	}
	
	/**
	 * Private method to swap the values at two indices
	 * 
	 * @param index1 the first index
	 * @param index2 the second index
	 */
	private void swap(int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
