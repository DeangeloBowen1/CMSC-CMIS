package finalProject;

import java.util.LinkedList;
import java.util.Queue;

public class Hierarchy implements DFSActions<Vertex> {
	
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


	Queue<String> res = new LinkedList<>();

	@Override
	public void processVertex(Vertex vertex) {
		res.add(vertex.toString());
	}

	@Override
	public void descendVertex(Vertex vertex) {
		res.add("(");
	}

	@Override
	public void ascendVertex(Vertex vertex) {
		res.add(")");

	}

	@Override
	public void cycleDetected() {
		res.add("*");
	}

	@Override
	public String toString() {

		String ans = "";

		int sz = 0;

		while (res.size() > 0) {
			String c = res.peek();
			res.remove();

			if (c == "(") {
				if (res.peek() == ")") {
					res.remove();
					continue;
				} else if (res.peek() == "*") {
					ans += res.peek() + " ";
					res.remove();
					res.remove();
					continue;
				}
			}

			if (c == "(")
				sz++;
			else if (c == ")")
				--sz;
			if (c == "(" || c == ")")
				continue;
			if (c != "*")
				ans += "\n";
			for (int i = 0; i < sz; i++) {
				ans += "\t";
			}
			ans += c + " ";
		}
		return ans;
	}
	private boolean isAlpha(String s) {
		return s != "(" && s != ")";
	}
}