import java.util.Scanner;

public class L010Lab
{

	public static void main(String[] args)
	{
		// creates a scanner called keyboardInput
		Scanner keyboardInput = new Scanner(System.in);

		// declares base
		double base;
		// declares exponent
		int exponent;

		// Prompt for base
		System.out.print("Enter the base for your number: ");
		// initializes base
		base = keyboardInput.nextDouble();

		// Prompt for input
		System.out.print("Enter a positive number for an exponent: ");
		// initializes exponent
		exponent = keyboardInput.nextInt();

		// while the exponent is negative or 0 that will repeat until you give a
		// positive
		while (exponent <= 0)
		{
			// error message
			System.out.println("Error: Exponent inputted is negative or zero.");
			// prompted to input another exponent
			System.out.print("Enter a positive number for an exponent: ");
			exponent = keyboardInput.nextInt();
		}

		// tells the user what their inputed exponent is.
		System.out.println("The exponent is: " + exponent);

		// declares and initializes baseMult
		double baseMult = 0;

		// assign baseMult as base to allow for it to store the original number
		baseMult = base;

		/*
		 * count begins at 1, because the exponent CANNOT be 0. As long as count is less
		 * than the exponent, every time it loops, it will count up.zzz
		 */
		for (int count = 1; count < exponent; ++count)
		{
			// will multiply the base number by its original value until count is equal to
			// exponent
			base = base * baseMult;
		}

		// displays the equation and its answer.
		System.out.print(baseMult + "^" + exponent + " = " + base);

	}

}
