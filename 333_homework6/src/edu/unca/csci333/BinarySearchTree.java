package edu.unca.csci333;

public class BinarySearchTree<T extends Comparable<T>> {
//	Implement another Java class named BinarySearchTree, based on a binary search tree from the slides / textbook. 
	
//	Your primary data field will be a BSTNode named root, to represent the root of the tree. 
	private BSTNode<T> root;
	
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
	private void transplant(BSTNode<T> u, BSTNode<T> v) {
		if(u.getParent() == null) {
			this.root = v;
		} else if (u == u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		} else u.getParent().setRight(v);

		if(v != null) {
			v.setParent(u.getParent());
		}
	}
	
//	Implement the 7 dynamic set operations. Specifically:
	
//	Implement a private method for each of the 7 dynamic set operations as described in the slides/textbook: 
//	search
	private BSTNode<T> search(BSTNode<T> start, T target) {
		if(start == null) return null; //if empty subtree
		if(target == start.getData()) return start; //if target is at root
		if(target.compareTo(start.getData()) < 0) return search(start.getLeft(), target); //search left subtree
		else return search(start.getRight(), target); //search right subtree
	}
//	minimum 
	private BSTNode<T> minimum(BSTNode<T> node) {
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}
//	maximum
	private BSTNode<T> maximum(BSTNode<T> node) {
		while(node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}
//	successor
	private BSTNode<T> successor(BSTNode<T> node) {
		if(node.getRight() != null) return minimum(node.getRight()); //min of right subtree
		while((node.getParent() != null) && (node == node.getParent().getRight())) { //else find left parent
			node = node.getParent();
		}
		return node.getParent();
	}
//	predecessor 
	private BSTNode<T> predecessor(BSTNode<T> node) {
		if(node.getLeft() == null) return maximum(node.getLeft()); //max of left subtree
		while((node.getParent()  != null)&&(node == node.getParent().getLeft())) { //else find right parent
			node = node.getParent();
		}
		return node.getParent();
	}
//	insert 
	private void insert(BSTNode<T> newNode) {
		BSTNode<T> pointer = null;
		BSTNode<T> x = this.root;
		
		while(x != null) {
			pointer = x;
			if(newNode.getData().compareTo(x.getData()) < 0) {
				x = x.getLeft();
			} else x = x.getRight();
		}
		newNode.setParent(pointer);
		
		if(pointer == null) {
			this.root = newNode;
		} else if (newNode.getData().compareTo(pointer.getData()) < 0) {
			pointer.setLeft(newNode);
		} else pointer.setRight(newNode);
		size++;
	}
//	delete
	private void delete(BSTNode<T> node) {
		//deleting node z
		if(node.getLeft() == null) transplant(node, node.getRight()); //c1: left child is null
		else if(node.getRight() == null) transplant(node, node.getRight()); //c2: right child is null
		else { //c3: neither child is null
			BSTNode<T> y = minimum(node.getRight()); //find node's successor y 
			if(y.getParent() != node) {
				transplant(y, y.getRight());
				y.setRight(node.getRight());
				y.getRight().setParent(y);
			}
			transplant(node, y);
			y.setLeft(node.getLeft());
			y.getLeft().setParent(y);
		}
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
	
//NOT FINISHED
	private void preOrder(BSTNode<T> node) {
		if(node != null) {
			System.out.println(node.getData() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	private void inOrder(BSTNode<T> node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.println(node.getData() + " ");
			inOrder(node.getRight());
		}
	}
	
	private void postOrder(BSTNode<T> node) {
		if(node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.println(node.getData() + " ");
		}
	}
	
//	Implement public wrapper methods for the tree traversal methods, which invoke the corresponding private traversal method.
	
//	Public wrappers should make it so that the main method does not deal with nodes, or should main need to provide the recursive argument to a recursive class method. 
//	So for example: from main, you can search by a type T (using the public wrapper) without providing provide the root node to search. 
//	For successor or predecessor, the public parameter can be of type T, and they will perform a private search to get a node,
//	to then use that node with the private predecessor or successor method.
	
	
//also NOT finished!!
	public void preOrder(T data) {
		preOrder(root);
	}
	
	public void inOrder(T data) {
		inOrder(root);
	}
	
	public void postOrder(T data) {
		postOrder(root);
	}
}