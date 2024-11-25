package edu.unca.csci333;
import java.util.*;

public class ChainedHashTable<T> {
//	Implement a Java class named ChainedHashTable, based on a hash table with chaining using the multiplication method from the slides/textbook. 
//	Your should use an array of LinkedList<T> as your primary instance variable / data field.
	private LinkedList<T>[] table;
	private double A;
	private int m;
	
//	The constructor should have a parameter for n, the total number of inputs expected. 
	public ChainedHashTable(int n) {
//	In the constructor, create the array of size m as the first power of 2 larger than n, 
//	full of constructed but empty linked lists at each index. 

		m = nextLargestPowOf2(n);
		table = new LinkedList[m];
		for(int i = 0; i < m; i++) {
			table[i] = new LinkedList<T>();
		}
	}
	
//	There should also be public methods for insert, delete, and search as in the slides/textbook.
	public void insert(T element) {
		int index = hash(element.hashCode()); //so this is taking the key (item.hashCode()) and hashing that to calculate the index
		table[index].addFirst(element); //and then at that index it is inserting the element itself, NOT the key.
	}	//perfect.
	
	public void delete(T element) {
		int index = hash(element.hashCode());
		table[index].remove(element);
	}
	
//	for each index i, T[i] is a handle to the element of key i.
	public LinkedList<T> search(int key) {
		int targetIndex = hash(key);
		System.out.println(key+" hashed to "+targetIndex);
		if(table[targetIndex] != null) return table[targetIndex];
		return null;		
	}
	
//	Define a toString method for the entire hash table, which runs a loop and 
//	concatenates each linked list in the hash table into the returned String; 
//	consider using the LinkedList class's toString method.
	public String toString() {
		String out = "";
		for(int i = 0; i < m; i++) {
			out += table[i].toString();
		}
		return out;
	}
	
	
//	You will need a private helper method named hash. 
//	Given an int key parameter, it computes and returns an int index of the table.
	private int hash(int key) {
		A = 0.6180339887;
		System.out.println("hashed "+key+" to "+ (int)(m*((key*A)%1)));
		return (int)(m*((key*A)%1)); //i THINK this is right
	}
	
//  5 points extra credit: Use a Universal collection of hash functions instead of the multiplication method, for the ChainedHashTable class above. 
//	The the prime number p > m and the randomly constants a and b should be chosen in the constructor.
//	Make sure your prime number selection is runtime-efficient! If you need help with this math algorithm 
//	to find the next prime number bigger than natural number m, I recommend going to the Math Lab in the 3rd floor of RRO.

	private static int nextLargestPowOf2(int num) {
		int next = 1; 
		while (next < num)
			next *= 2;
		return next;
	}
}