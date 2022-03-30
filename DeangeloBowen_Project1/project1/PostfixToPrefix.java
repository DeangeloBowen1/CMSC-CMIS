package project1;

import java.util.*;  

class PostfixToPrefix {
 
	/**
	 * @param : equation input string from user that contains a Post-fix expression
	 * @return : operator || Post-fix expressions
	 * **/
    static boolean isOperator(char x)
    {
 
        switch (x) {
        case '+':
        case '-':
        case '/':
        case '*':
            return true;
        }
        return false;
    }
 
    static String postfixtoprefix(String post_exp)
    {
        Stack<String> s = new Stack<String>();
 
        // checking the length of expression
        int length = post_exp.length();
 
        // initialize tokens reading from right to left
        for (int i = 0; i < length; i++) {
 
            // check if symbol is operator
            if (isOperator(post_exp.charAt(i))) {
 
                // pop two operands from stack
                String operand1 = s.peek();
                s.pop();
                String operand2 = s.peek();
                s.pop();
 
                String temp
                    = post_exp.charAt(i) + operand2 + operand1;
 
                // Push String temporarily back to stack
                s.push(temp);
            }
 
            // checks if symbol is an operand
            else {
 
                // push the operand to the stack
                s.push(post_exp.charAt(i) + "");
            }
        }
 
        // concatenate all strings in stack and return the
        // answer
        String function = "";
        for (String i : s)
            function += i;
        return function;
    }
 
    // Driver Code
    public static void main(String args[])
    {
        String post_exp = "ABC/-AK/L-*";
 
        // Function call
        System.out.println("Prefix : "
                           + postfixtoprefix(post_exp));
    }
}