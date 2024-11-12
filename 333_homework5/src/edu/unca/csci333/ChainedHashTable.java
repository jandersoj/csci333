package edu.unca.csci333;
import java.util.*;

public class ChainedHashTable<T> {
//	Implement a Java class named ChainedHashTable, based on a hash table with chaining using the multiplication method from the slides/textbook. 
//	Your should use an array of LinkedList<T> as your primary instance variable / data field.
	LinkedList<T>[] data;
	
//	The constructor should have a parameter for n, the total number of inputs expected. 
	@SuppressWarnings("unchecked")
	public ChainedHashTable(int n) {
//	In the constructor, create the array of size m as the first power of 2 larger than n, 
//	full of constructed but empty linked lists at each index. 

		int m = nextLargestPowOf2(n);
		data = new LinkedList[m];
		for(int i = 0; i < m; i++) {
			data[i] = new LinkedList<T>();
		}
	}
	
//	There should also be public methods for insert, delete, and search as in the slides/textbook.
	public void insert(T key) {
		int index = hash(key);
		data[index].add(key);
	}
//	Define a toString method for the entire hash table, which runs a loop and 
//	concatenates each linked list in the hash table into the returned String; 
//	consider using the LinkedList class's toString method.s
	
	
//	You will need a private helper method named hash. 
//	Given an int key parameter, it computes and returns an int index of the table.
	private int hash(int key) {
		double A = 0.6180339887;
		return (int) Math.floor(data.length*(key*A%1));
	}
	
//  5 points extra credit: Use a Universal collection of hash functions instead of the multiplication method, for the ChainedHashTable class above. 
//	The the prime number p > m and the randomly constants a and b should be chosen in the constructor.
//	Make sure your prime number selection is runtime-efficient! If you need help with this math algorithm 
//	to find the next prime number bigger than natural number m, I recommend going to the Math Lab in the 3rd floor of RRO.

	private static int nextLargestPowOf2(int num) {
		int next = 1; 
		while (next < num)
			next <<= 1;
		return next;
	}
}