package project3;

import java.util.EmptyStackException;
import java.util.Stack;

public class BinaryTree {
	
	/*---------------------------------------------------------------------------------------------
	 * DeAngelo Bowen
	 * CMSC 350
	 * 4/22/2022
	 * 
	 * This script is created in accordance to the UMGC CMSC 350
	 * Week 3 Project Guidelines
	 * 
	 * The third programming project involves writing a program that allows the user to enter a binary tree in a
	 * parenthesized prefix format and then allows it to be categorized and allows various features of that tree to be
     * displayed.
	 * ---------------------------------------------------------------------------------------------
	 */

	Node parent, child;
	

/*---------------------------------------------------------------------------------------------
@BinaryTree : constructor |  Takes the string and turns it into an array sorted by parens.
---------------------------------------------------------------------------------------------*/
	
	public BinaryTree(String input) throws InvalidTreeSyntax {
		Stack<Node> nodeStack = new Stack<>();
		String[] inputArray = input.substring(1, input.length() - 1)
				.split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))");
		parent = new Node(inputArray[0]);  // sets the new first character to the root of the Array
		
		for (int i = 1; i < inputArray.length - 1; i++) { //pushes child attribute to parent until array is complete
			if (inputArray[i].equals("(")) {
				nodeStack.push(parent);
				if (child != null) {
					parent = child;
				}
//assign the current parent = child on stack
			} else if (inputArray[i].equals(")")) {
				try {
					child = parent;
					parent = nodeStack.pop();
				} catch (EmptyStackException emptyStack) {
					throw new InvalidTreeSyntax("Incorrect parenthesis!");
				}
//else, assign variable to child 
			} else {
				child = new Node(inputArray[i]);
				if (parent != null) {
					parent.addChild(child);
				}
				
				// @addChild to throw @InvalidTreeSyntax
			}
		} 
		if (this.recNodes(parent) * 3 != input.length())
			throw new InvalidTreeSyntax("Incorrect Syntax");
	}
	
/*---------------------------------------------------------------------------------------------
@checkBalanced : determine the value 1 is the absolute difference.
Then, call the recursive method, which will then call the recursive height method.
---------------------------------------------------------------------------------------------*/
	public boolean isBalanced() {
		return recIsBalanced(this.parent);
	}

	private boolean recIsBalanced(Node root) {

		if (root == null) {
			return true;
		}
		
		return (Math.abs(recHeight(root.left) - recHeight(root.right)) <= 1)
				&& (recIsBalanced(root.left) && recIsBalanced(root.right)); // and calls recursively
	}

	/*---------------------------------------------------------------------------------------------
	@checkFull : checks a binaryTree for th maximum amount of nodes
	---------------------------------------------------------------------------------------------*/
	public boolean isFull() {
		return recIsFull(this.parent, recHeight(this.parent), 0);
	}

	private boolean recIsFull(Node root, int height, int index) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return (height == index + 1);
		}
		if (root.left == null || root.right == null) {
			return false;
		}
//recursive call to both children
		return recIsFull(root.left, height, index + 1) && recIsFull(root.right, height, index + 1);

	}


/*----------------------------------------------------------------------------
 * @isProper : checks Binary tree for either 2 or 0 children.
 * ---------------------------------------------------------------------------
 */
	public boolean isProper() {
		return recIsProper(this.parent);
	}

	private boolean recIsProper(Node root) {

		if (root == null) {
			return true;
		}
//returns true or false based on children
		return ((root.left != null || root.right == null) && (root.left == null || root.right != null))
				&& (recIsProper(root.left) && recIsProper(root.right)); // and calling recursively
	}

/*---------------------------------------------------------------------------
@height : finds the height of the binary tree
---------------------------------------------------------------------------*/
	public int height() {
		return recHeight(this.parent) - 1;
	}


	private int recHeight(Node root) {

		return (root == null) ? 0 : 1 + Math.max(recHeight(root.left), recHeight(root.right));

	}

/*---------------------------------------------------------------------------
@nodes : finds the amount of nodes in a binary tree
---------------------------------------------------------------------------*/
	public int nodes() {
		return recNodes(this.parent);
	}

	private int recNodes(Node root) {
		return (root == null) ? 0 : 1 + recNodes(root.left) + recNodes(root.right);
	}

/*---------------------------------------------------------------------------
@inOrder : prints the info of the nodes in the binary tree in order.
---------------------------------------------------------------------------*/
	public String inOrder() {
		return recInOrder(this.parent);
	}

	private String recInOrder(Node root) {
		return (root == null) ? "" : "(" + recInOrder(root.left) + root.info + recInOrder(root.right) + ")";
	}

	@Override
	public String toString() {
		return parent.toString();
	}

	public static class Node {
		private String info;
		private Node left;
		private Node right;

		public Node(String info) {
			this.info = info;
		}

		private void addChild(Node child) throws InvalidTreeSyntax {

			if (this.left == null) {
				this.setLeft(child);
			} else if (this.right == null) {
				this.setRight(child);
			} else {
				throw new InvalidTreeSyntax("Nodes can only have 2 children!");
			}
		}


		private void setLeft(Node newLeft) {
			left = newLeft;
		}

		private void setRight(Node newRight) {
			right = newRight;
		}

		@Override
		public String toString() {
			return toString(this);
		}

		private static String toString(Node root) {
			return (root == null) ? "" : "(" + root.info + toString(root.left) + toString(root.right) + ")";
		}
	}
}
