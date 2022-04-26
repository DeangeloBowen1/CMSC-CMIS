package project3;

public class InvalidTreeSyntax extends Exception {

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
	
	/*
	 * Child class which throws exceptions based on string user input 
	 * @InvalidTreeSyntax
	 * */
	private static final long serialVersionUID = 1L;

	public InvalidTreeSyntax() {
		super();
	}

	public InvalidTreeSyntax(String message) {
		super(message);
	}
}