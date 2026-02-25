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

		// output message
		System.out.printf("The exponent is: %d", exponent);
		// tells the user what their inputed exponent is.
		System.out.println("The exponent is: " + exponent);

	}

}
