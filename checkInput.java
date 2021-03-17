/*
 * Akshay Patel
 * This is a sub class that uses exception handling to check if the user entered string is valid or invalid
 * 4/23/2019
 */



public class checkInput extends computerGenerate
{
	String userInput = ""; 	//initializes userInput to empty string
	
	/**
	   * constructor, will store input and call the super parent class computerGenerate constructor
	   *@param input is the user entered string choice
	   */
	public checkInput(String input)
	{
		super(input);		//calls the super constructor with the user choice as a param
		userInput = input;	//sets the user inputted string to a previously empty string userInput
	}
	
	/**
	   * accessor method that evaluates if the user entered string is valid or invalid. If it is invalid, the method throws an illegal exception
	   *@return true if the user entered Rock, Paper, or scissor (non-case sensitive)
	   *@return false if the user enters anything else other then Rock, Paper, or Scissor
	   */
	
	public Boolean check()
	{
		//Try an catch statements to test if the string  entered is correct or incorrect
		try
		{
			//if the user enters correct choice, the method returns true
			
			if (userInput.equalsIgnoreCase("rock") || userInput.equalsIgnoreCase("paper") || userInput.equalsIgnoreCase("scissor"))
			{
				return true;
			}
			else 	//otherwise the method throws illegal exception
			{
				throw new IllegalArgumentException("Please enter a valid option to play this game.");
			}
		}
		
		//catches illegal exception
		catch (IllegalArgumentException e)		
		{
			System.out.println(e.getMessage());		//prints illigal ecception on the console window
			return false;							//returns false if the if condition evaluates to false
		}
	}

}
