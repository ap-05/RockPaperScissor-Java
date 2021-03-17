/*
 * Akshay Patel
 * This is the Rock, Paper, Scissor game runner and the GUI class that places each component in an empty window.
 * When the program is ran, the instructions are given on how the game is played and asks the user to enter Rock, paper, or scissor
 * It then uses other two classes to compute if the player won, lost, or tied
 * 4/23/2019
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PatelRockPaperScisscor extends JFrame
{	
	//Initializes planel 1. info label will be added to panel 1
	JPanel panel1;
	public JLabel info;
	public JLabel info1;
	public JLabel winningCriteria;
	
	//Initializes panel 2. 
	//Initialized user label, userEnter text field, and userImg label. These will be added to panel 2
	JPanel panel2; 
	public JLabel user;
	public JTextField userEnter;
	public JLabel userImg;
	
	//Initializes panel 3. 
	//Initializes button button. This will be added to panel 3
	JPanel panel3;
	public JButton button;
	
	//Initialzes panel 4. 
	//Initializes computerChoice text field and computerImg label. These will be added to panel 4
	JPanel panel4;
	public JTextField computerChoice;
	public JLabel computerImg;
	
	//Initializes panel 5
	//Initializes result text field. This will be added to panel 5
	JPanel panel5;
	public JTextField result;
	
	//Initializes panel 6
	//Initializes playAgain button. This will be added to panel 6
	JPanel panel6;
	public JButton playAgain;
	
	//Initializes panel 7
	//Initializes quit button. This will be added to panel 7
	JPanel panel7;
	public JButton quit;
	
	//Initializes image for rock, paper, and scissor that are stored in the source folder
	ImageIcon one = new ImageIcon("rock.png");
	ImageIcon two = new ImageIcon("paper.png");
	ImageIcon three = new ImageIcon("scissor.png");
	
	
	/**
	 * Constructor that places objects on an empty window using panels
	 */
	public PatelRockPaperScisscor()
	{
		setTitle("Rock Paper Scissor Game"); 	//Sets Title of the window
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 //exits when cross is clicked
		
		setSize(1000,400);		//sets the height and width of the window
		
		setLayout(new GridLayout(7,1));		//creates a grid of 7 rows and 1 columns
		
		//Initializes information and criteria string that contains instructions on how to play the game
		String information = "You will be playing Rock, Paper, Scissor against a Computer. Please start by entering your choice below and click play. ";
					
		info1= new JLabel("The outcome of the game will be displayed on the screen. If you would like to play again, click play again button or if you would like to quit, click quit button.");
		
		winningCriteria = new JLabel("Winning Criteria:        1) Rock beats Scissor        2) Paper beats Rock        3) Scissor beats Paper");
		
		//panel 1
		panel1 = new JPanel();		//creates panel1
		info = new JLabel(information); 	//adds information string to info label
		panel1.add(info);	//adds info label to panel 1
		panel1.add(info1);	//adds info1 label to panel 1
		panel1.add(winningCriteria);   //Adds criteria label to panel 1
		
		
		//panel 2
		panel2 = new JPanel();	//creates panel2
		user = new JLabel("Enter Rock, Paper, or Scissor: ");	//sets the display message to user label 
		userEnter = new JTextField(6);	 //creates userEnter text field of size 6
		panel2.add(user);	//adds user label to panel 2
		panel2.add(userEnter);//adds userEnter text field to panel 2
		
		//panel 3
		panel3= new JPanel();		//creates panel3
		button = new JButton("Play");		//sets the display message to button button
		button.addActionListener(new CalcButtonListener());		//adds an action listener to the button
		panel3.add(button);		//adds the button to panel3
		
		//panel 4
		panel4 = new JPanel();		//creates panel 4
		computerChoice = new JTextField(13);	//creates computerChoice text field of size 13
		computerChoice.setVisible(false);	//makes the text field invisible
		computerChoice.setEditable(false);	//makes to text field not editable. user cannot enter anything in this text field
		panel4.add(computerChoice);	//adds the text field to panel4
		
		//panel 5
		panel5 = new JPanel();	//creates panel 5
		result = new JTextField(24);	//creates result text field of size 24 
		result.setVisible(false);	//makes the text field invisible
		result.setEditable(false);	//makes to text field not editable. user cannot enter anything in this text field
		panel5.add(result);			//adds the text field to panel5
		
		//panel 6
		panel6 = new JPanel();		//creates panel 6
		playAgain = new JButton("Play Again");	//sets the display message to playAgain button 
		playAgain.addActionListener(new playAgainButtonListener());		//adds an action listener to playAgain button
		panel6.add(playAgain);	//adds the button to panel6
		
		//panel 7
		panel7= new JPanel();	//creates panel 7
		quit= new JButton("Quit");	//sets the display message to the quit button
		quit.addActionListener(new quitButtonListener());	//adds an action listener to quit button
		panel7.add(quit);	//adds the button to panel7
		
		//adds panel 1 to 7 to the created window.
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(panel7);
		
		//makes the window visible
		setVisible(true);
	}
	
	//action listener class for play button
	private class CalcButtonListener implements ActionListener
	   {
	      /**
	         The actionPerformed method executes when the user clicks on the Calculate button.
	         @param e The event object.
	      */

	      public void actionPerformed(ActionEvent e)
	      {
	    	  //creates checkInput object
	    	  //accesses text entered in the userEnter text field and sends the text to checkInput class constructor
	    	  checkInput in = new checkInput(userEnter.getText());
	    	  
	    	  if(in.check())	// checks if the user entered valid input
	    	  {
	    		  if(in.playerNum()==1)	//if the user entered rock
	    		  {
	    			  userImg = new JLabel(one);	//rock ImageIcon is added to userImg label
	    			  panel2.add(userImg);	//label is added to panel2
	    			  
	    		  }
	    		  else if(in.playerNum()==2)	// if the user entered paper
	    		  {
	    			  userImg = new JLabel(two);	//paper ImageIcon is added to userImg label
	    			  panel2.add(userImg);			//label is added to panel2
	    		  }
	    		  else
	    		  {
	    			  userImg = new JLabel(three);	//scissor ImageIcon is added to userImg label
	    			  panel2.add(userImg);	//label is added to panel2
	    		  }
	    		  
	    		  //sets the userEnter text field as read only field
	    		  userEnter.setEditable(false);
	    		  
	    		  //sets play button as not clickable button after play button is clicked
	    		  //This will be changed as a clickable button after playAgain button is clicked
	    		  button.setEnabled(false);
	    		  
	    		  
	    		  computerChoice.setVisible(true);		//When the play button is clicked, computerChoice textBox becomes visible
	    		  computerChoice.setBackground(Color.white);	//sets the background color to white
	    		  computerChoice.setBorder(new LineBorder(Color.red,2));	//sets bordor color to red and bordor width to 2
	    		  computerChoice.setText("Computer Chose "+in.randNumGenerate());	//gets the computer choice and sets it to computerChoice text field
	    		  
	    		  
	    		  if (in.getCompCoice()==1)		//if computer chooses rock
	    		  {
	    			  computerImg = new JLabel(one);	//rock ImageIcon is added to userImg label
	    			  panel4.add(computerImg);			//label is added to panel4
	    		  }
	    		  else if(in.getCompCoice()==2)		//if computer chooses paper
	    		  {
	    			  computerImg = new JLabel(two);	//paper ImageIcon is added to userImg label
	    			  panel4.add(computerImg);			//label is added to panel4
	    		  }
	    		  else if (in.getCompCoice()==3)	//if computer chooses scissor
	    		  {
	    			  computerImg = new JLabel(three);	//scissor ImageIcon is added to userImg label
	    			  panel4.add(computerImg);			//label is added to panel4
	    		  }
	    		  
	    		  result.setVisible(true);				//sets result text field visible
	    		  result.setBackground(Color.white);	//sets background color to white
	    		  result.setBorder(new LineBorder(Color.red,2));	//sets border color to red and border width to 2
	    		  
	    		  //refreshes GUI window
	    		  PatelRockPaperScisscor.this.revalidate();		//recalculates the layout of the window
	    		  PatelRockPaperScisscor.this.repaint();		//updates the window after the two texfields are set visible so that they show up on the screen
	    		  
	    		  result.setText(in.compare());			//gets the result on who won, computer or player and sets the message to result text field
	    	  }
	    	  else	//if the user enters invalid input
	    	  {
	    		  //pop up is displayed on the screeen asking to enter again
	    		  JOptionPane.showMessageDialog(null, "INVALID!! Please type one of the following choices: Rock, Paper, or Scissor.");
	    	  }
	      }
	   }
	
	//action listener class for playAgain button
	private class playAgainButtonListener implements ActionListener
	{
		/**
        The actionPerformed method executes when the user clicks on the play again button.
        @param e The event object.
     */
		public void actionPerformed(ActionEvent e)
	      {
			userEnter.setEditable(true);	//User can enter a choice after playAgain button is clicked.
			userEnter.setText("");			//replaces previously entered choice with an emply string
			
			button.setEnabled(true);	//user can click play button after playAgain is clicked 
			
			//removes previous images for both computer and user choices so that new images can be inserted
			panel2.remove(userImg);
			panel4.remove(computerImg);
	      }
	}
	
	//action listener class for quit button
	private class quitButtonListener implements ActionListener
	{
		/**
        The actionPerformed method executes when the user clicks on the quit button.
        @param e The event object.
     */
		public void actionPerformed(ActionEvent e)
	      {
			System.exit(0);		//When exit is clicked, program is terminated 
	      }
	}
	
		
	//Main method
	public static void main(String[] args) 
	{
		new PatelRockPaperScisscor();//calls the constructor
	}
}
