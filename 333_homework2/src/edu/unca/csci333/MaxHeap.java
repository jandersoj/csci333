package edu.unca.csci333;
import java.util.Arrays;

/**
 * Josie Anderson
 * 09/09/2024
 * CSCI333
 * Homework 2
 */

/**
 * Public MaxHeap class takes an array in the constructor to create 
 * a heap and contains methods to sort and print the heap.
 */
public class MaxHeap<T extends Comparable<T>> {
	
	/**
	 * An array of values that makes up the heap.
	 */
	private T[] heap;
		
	/**
	 * An int that tracks the number of elements in the heap.
	 */
	private int heapsize;

	/**
	 * Public constructor method to construct a new MaxHeaps and fill
	 * it with the values from an array.
	 * @param heapIn The array of values to fill the new MaxHeap
	 */
	public MaxHeap(T[] heapIn) {
		heap = Arrays.copyOfRange(heapIn, 0, heapIn.length);
		heapsize = heap.length;	
		buildMaxHeap();
	}
		
	/**
	 * Private method to return the index of the left child of a node.
	 * @param i The index of the "parent" node.
	 * @return The index of the parent's left child.
	 */
	private int leftChildOf(int i) {
		int childIndex = (i*2) +1;
		
		if(i > heapsize-1 || childIndex > heapsize-1)
			return -1;
		
		return childIndex;
	}
	
	/**
	 * Private method to return the index of the right child of a node.
	 * @param i The index of the "parent" node.
	 * @return The index of the parent's right child.
	 */
	private int rightChildOf(int i) {
		int childIndex = (i*2+1)+1;
		
		if(i > heapsize-1 || childIndex > heapsize-1)
			return -1;
		
		return childIndex;
	}
	
	/**
	 * Public method to print the heapsize and the contents of the heap. 
	 */
	public void printMaxHeap(){
		System.out.println("heapsize:"+heapsize);

		T[] printHeap = Arrays.copyOfRange(heap, 0, heapsize);
		System.out.println(Arrays.toString(printHeap));
	}
	
	/**
	 * Private recursive method to correct the max heap property.
	 * @param i The index on which to begin/continue the maxHeapify method.
	 */
	private void maxHeapify(int i) {
		int largest = i; //index of the largest
		int left = leftChildOf(i); //index of the l. child
		int right = rightChildOf(i); //index of the r. child
		
		if(left > -1) {
			if(left <= heapsize && heap[left].compareTo(heap[i]) > 0) { //if left is in heap and bigger than parent
				largest = left;
			} else largest = i;
		}
		
		if(right > -1) {
			if(right <= heapsize && heap[right].compareTo(heap[largest]) > 0) { //if right is in heap and bigger than largest
				largest = right;
			}
		}
		
		if(largest != i) { //if either child is larger than the parent or largest is not the parent
			swap(i, largest); //swap them/their indices
			
			maxHeapify(largest); //and rework this new parent one
		}
	}
	
	
	/**
	 * Private method to build a MaxHeap, calls maxHeapify repeatedly
	 * to maintain max heap property.
	 */
	private void buildMaxHeap() {
		for(int i = heapsize/2; i >= 0; i--) {
			maxHeapify(i);
		}
	}
	
	/**
	 * Public method to sort a heap in reverse order (from largest to smallest)
	 */
	public void heapsort() {
		
		buildMaxHeap();
		
		int ogHeapsize = heapsize; //soon we will be altering heapsize
		
		for(int i = heapsize-1; i >= 0;  i--) {
			swap(0, i);
			heapsize--; //old last element is new root
			maxHeapify(0); //fix at root
		}
		heapsize = ogHeapsize;
	}

	/**
	 * Private method to swap the values at two indices.
	 * @param index1 The index of the first value.
	 * @param index2 The index of the second value.
	 */
	private void swap(int index1, int index2) {
		T temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
