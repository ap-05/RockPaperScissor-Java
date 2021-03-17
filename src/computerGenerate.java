/*
 * Akshay Patel
 * This is the parent class that generates a computer choice randomly between 1 and 3, and computes if the player won, lost, or tied
 * 4/23/2019
 */


import java.util.Random;//imports random class

public class computerGenerate{
	
	Random generator = new Random();		//creates random class object to access its methods
	
	int computer = 0;						//sets computer variable to 0
	
	int player = 0;							//sets player variable to 0
	
	String input = "";						//sets input variable to an empty string
	
	/**
	   * constructor that sets the userInput to input
	   *@param userInput is the user entered choice
	   */
	public computerGenerate(String userInput)
	{
		input = userInput;		//sets the previously entered string to a previously empty input string
	}
	
	/**
	   *accessor method playerNum that evaluates if the user enteres Rock, paper or scissor and returns 1, 2, 3 respectively for each choice
	   *@return 1 if the user entered rock
	   *@return 2 if the user entered paper
	   *@return 3 if the user entered scissor
	   */
	public int playerNum ()
	{
		//1 corresponds to Rock
		//2 corresponds to Paper
		//3 corresponds to scissor
		if (input.equalsIgnoreCase("Rock"))//rock choice
		{
			player=1;//sets player variable to 1
		}
		else if(input.equalsIgnoreCase("Paper"))//paper choice
		{
			player=2;//sets player variable to 2
		}
		else if(input.equalsIgnoreCase("Scissor"))//scissor choice
		{
			player=3;//sets player variable to 3
		}
		return player;//returns the number set to player
	}
	
	/**
	   * accessor method that that picks a random number between 1 and 3 and returns string rock, paper, or scissor based on the generated number
	   *@return rock if computer generates 1
	   *@return paper if computer generates 2
	   *@return scissor if computer generates 3
	   */
	public String randNumGenerate()
	{
		  // Create a Random object.
	      Random rand = new Random();
	      
	      // Get a random value between 1 and 3
	      computer = rand.nextInt(3) + 1;
	      
	      //1 corresponds to Rock
	      //2 corresponds to Paper
		  //3 corresponds to scissor
	      
	      if (computer==1)	//if one is generated, return rock
	      {
	    	  return "Rock";
	      }
	      else if (computer==2)	//if two is generated, return paper
	      {
	    	  return "Paper";
	      }
	      else		//if three is generated, return scissor (three is the only other choice that this else statement can evaluate)
	      {
	    	  return "Scissor";
	      }
	}
	
	/**
	   * accessor method that returns the computer generated number
	   *@return computer is the computer generated integer number between one and three
	   */
	public int getCompCoice()
	{
		return computer;
	}
	
	/**
	   * accessor method that compares the player and computer choice and evaluates who won, or a tie
	   *@return "YOU WIN!! ROCK SMASHES SCISSOR." if player typed rock and computer generated scissor
	   *@return "YOU WIN!! SCISSOR CUTS PAPER." if player typed scissor and computer generated paper
	   *@return "YOU WIN!! PAPER WRAPS ROCK." if player typed paper and computer generated rock
	   *@return "COMPUTER WINS. ROCK SMASHES SCISSOR." if player typed scissor and computer generated rock
	   *@return "COMPUTER WINS. SCISSOR CUTS PAPER." if player typed paper and computer chose scissor
	   *@return "COMPUTER WINS. PAPER WRAPS ROCK." if player typed Rock and computer generated paper
	   *@return "IT IS A TIE!!!" if player and computer has chosen the same option
	   */
	
	public String compare()
	{
		//1 corresponds to Rock
		//2 corresponds to Paper
		//3 corresponds to scissor
		
		if (player== 1 && computer== 3)		//player rock, computer scissor
		{
			System.out.println("You chose Rock.");
			System.out.println("Computer chose Scissor.");
			return "YOU WIN!! ROCK SMASHES SCISSOR.";
		}
		
		else if (player== 3 && computer== 2)	//player scissor, computer scissor
		{
			System.out.println("You chose Scissor.");
			System.out.println("Computer chose Paper.");
			return "YOU WIN!! SCISSOR CUTS PAPER.";
		}
		
		else if (player== 2 && computer== 1)	//player paper, computer rock
		{
			System.out.println("You chose Paper.");
			System.out.println("Computer chose Rock.");
			return "YOU WIN!! PAPER WRAPS ROCK.";
		}
		
		else if  (computer== 1 && player== 3)	//computer rock, player scissor
		{
			System.out.println("You chose Scissor.");
			System.out.println("Computer chose Rock.");
			return "COMPUTER WINS. ROCK SMASHES SCISSOR.";
		}
		
		else if (computer== 3 && player== 2)	//computer scissor, player paper
		{
			System.out.println("You chose Paper.");
			System.out.println("Computer chose Scissor.");
			return "COMPUTER WINS. SCISSOR CUTS PAPER.";
		}
		
		else if (computer== 2 && player== 1)	//computer paper, player rock
		{
			System.out.println("You chose Rock.");
			System.out.println("Computer chose Paper.");
			return "COMPUTER WINS. PAPER WRAPS ROCK.";
		}
		else	//if it is a tie
		{
			System.out.println("You and the computer have chosen the same option.");
		}
		return "IT IS A TIE!!!";		//returns tie as a last resort
	}
}
