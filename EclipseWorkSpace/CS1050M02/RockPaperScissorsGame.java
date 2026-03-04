import java.util.Scanner;

public class RockPaperScissorsGame
{

	public static void main(String[] args)
	{
		// declared player and computer inputs
		char player;
		char computer;

		// a string that we can draw chars from
		String possibleChars = "RPS";

		// allows a computer to randomly select a char
		computer = possibleChars.charAt((int) (Math.random() * 3));

		// searches for keyboard inputs
		Scanner keyboardInput = new Scanner(System.in);

		// user end console prompt
		System.out.println("Type one of the following: \n R: Rock \n P: Paper \n S: Scissors");
		System.out.print("Input it here: ");

		// allows the player to input a string. It is implicitly casting a String into a
		// char
		player = Character.toUpperCase(keyboardInput.next().charAt(0));

		System.out.print(computer);

		// this is a boolean flag that assumes that the input by player is valid
		boolean validInput = true;

		// if the input from player is NOT Rock Paper or Scissors it makes you input it
		// again
		while (player != 'R' || player != 'P' || player != 'S')
		{
			// console output when the input is not valid
			System.out.print("Improper input. Please try again: ");
			// user end console prompt
			System.out.println("Type one of the following: \n R: Rock \n P: Paper \n S: Scissors");
			System.out.print("Input it here: ");
			// allows the player to input a string. It is implicitly casting a String into a
			// char
			player = Character.toUpperCase(keyboardInput.next().charAt(0));
		} // end of while

		if (player == computer)
			;
		{
			System.out.print("Tie");
		}

	}// end of main

}// end of class
