package finalProject;

public interface DFSActions<V> {
	
	/*Deangelo Bowen 
	 * CMSC 350 7837
	 * UMGC
	 * 
	 * ---------------------------------------------------------------------------------------------
	 * This module was created by direction of the UMGC CMSC 350 7837 week 8, project 4, guidelines:
	 * The fourth programming project involves writing a program that accepts information contained 
	 * in a file about the class dependencies in a Java program and creates a directed graph from that 
	 * information.
	 * 
	 * From the directed graph, it produces two different kinds of displays of those dependency 
	 * relationships.
	 * ---------------------------------------------------------------------------------------------
	 */

	public void processVertex(V vertex);

	public void descendVertex(V vertex);

	public void ascendVertex(V vertex);

	public void cycleDetected();
}