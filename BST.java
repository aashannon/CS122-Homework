
/**
 * A Binary Search Tree is a Binary Tree with the following
 * properties:
 * 
 * For any node x: (1) the left child of x compares "less than" x; 
 * and (2) the right node of x compares "greater than" x
 *
 *
 * @param <T> the type of data object stored by the BST's Nodes
 */
public class BST<T extends Comparable<T>> {

	/**
	 * The root Node is a reference to the 
	 * Node at the 'top' of a QuestionTree
	 */
	private Node<T> root;
	
	
	/**
	 * Construct a BST
	 */
	public BST() {
		root = null;
	}
	
	/**
	 * @return the root of the BST
	 */
	public Node<T> getRoot() { 
		return root;
	}
	
	/**
	 * _Part 1: Implement this method._
	 *
	 * Add a new piece of data into the tree. To do this, you must:
	 * 
	 * 1) If the tree has no root, create a root node 
	 *    with the supplied data
	 * 2) Otherwise, walk the tree from the root to the bottom
	 *    (i.e., a leaf) as though searching for the supplied data.
	 * Then:
	 * 3) Add a new Node to the leaf where the search ended.
	 *
	 * @param data - the data to be added to the tree
	 */
	public void add(T data) {
		// Created a Root node if one doesn't exist, create pointer equal to root
		// Check data against parent then if depending on value, check if left or right is null
		// if null add, if not set pointer to next node

		Node<T> pointer = root;
		boolean added = false;

		if (root != null){
			 while (added == false){
				 if (pointer.data.compareTo(data) > 0){
					 if (pointer.left != null){
						 pointer = pointer.left;

					 }else{
						 pointer.left = new Node<>(data);
						 pointer.left.parent = pointer;
						 added = true;

					 }

				 } else if (pointer.data.compareTo(data) < 0) {
					 if (pointer.right != null){
						 pointer = pointer.right;

					 }else{
						 pointer.right = new Node<>(data);
						 pointer.right.parent = pointer;
						 added = true;

					 }
				 }

			 }
		} else{
			root = new Node<T>(data);
		}
		return;
	}
	

	/**
	 * _Part 2: Implement this method._
	 * 
	 * Find a Node containing the specified key and
	 * return it.  If such a Node cannot be found,
	 * return null.  This method works by walking
	 * through the tree starting at the root and
	 * comparing each Node's data to the specified 
	 * key and then branching appropriately.
	 * 
	 * @param key - the data to find in the tree
	 * @return a Node containing the key data, or null.
	 */
	public Node<T> find(T key) {
		// Set finder to root, as finder is !null, compare 'key' values
		// continue to check left and right leafs until 'key' value matches
		// else return null

		Node<T> finder = root;

		while(finder != null){
			if (finder.data.compareTo(key) == 0) { return finder; }
			 else if (finder.data.compareTo(key) > 0) { finder = finder.left; }
				else if (finder.data.compareTo(key) < 0) { finder = finder.right; }

		}
		return null;

	}

	/**
	 * _Part 3: Implement this method._
	 *  
	 * @return the Node with the largest value in the BST
	 */
	public Node<T> maximum() {
		// use 'max' pointer to check right leaf if not null
		// continue until pointer finds null, return max.
		// return null if no nodes

		Node<T> max = root;

		if (root != null){
			while(max.right != null){
				max = max.right;
			}
			return max;
		}
		return null;
	}
	
	/**
	 * _Part 4: Implement this method._
	 *  
	 * @return the Node with the smallest value in the BST
	 */
	public Node<T> minimum() {
		// use 'min' pointer to check left leaf if not null
		// continue until pointer finds null, return min
		// return null if no nodes

		Node<T> min = root;

		if (root != null){
			while(min.left != null){
				min = min.left;
			}
			return min;
		}
		return null;
	}

	/**
	 * _Part 5: Implement this method._
	 *
	 *  Assuming no two nodes contain equal data in the tree,
	 *  this method takes a node n with data d, and should
	 *  return the node that stores the value which appears
	 *  immediately after d in the sorted order, or null
	 *  if no such node exists.
	 *
	 *  Thus, for a tree containing data: 1, 3, 5, 10 (regardless
	 *  of the order they were added) the successor of the node
	 *  containing 1 should be the node containing 3.
	 *
	 * @param n a node in the BST
	 * @return the Node in the BST whose value is next in the sorted ordering
	 *   of all keys, or null if no such node exists
	 */
	public Node<T> successor(Node<T> n) {
		// First check if right node exists, then check if left node exist
		// return pointer if left is null, otherwise continue to set pointer until null

		// if node is has no leafs, check if parent is null, until left is !null
		// return parent if left is !null

		Node<T> pointer = n;

		if (pointer.right != null){
			pointer = pointer.right;

			if (pointer.left == null){ return pointer;}
			else{
				while (pointer.left != null){ pointer = pointer.left;}
				return pointer;}

		} else {
			while(pointer.parent != null){if(pointer.parent.left == pointer){
					return pointer.parent;

				}else{ pointer = pointer.parent;}
			}
		}
		return null;
	}
	
	/**
	 * _Part 6: Extra Credit! Implement this method._
	 *  
	 * Searches for a Node with the specified key.
	 * If found, this method removes that node
	 * while maintaining the properties of the BST.
	 * 
	 * Note that the CLRS TreeDelete pseudo code
	 * nearly meets the requirements of this method, 
	 * however, it does not always return the correct
	 * value; your implementation should return a
	 * a reference to the removed Node.
	 *
	 * @return the Node that was removed or null.
	 */
	public Node<T> remove(T data) {
		// TODO: implement this
		return null;
	}
	
	/**
	 * 
	 * The Node class for our BST.  The BST
	 * as defined above is constructed from zero or more
	 * Node objects. Each object has between 0 and 2 children
	 * along with a data member that must implement the
	 * Comparable interface.
	 * 
	 * @param <T>
	 */
	public static class Node<T extends Comparable<T>> {
		private Node<T> parent;
		private Node<T> left;
		private Node<T> right;
		private T data;
		
		private Node(T d) {
			data = d;
			parent = null;
			left = null;
			right = null;
		}
		public Node<T> getParent() { return parent; }
		public Node<T> getLeft() { return left; }
		public Node<T> getRight() { return right; }
		public T getData() { return data; }
	}
}
