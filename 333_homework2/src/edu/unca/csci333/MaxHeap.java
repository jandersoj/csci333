package edu.unca.csci333;
import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {
	
//	
//Define a MaxHeap class. It should have:
	
//1.	A private data field (member variable) of type T array. 
//	This array will be used to store the heap at all times. 
//	T will be a Java generic type required to be <T extends Comparable<T>> by the MaxHeap class.
	private T[] heap;
	
	
//2. 	A private data field of type int called heapsize. 
//	Array indices 0 to heapsize - 1 are defined to be "in the heap," and any values after that are not. 
//	You may write your code with one-indexing or zero-indexing. Bear in mind the pseudocode uses one indexing!
	private int heapsize;


//3. 	A public constructor method with a T array parameter.  
//	This constructor will take a T array filled with arbitrary values as a parameter, 
//	make a copy of it into its data field array made the same length, set heapsize to the array length, 
//	and then invoke buildMaxHeap (see below). 
//	You may want to use the java.util.Arrays.copyOfRange method in the constructor, or you can do it yourself.
	public MaxHeap(T[] heapIn) {
		heap = Arrays.copyOfRange(heapIn, 0, heapIn.length);
		heapsize = heap.length;	
	}
		
	
//4.	A private method named leftChildOf, which takes an index parameter. 
//	Return the index where the left child is stored. 
//	Indices beyond the end of the heap have no children, so return -1. 
//	If the left child is beyond the end of the heap, return -1. 
//	Don't forget the zero indexing!
		private int leftChildOf(int index) {
		return index;
	}
	
	
//5.	A private method named rightChildOf, which takes an index parameter. 
//	Return the index where the right child is stored.  
//	Indices beyond the end of the heap have no children, so return -1.  
//	If the right child is beyond the end of the heap, return -1. 
//	Don't forget the zero indexing!
	private int rightChildOf(int index) {
		return index;
	}
	
//6.	A public method named printMaxHeap to write out the contents of its array data field to standard output in a nicely formatted print statement. 
//	Print out the heapsize, and then only print the values of indices 0 through heapsize-1 inclusive. 
//	You can do this yourself, or use the java.util.Arrays.toString method. 
//	You must only print indices from 0 to heapSize-1 inclusive, 
//	so you may want to use java.util.Arrays.copyOfRange before invoking java.util.Arrays.toString.
	public void PrintMaxHeap(){
		System.out.println("PrintMaxHeap not implemented yet");
	}
	
//7.	A private recursive method named maxHeapify based on the MAX-HEAPIFY method, 
//	whose pseudocode is in the textbook and the slides. 
//	Make sure to invoke your leftChildOf and rightChildOf methods to obtain the indices of the two children. 
//	The only parameter will be the index, because the array itself is a class member variable and thus need not be a parameter. 
//	Remember the heap ends at index heapsize-1 inclusive.
	
	
//8.	A private method buildMaxHeap based on the BUILD-MAX-HEAP method, 
//	whose pseudocode is in the textbook and the slides. 
//	This is a loop that invokes maxHeapify. 
//	It has no parameters since the array is a class member variable. 
//	Remember the heap ends at index heapsize-1 inclusive.
	
	
//9.	public method named heapsort, based on the HEAPSORT method, 
//	whose pseudocode is in the textbook and the slides. 
//	This method has no parameters, since the array is a class member variable.  
//	It will use buildMaxHeap and maxHeapify. Remember the heap ends at index heapsize-1 inclusive. 
//	This method modifies heapsize continuously, 
//	so remember to restore a backup copy of heapsize after the sorting is done.

}
