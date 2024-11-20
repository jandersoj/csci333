package edu.unca.csci333;

public class BSTNode<T extends Comparable<T>> {
//	Implement a Java class named BSTNode, to represent one node of a binary search tree from the slides/textbook. 
//	The private data fields should be BSTNode handles p, left, and right, 
	private BSTNode<T> parent;
	private BSTNode<T> left;
	private BSTNode<T> right;
//	as well as a data element of Java generic type T such that <T extends Comparable<T>>
	public T data;
	
//	Implement a constructor method with T parameter. It will set p left and right to NULL, and the data element to the constructor parameter.
	public BSTNode(T input) {
		parent = null;
		left = null;
		right = null;
		data = input;
	}
	
//	Implement getter methods for the data element, p, left, and right, to return the relevant data field.
	public T getData() {
		return null;
	}
	
	public BSTNode<T> getParent() {
		return parent;
	}
	
	public BSTNode<T> getLeft() {
		return left;
	}
	
	public BSTNode<T> getRight() {
		return right;
	}
	
//	Implement setter methods for p left and right, to set the relevant data field to the parameter; copy the handle.
//	 copy the handle???
	public void setParent(BSTNode<T> input) {
		parent = input;
	}
	
	public void setLeft(BSTNode<T> input) {
		left = input;
	}
	
	public void setRight(BSTNode<T> input) {
		right = input;
	}
}
