import javax.swing.*;  //javax.swing package provides classes for java swing API such as JButton, JTextArea, JRadioButton,etc
import java.awt.*;  //This package contains all of the classes for creating user interface and for painting graphics and images
import java.awt.event.*;  // It defines classes and interfaces used for event handling in our case operations of calculator i.e +,-, etc.

public class Calculator implements ActionListener{   // implement keyword is used to implement an interface in our case Action listener is an interface 
	
	JFrame frame;  // for creating a window that has decorations like border,title..
	JTextField textfield;  // It allows editing of a single line of text
	JButton[] numberButtons = new JButton[10]; // an implementation of a push button
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel; // a simplest container class, it provides space in which an application can attach any other component
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);  // Font type i.e. size, bold,etc. is initialized
	
	double num1=0, num2=0,result=0; // defining some double data types 
	char operator;  // defining the operators with char data types like (+-*/)
	
	Calculator(){   // created constructor 
		
		frame = new JFrame("Calculator"); // Initializing the frame and Giving the title to the as our project is calculator 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This will allow to close the program
		frame.setSize(420, 550); // giving the size to the frame
		frame.setLayout(null);  //As we are not using any layout manager so set the layout as null
		
		textfield = new JTextField();  // Initializing the text field 
		textfield.setBounds(50, 25, 300, 50); // giving the size to the text field
		textfield.setFont(myFont); // reusing myfont in text field
		textfield.setEditable(false);// as we don't want to edit from our keyboard we will set the editable as false
		
		// Initializing all the operations below
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;// In order to add first button to the first position we set the index as 0 i.e add button at 0 position and further on
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i=0; i<9; i++) {  // to iterate all the function buttons (J Buttons) as we need to use it for 8 indexes and 9 positions        
			functionButtons[i].addActionListener(this);  // add the action listener as it is responsible for handling all action events such as when user clicks on a component
			functionButtons[i].setFont(myFont);  // again reuse the myfont 
			functionButtons[i].setFocusable(false);  // to avoid any kind of annoying outline around the button after clicking the button set focusable as false
		}
		
		for(int i=0; i<10; i++) {  // to iterate all the number buttons as there are 9 indexes and 10 positions so we'll iterate as i<10
			numberButtons[i] = new JButton(String.valueOf(i));  // so to add some text to this button we use string.valueof(i) as to print i value corresponding to that iteration
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(50,430,100,50);  // set bounds is used to define the bounding the rectangle of a component like neg buton, del button, clr button 
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250,430,145,50);
		
		panel = new JPanel();  // Initializing the panel i.e. the simplest container class for out number buttons
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));  // set the layout as gridlayout for our panel
		
		
		// Add all the number buttons and operations in the panel as per the positions we want
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		//to add everything in a frame .add is used
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);  //set the visibility as true
	}
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) { // using for loop for iterating between all the number buttons
			if(e.getSource() == numberButtons[i]) { // used if statement to take user input and set, get the text of all the numbers
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {   // e.getsource will return reference to the object that the event came from
//i.e if user input is taken it is stored in e.getsource and compared with all the numbers and operations and if matches then another line will be executed
			textfield.setText(textfield.getText().concat(".")); //using get and set dec "." will be printed in the textfield 
		}
		
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());  // parse double is used to return new double initialized to the value represented by the specified string i.e add in our case
			operator = '+';  // using the add operator to get the added output in the result
			textfield.setText("");
		}
		
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {  // switch statement is used for different operations choosed by user
			case'+':
				result=num1+num2;
				break;
			case'-':
				result = num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			
			}
			
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		

		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			
			for(int i=0; i<string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}

	}

}
