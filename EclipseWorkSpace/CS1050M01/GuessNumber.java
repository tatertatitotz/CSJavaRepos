
/**
 * This program takes user input to see if they can guess the 
 * random number generated. Add comments to explain the code.
 */

import java.util.Scanner;

public class GuessNumber
{
	public static void main(String[] args)
	{
		// declares an integer. it is a constant
		final int RANDOM_MULTIPLIER = 100;
		/**
		 * the identifier number is declared initialized as a random number multiplied
		 * by the constant
		 */
		int number = (int) (Math.random() * RANDOM_MULTIPLIER) + 1;

		Scanner keyboardInput = new Scanner(System.in);

		System.out.println("Guess a magic number between 0 and 100");
		/*
		 * declares and initialize guess as an impossible number allows guess to be
		 * assigned later
		 */
		int guess = -1;
		while (guess != number)
		{

			System.out.print("\nEnter your guess: ");
			// assigns guess as inputed integer
			guess = keyboardInput.nextInt();
			// after guess is assigned...
			if (guess == number)
			{
				// if you guess correctly this string is run
				System.out.println("Yes, the number is " + number);
			}
			// if the guess is too high
			else if (guess > number)
			{
				System.out.println("Your guess is too high");
			}
			// if the guess is too low/otherwise
			else
			{
				System.out.println("Your guess is too low");
			}
		}

		keyboardInput.close();

	}// end of main
}// end of class
