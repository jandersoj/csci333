package edu.unca.csci333;

public class BinarySearchTree<T> {
//	Implement another Java class named BinarySearchTree, based on a binary search tree from the slides / textbook. 
	
//	Your primary data field will be a BSTNode named root, to represent the root of the tree. 
	private BSTNode<?> root;
	
//	It will also contain a data field named size to record the number of elements stored in the tree. 
//	Insert should increment size, and delete should decrement size.
	int size;
	
//	Implement a zero-parameter constructor to set the root to NULL, and size to 0.

	public BinarySearchTree() {
		root = null;
		size = 0;
	}
//	Implement a getter method for size.
	public int getSize() {
		return size;
	}
	
//	Implement a private helper method named transplant, as in the slides/textbook. Invoke it when making the other methods below.
	private void transplant() {
		//TBD
	}
	
//	Implement the 7 dynamic set operations. Specifically:
	
//	Implement a private method for each of the 7 dynamic set operations as described in the slides/textbook: 
//	note that i did not put in params or returns
//	search
	private void search() {
		
	}
//	minimum 
	private void minimum() {
		
	}
//	maximum
	private void maximum() {
		
	}
//	successor
	private void successor() {
		
	}
//	predecessor 
	private void predecessor() {
		
	}
//	insert 
	private void insert(BSTNode input) {
		size++;
	}
//	delete
	private void delete() {
		size--;
	}
	
//	In addition to the pseudocode, insert should also increment the size data field, and delete should decrement the size data field. 
//	Private methods can use and refer to nodes.
	
//	Implement a public wrapper method (intended to be invoked by someone having a BinarySearchTree object),	for each of the 7 dynamic set operations:. 
//	Your public wrapper method will merely invoke the private helper method from the previous bullet-point. 
//	Nodes are not used in these public wrappers' parameters.
	
//	Implement the 3 tree traversal operations. Specifically:
	
//	Implement private recursive methods for the tree traversal preOrder, inOrder, and postOrder 
//	based on the three kinds of traversals discussed in the slides/textbook. 
//	"Visiting" a node means printing to standard output the key followed by 1 blank space.
	
//	Implement public wrapper methods for the tree traversal methods, which invoke the corresponding private traversal method.
	
//	Public wrappers should make it so that the main method does not deal with nodes, 
//	or should main need to provide the recursive argument to a recursive class method. 
//	So for example: from main, you can search by a type T (using the public wrapper) without providing provide the root node to search. 
//	For successor or predecessor, the public parameter can be of type T, and they will perform a private search to get a node,
//	to then use that node with the private predecessor or successor method.
}
