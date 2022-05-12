package finalProject;

import java.util.*;

public class Graph<V> {
	
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

	public V startingNode = null;

	Map<String, V> vertices = new HashMap<>();

	Map<V, ArrayList<V>> adjacencyList = new HashMap<>();

	Set<V> visited = new HashSet<>();

	ParenthesizedList hierarchy = new ParenthesizedList();
	Hierarchy parenthesizedList = new Hierarchy();

	boolean cycle;


	Set<V> discovered = new HashSet<>();

	public void depthFirstSearch() {


		cycle = false;

		dfs(startingNode);
	}

	private void dfs(V node) {
		/**
		 * @param node Node to discover with all of it's child
		 */

		if (discovered.contains(node)) {
			cycle = true;

// Perform DFS Actions Cycle Detected operation
			hierarchy.cycleDetected();
			parenthesizedList.cycleDetected();
			return;
		}

		hierarchy.processVertex((Vertex) node);
		parenthesizedList.processVertex((Vertex) node);

		hierarchy.descendVertex((Vertex) node);
		parenthesizedList.descendVertex((Vertex) node);

// add the node to the discovery list
		discovered.add(node);

// mark the node as visited
		visited.add(node);

// discover all of it's child
		ArrayList<V> list = adjacencyList.get(node);
		if (list != null) {
			for (V u : list)
				dfs(u);
		}

// Perform DFS Actions Ascend Vertex operation
		hierarchy.ascendVertex((Vertex) node);
		parenthesizedList.ascendVertex((Vertex) node);

		discovered.remove(node);

	}

	private V getVertex(String u) {
// get the Mapped vertex reference of a node(String)
		return vertices.get(u);
	}

	public void displayUnreachableClasses() {


		for (Map.Entry<V, ArrayList<V>> entry : adjacencyList.entrySet()) {
			if (entry.getValue().size() > 0) {
// if found one print it and mark it as visited to avoid double printing

// check the node itself
				if (!visited.contains(entry.getKey())) {
					System.out.println(entry.getKey() + " is unreachable");
					visited.add(entry.getKey());
				}

// check all of it's adjacent nodes
				for (V vertex : entry.getValue()) {

					if (!visited.contains(vertex)) {
						System.out.println(vertex + " is unreachable");
						visited.add(vertex);
					}
				}
			}
		}

	}

}