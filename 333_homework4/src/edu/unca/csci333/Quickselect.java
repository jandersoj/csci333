package edu.unca.csci333;
import java.util.*;

public class Quickselect<T extends Comparable<T>> {
	
	private T[] arr;
	private Random random;

	
	Quickselect(T[] arrIn){
//	Define a constructor that takes a T [ ] param handle 
//	and initializes a data field with a shallow copy from copying the array handle.
		this.arr = arrIn;
		this.random = new Random();		
	}
	
//	Define the private helper method partition, reused from the Quicksort assignment.
	/**
	 * Public method rearranging Quickselect arrays and subproblems so that:
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
	
	
//	Define a private helper method T randomizedQuickselect. 
//	Implement Randomized Quickselect as in the slides/textbook. 
//	One parameter is an array of type T [ ].  
//	Two more parameters are the inclusive bounds of the subarray to consider.
//	One more parameter is i, the order statistic to find in the parameter array. 
//	You are searching in the parameter array, not the data field array.
	private T randomizedQuickselect(int start, int end, int i) {
		if(start == end) // base case is length-1 subarray
			return arr[start];
		int rand = random.nextInt(end - start + 1) + start;// random int between p and r inclusive
		swap(rand, end);
		int q = partition(start, end); // the same PARTITION used in quicksort
		int k = q - start + 1; // calculate the local order statistic k of the pivot
		if(i == k) // check if pivot is the ith order statistic, our answer!
		   return arr[q];
		else if (i < rand) // we’re looking for an earlier order statistic
			return randomizedQuickselect(start, q-1, i);
		else return randomizedQuickselect(q+1, end, i-k);
	}
	
//	Define a public wrapper method T randomizedQuickselect, with only one parameter: the desired order statistic i.  
//	This public wrapper method will ensure that the select will occur nondestructively. 
//	Make a deep copy of the data field array to create another T [ ] of the same length filled with the same handles. 
//	Then, make the top level call of private randomizedQuickselect with the copied array. 
//	(As the private method rearranges this copy, the original data field array remains pristine.)
	public T randomizedQuickselect(int i) {
		T newArr[] = new T[arr.length];
		for(int j = 0; j < arr.length; j++) {
			newArr[j]  = arr[j];
		}
		return arr[0];
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
