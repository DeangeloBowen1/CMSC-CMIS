package project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


//main class which extends JFrame for proper GUI construction
public class MainGUI extends JFrame {

    /**
     * Author: DeAngelo Bowen
	 * CMSC 350 7387
	 * This program was designed to meet the requirements of PROJECT 1
	 * for UMGC CMSC 350 7387. 
	 */
private static final long serialVersionUID = 1L;
	JButton prefixtopostfix;
	JButton postfixtoprefix;
	JLabel label1;
	JLabel label2;
	JTextField input;
    JTextField output;
   

   private MainGUI() {
	   /**
	    * @try : prefix and post fix user input evaluation
	    * @catch : user input error || incorrect prefix / post fix expression upon selection
	    * */
	   
       this.setTitle("Expression Converter - DeAngelo Bowen");
       this.setLayout(null);

       //creates infix expression calculation label
       label1 = new JLabel("Infix Expression");
       label1.setBounds(100, 50, 100, 50);
       add(label1);

       //creates results label
       label2 = new JLabel("Results");
       label2.setBounds(150, 200, 80, 50);
       add(label2);

       //Creates user input text filed
       JTextField input = new JTextField("");
       input.setBounds(210, 60, 210, 30);
       add(input);

       //creates output display text field
       output = new JTextField("");
       output.setEditable(false);
       output.setBounds(200, 210, 210, 30);
       add(output);

       //initializes Prefix to Post fix button
       prefixtopostfix = new JButton("Prefix to Postfix");
       prefixtopostfix.setBounds(100, 130, 150, 30);


       //action listener created for prefix to post fix
       prefixtopostfix.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {


              try {
                //Gets input from user
                String prefix_Expression = input.getText().replaceAll(" "," ");


                //Creates new instance of PrefixToPostfix class 
                PrefixToPostfix ptp = new PrefixToPostfix();


                //Call on the preToPost method and catches any incorrect input. 
                output.setText(ptp.prefixToPostfix(prefix_Expression));
               } catch (Exception error) {
                   JOptionPane.showMessageDialog(new JFrame(), "Incorrect input. Please try again.");
                }


            }
        }
        );
        add(prefixtopostfix);
        
        //initializes Post fix to Prefix button
        postfixtoprefix = new JButton("Postfix to Prefix");
        postfixtoprefix.setBounds(270, 130, 150, 30);

        //adds action listener
        postfixtoprefix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String postfix_Expression = input.getText().replaceAll(" "," ");

                    new PostfixToPrefix();

                    //display evaluation for post to prefix, catch error
                    output.setText(PostfixToPrefix.postfixtoprefix(postfix_Expression));
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(new JFrame(), "Incorrect input. Please try again.");
                }


            }
        }
        );
        add(postfixtoprefix);


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 500, 300);


    }


   //main method
    public static void main(String[] args) {
        new MainGUI();
    }


}
