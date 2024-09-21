package edu.unca.csci333;
import java.util.*;

//Your Quicksort class should be a Java Generic class that works on secondary type <T extends Comparable<T>>, 
//so we'll be able to use it to sort an array of any kind of comparable type. Quicksort class should contain:

public class Quicksort<T extends Comparable<T>> {

//	a private T[ ] data field to store an array
	private T[] arr;
	
	private Random random;
	
//	a public constructor that takes a T[ ] parameter and does a shallow copy (just copy the handle) into your T[ ] array data field
	public Quicksort(T[] arrIn) {
		this.arr = arrIn;
		this.random = new Random();
	}
	
//	Quicksort class should also have class methods:
	
	private int partition(int start, int end) {
//		which does a partition as we discussed in class, on the subarray from start to end inclusive, using the last element at index end as the pivot.	
		T pivot = arr[end];
		int i = start-1;
		
		for(int j = start; j < end; j++) { // j is loop variable. Iterate through subarray.
		   if(arr[j].compareTo(pivot) <= 0) { // we find a “small” value less than the pivot x
		      i++;
		      swap(i, j); // The “small” element goes left
		   }
		}
		swap(i+1, end); // put pivot between left and right sides
		return i+1; // This is the index q in QUICKSORT
	}
	
		
	private void quicksortNaive(int start, int end) {
//		a recursive quicksort method with inclusive bounds. It naively uses the subproblem's last element at index end as the pivot. 
//		Invoke your partition method as a helper method.
		if(start < end) {  // base case is the implied empty else case
			int q = partition(start, end); // split 2 subproblems at q
			quicksortNaive(start, q - 1);
			quicksortNaive(q + 1, end);
		}
	}
	
	public void quicksortNaive() {
//		with 0 params, a wrapper for the top level call of the private quicksortNaive
		quicksortNaive(0, arr.length-1);
	}
	
	private void quicksortBestOfThree(int start, int end) {
//		a recursive quicksort method with inclusive bounds. 
//		It chooses its pivot as the median of the three values at index start, index end, and the index halfway between start and end. 
//		Find that pivot, swap that pivot to index end, then invoke the same partition method.
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
	
	public void quicksortBestOfThree() {
//		with 0 params, a wrapper for the top level call of the private quicksortBestOfThree
		quicksortBestOfThree(0, arr.length -1);
	}
	
	private void quicksortRandomized(int start, int end) {
//		a recursive quicksort method with inclusive bounds. 
//		It chooses its pivot as a random element of the array between index start and index end, inclusive. 
//		Find that pivot, swap that pivot to index end, then invoke the same partition method.
		
		if (start < end){  // base case is the implied empty else case
			int rand = random.nextInt(end - start + 1) + start;// random int between p and r inclusive
			swap(rand, end);
			int q = partition(start, end); // split 2 subproblems at q
		    quicksortRandomized(start, q - 1);
		    quicksortRandomized(q + 1, end);
		}
	}
	
	public void quicksortRandomized() {
		quicksortRandomized(0, arr.length -1);
	}

	public void printArr() {
		String str = "[";
		for(int i = 0; i < arr.length-1; i++) {
			str += arr[i] + ", ";
		}
		str += arr[arr.length-1] + "]";
	
		System.out.println(str);
	}
	
	private void swap(int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
