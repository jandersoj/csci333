package edu.unca.csci333;
import java.util.Arrays;

/**
 * Josie Anderson
 * 09/09/2024
 * CSCI333
 * Homework 2
 */

/**
 * Public Main class containing instantiations of new MaxHeap objects
 * and tests of public methods in the MaxHeap class.
 */
public class Main {

	/**
	 * Main class
	 */
	public static void main(String[] args) {
		

//		For each object:
//		Print out the original array that it was constructed from 
//		Print out the heap with printMaxHeap. 
//		Invoke heapsort.
//		Print out the heap again with printMaxHeap. 
//		In the console you should notice all the values are sorted.
		
		System.out.println("Test 1:");
		Integer[] arr1 = new Integer[] {3, 6, 4, 5, 9, 7};
		MaxHeap test1 = new MaxHeap<Integer>(arr1);
		System.out.println("Original array: "+Arrays.toString(arr1));
		test1.printMaxHeap();
		test1.heapsort();
		test1.printMaxHeap();
		System.out.println();
		
		System.out.println("Test 2:");
		Integer[] arr2 = new Integer[] {80,45,79,11,44,2,92,40,62,37};
		MaxHeap test2 = new MaxHeap<Integer>(arr2);
		System.out.println("Original array: "+Arrays.toString(arr2));
		test2.printMaxHeap();
		test2.heapsort();
		test2.printMaxHeap();
		System.out.println();

		System.out.println("Test 3:");
		Integer[] arr3 = new Integer[] {99,72,42,11,52,74,40,67,81,31,89,25,32,24,93};
		MaxHeap test3 = new MaxHeap<Integer>(arr3);
		System.out.println("Original array: "+Arrays.toString(arr3));
		test3.printMaxHeap();
		test3.heapsort();
		test3.printMaxHeap();
		System.out.println();

		System.out.println("Test 4:");
		String[] arr4 = new String[] {"Aa", "Xx", "Cc", "Ss", "Bb", "Tt"};
		MaxHeap test4 = new MaxHeap<String>(arr4);
		System.out.println("Original array: "+Arrays.toString(arr4));
		test4.printMaxHeap();
		test4.heapsort();
		test4.printMaxHeap();
		System.out.println();

		System.out.println("Test 5:");
		String[] arr5 = new String[] {"Macaroni", "Jennifer", "Caiman", "Komodo", "Jinx", "Juniper", "Jasper", "Sadie", "Finnegan"};
		System.out.println("Original array: "+Arrays.toString(arr5));
		MaxHeap test5 = new MaxHeap<String>(arr5);
		test5.printMaxHeap();
		test5.heapsort();
		test5.printMaxHeap();
		System.out.println();
	}
}
