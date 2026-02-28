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
	}

}
