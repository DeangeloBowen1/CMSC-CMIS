package project2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Author: DeAngelo Bowen
 * CMSC 350 7387
 * This program was designed to meet the requirements of PROJECT 2
 * for UMGC CMSC 350 7387. 
 */

public class Main {

private static List<Polynomial> polyList = new ArrayList<>();

//main function
public static void main(String[] args) {
processPolyList();
}


public static ArrayList<String> fromFile() {
	//Create ArrayList and JFileChooser 
	ArrayList<String> expressionList = new ArrayList<>();
	
	JFileChooser chooser = new JFileChooser();
	
	//Show both directories and files
	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	
	//use current directory for ease
	chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	
	int response = chooser.showOpenDialog(null);
	
	if (response == JFileChooser.APPROVE_OPTION) {
		
		File file = chooser.getSelectedFile();
		
		try {
			
			try (Scanner fileIn = new Scanner(file)) {
				if (file.isFile()){
					
					while (fileIn.hasNextLine()){
						String expression = fileIn.nextLine();
						expressionList.add(expression);
					}
				}
			}
		}
		
		catch (NoSuchElementException nse){
			
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"File is empty!");
			
		}
		
		catch(FileNotFoundException fne){
			
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"File is not found!");
		}
	}
	
	return expressionList;
}
/* Method: checkWeakOrder / returns: boolean
 * Function: determines if a list is in weak order 
 * LAMBDA expression expected
 * 
 * */
public static boolean checkWeakOrder( List<Polynomial> polyList){
	boolean isWeakOrder = true;
	Polynomial previous = polyList.get(polyList.size()-1);
for(int i = polyList.size()-2; i > 0; i--){

	if (previous.compareExponents(polyList.get(i)) < 0){
		isWeakOrder = false;
	}
}
return isWeakOrder;
}


public static void processPolyList(){
	try {
		ArrayList<String> a = fromFile();
		
	for (String element : a) {
		Polynomial p = new Polynomial(element);
		
System.out.println(p);

polyList.add(p);
	}
}
	catch (InvalidPolynomialSyntax ex){
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage());
		
}
	
/* Call to check sorted for the Strong order check */
System.out.println("Strong Ordered: " + OrderedList.checkSorted(polyList));

/* Check for Weak order (exponents only) */
System.out.println("Weak Ordered: " + checkWeakOrder(polyList));
	}
}