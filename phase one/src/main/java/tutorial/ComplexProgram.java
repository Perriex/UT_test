package tutorial;

import java.util.EmptyStackException;

public class ComplexProgram {

    // Java program to search a given key in a given BST

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

class BinarySearchTree {
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// A utility function to insert
	// a new node with given key in BST
	Node insert(Node node, int key) {
		// If the tree is empty, return a new node
		if (node == null) {
			node = new Node(key);
			return node;
		}

		// Otherwise, recur down the tree
		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);

		// Return the (unchanged) node pointer
		return node;
	}

	// Utility function to search a key in a BST
	Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
			return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

}

}
