package finalProject;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	static DirectedGraph graph = new DirectedGraph();

	public void readGraph() {

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

// Open file reader window
		JFileChooser choice = new JFileChooser(new File("."));
		int option = choice.showOpenDialog(null);

//check if user selected a valid file then proceed further
		if (option == JFileChooser.APPROVE_OPTION) {
			try {
// Take input from user input file using Scanner class from Java Utility
				Scanner input = new Scanner(choice.getSelectedFile());
				while (input.hasNextLine()) {
					String edgeString = input.nextLine();
					String[] edge = edgeString.split(" ");

// Marks the first node of the graph
					if (graph.startingNode == null)
						graph.startingNode = graph.getVertex(edge[0]);

// add edges to the Directed graph
					for (int i = 1; i < edge.length; i++) {
						graph.addEdge(edge[0], edge[i]);
					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

// Initializing Main Class
		System.out.println("DeAngelo Bowen CMSC 350 7837");
		System.out.println("Project 4 - Final Project");
		
		new Main().readGraph();
		graph.depthFirstSearch();
		System.out.println(graph.parenthesizedList.toString());
		System.out.println(graph.hierarchy.toString());
		graph.displayUnreachableClasses();

	}
}