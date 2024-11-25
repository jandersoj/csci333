package edu.unca.csci333;

public class BSTNode<T extends Comparable<T>> {
//	Implement a Java class named BSTNode, to represent one node of a binary search tree from the slides/textbook. 
//	The private data fields should be BSTNode handles p, left, and right, 
	private BSTNode<T> parent;
	private BSTNode<T> left;
	private BSTNode<T> right;
//	as well as a data element of Java generic type T such that <T extends Comparable<T>>
	private T data;
	
//	Implement a constructor method with T parameter. It will set p left and right to NULL, and the data element to the constructor parameter.
	public BSTNode(T input) {
		this.parent = null;
		this.left = null;
		this.right = null;
		this.data = input;
	}
	
//	Implement getter methods for the data element, p, left, and right, to return the relevant data field.
	public T getData() {
		return this.data;
	}
	
	public BSTNode<T> getParent() {
		return this.parent;
	}
	
	public BSTNode<T> getLeft() {
		return this.left;
	}
	
	public BSTNode<T> getRight() {
		return this.right;
	}
	
//	Implement setter methods for p left and right, to set the relevant data field to the parameter; copy the handle.
//	 copy the handle???
	public void setParent(BSTNode<T> input) {
		this.parent = input;
	}
	
	public void setLeft(BSTNode<T> input) {
		this.left = input;
	}
	
	public void setRight(BSTNode<T> input) {
		this.right = input;
	}
}
