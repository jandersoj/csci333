package edu.unca.csci333;
import java.util.*;

public class Quickselect<T extends Comparable<T>> {
	
	private T[] arr;
	private Random random;
	/**
	 * Constructor method for a Quickselect object
	 * @param arrIn Input for the Quickselect's array
	 */
	Quickselect(T[] arrIn){
		this.arr = arrIn;
		this.random = new Random();		
	}

	/**
	 * Public method rearranging Quickselect arrays and subproblems so that:
	 * All elements less than or equal to the element at the end index are placed before it.
	 * All elements greater than it are placed after it.
	 *
	 * @param start The index to select the start of the partitioning interval.
	 * @param end The index to select the end of the partitioning interval.
	 * @return The index of the pivot element after being partitioned.
	 */
	private int partition(T[] arrIn, int start, int end) {
		T pivot = arrIn[end];
		int i = start-1;
		
		for(int j = start; j < end; j++) { 
		   if(arrIn[j].compareTo(pivot) <= 0) { // if the value is less than the pivot
		      i++;
		      if(i != j)swap(arrIn, i, j); //it gets swapped left
		   }
		}
		swap(arrIn, i+1, end); // put pivot between left and right sides
		return i+1; //returns the pivot point as q for quicksort.
	}
	
	
	/**
	 * Private recursive randomized Quickselect method to locate and select a given order statistic.
	 * @param arrIn The array to be searched/selected from
	 * @param start The beginning of the array
	 * @param end The end of the array
	 * @param i The order statistic to be selected
	 * @return Either returns the selected value or recursively calls into subarrays.
	 */
	private T randomizedQuickselect(T[] arrIn, int start, int end, int i) {
		if(start == end)
			return arrIn[start];
		
		int rand = random.nextInt(end - start + 1) + start;
		swap(arrIn, rand, end);
		
		int q = partition(arrIn, start, end);
		int k = q - start + 1; // calculate the local order statistic k of the pivot
		
		if(i == k)
		   return arrIn[q];
		else if (i < k)
			return randomizedQuickselect(arrIn, start, q-1, i);
		else return randomizedQuickselect(arrIn, q+1, end, i-k);
	}
	
	/**
	 * Public wrapper method for randomizedQuickelect, passes in a new deep copy of source array.
	 * @param i the target order statistic
	 * @return a call to the recursive function randomizedQuickselect with the copied array
	 */
	public T randomizedQuickselect(int i) {
		T newArr[] = (T[])new Comparable[arr.length];
		int j;
		for(j = 0; j < arr.length; j++) {
			newArr[j]  = arr[j];
		}
		return randomizedQuickselect(newArr, 0, arr.length-1, i); 
	}
	
	/**
	 * Public method to return a string representation of the array
	 * @return a string representation of the array
	 */
	public String toString() {
		String str = "[";
		for(int i = 0; i < arr.length; i++) {
			str += arr[i] + ", ";
		}
		str += arr[arr.length-1] + "]";
		return str;
	}
		
	/**
	 * Private method to swap the values at two indices
	 * 
	 * @param index1 the first index
	 * @param index2 the second index
	 */
	private void swap(T[] arrIn, int index1, int index2) {
		T temp = arrIn[index1];
		arrIn[index1] = arrIn[index2];
		arrIn[index2] = temp;
	}

}
