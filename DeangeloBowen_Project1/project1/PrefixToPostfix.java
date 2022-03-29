package project1;

import java.util.*; 

public class PrefixToPostfix 
{ 
 
//Evaluate numerical operator 
static boolean isOperator(char e)
/**
 * @param : equation input string from user that contains a Prefix expression
 * @return : operator || Prefix expressions
 * **/
{ 
 switch (e)  
 { 
   case '+': 
   case '-': 
   case '/': 
   case '*': 
   return true;
 } 
 return false; 
} 
 


//Convert prefix to Post fix expression 
public String prefixToPostfix(String prefix_Expression) {
	Stack<String> s= new Stack<String>(); 
	
	prefix_Expression = prefix_Expression.replaceAll("\\s", "");
 // Initializing tokens from right to left
	int length = prefix_Expression.length(); 
 
	for (int i = length - 1; i >= 0; i--)  
	{  
		//Evaluate operator
		if (isOperator(prefix_Expression.charAt(i)))  
		{ 
			//pop required operands from stack 
			String operand1 = s.peek(); 
			s.pop(); 
			String operand2 = s.peek(); 
			s.pop(); 
 
			// concatenate both operands via String
			String temp = operand1 + operand2 + prefix_Expression.charAt(i); 
			// Push String back to the stack
			s.push(temp); 
			continue;
		} 
		// Checks if symbol is an operand 
		else{ 
			// push the operand to the stack 
			s.push(prefix_Expression.charAt(i)+" "); 
			continue;
		} 
	} 
	// return post fix expression 
	return s.peek(); 
	} 
}