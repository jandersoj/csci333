package edu.unca.csci333;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("ChainedHashTable tests:");
	//create table:
		ChainedHashTable<Integer> test1 = new ChainedHashTable(20);
		int[] arr = {99, 62, 60, 17, 66, 70, 1, 11, 88, 81, 21, 60, 15, 69, 7, 61, 79, 93, 79, 70};
		Integer[] values = intsToIntegers(arr);
		System.out.println("Empty ChainedHashTable:");
		System.out.println(test1.toString());
	//fill table:
		for(int i = 0; i < values.length; i++) {
			test1.insert(values[i]);
		}
		System.out.println("ChainedHashTable after inserting 20 elements:");
		System.out.println(test1.toString());
	//delete from table:
		test1.delete(values[4]);
		test1.delete(values[7]);
		test1.delete(values[12]);
		System.out.println("ChainedHashTable after deleting 3 elements:");
		System.out.println(test1.toString());
	//search present keys:
		System.out.println("Any element(s) with key "+values[6].hashCode() +" are in the LinkedList "+test1.search(values[6].hashCode()));
		//I didn't return the index above because it said the "handle", and wouldn't that be the LinkedList itself?


	}

	//takes an array of ints and converts them to Integers. Secret for testing. I hate typing repetitive lines.
	private static Integer[] intsToIntegers(int[] ints) {
		Integer[] out = new Integer[ints.length];
		for(int i = 0; i < ints.length; i++) {
			out[i] = Integer.valueOf(ints[i]);
		}
		return out;	
	}

}
