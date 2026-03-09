import java.util.Scanner;

public class RefactoredBMI
{

	public static void main(String[] args)
	{
		// Create constant an variables
		final int BMI_US_FACTOR = 703;

		// Tell the user what the program will do.
		System.out.println(
				"This program will calculate your body mass index, or BMI using the imperial measurement system (pounds and inches).");
		System.out.println("There are 4 BMI Categories: " + "\n Obese: BMI = +40 " + "\n Overweight: BMI >= 25 "
				+ "\n Normal: BMI >= 18.5 " + "\n Underweight: BMI < 18.5.");
		System.out.println("The BMI formula used is: weight * 703 / height^2.");

		// Scanner defined
		Scanner keyboardInput = new Scanner(System.in);

		// Variables
		// declared weight
		double weight;
		// declared height;
		double height;
		// The user's BMI

		// Get the user's weight.
		System.out.print("Enter your weight, in pounds: ");
		weight = keyboardInput.nextDouble();

		weight = checkWeight(weight);

		// Get the user's height.
		System.out.print("Enter your height, in inches: ");
		height = keyboardInput.nextDouble();

		// Calculate the user's body mass index.
		double bmi = weight * BMI_US_FACTOR / (Math.pow(height, 2));
		height = checkHeight(height);

		// ---- BMI Categories ----

		// multi-way if
		if (bmi >= 40)
		{
			System.out.println("Obese");
		} else if (bmi >= 25)
		{
			System.out.println("Overweight");
		} else if (bmi >= 18.5)
		{
			System.out.println("Normal");
		} else
		{
			System.out.println("Underweight");
		} // end else

		// Display the user's BMI.
		System.out.printf("Your body mass index (BMI) is %f", bmi);

		keyboardInput.close();

	}// end of main

	// checks if the inputed weight is valid
	public static double checkWeight(double weightMaybe)
	{
		// new scanner because new method
		Scanner keyboardInput = new Scanner(System.in);
		// while the height is negative or 0, allows you to input again.
		while (weightMaybe <= 0)
		{
			System.out.print("Invalid Input. Enter weight: ");
			weightMaybe = keyboardInput.nextDouble();
		}
		// closes outside so that you don't keep opening and closing the scanner
		keyboardInput.close();
		return weightMaybe;
	}

	// checks if the inputed height is valid
	public static double checkHeight(double heightMaybe)
	{
		// new scanner because new method
		Scanner keyboardInput = new Scanner(System.in);
		// while the height is negative or 0, allows you to input again.
		while (heightMaybe <= 0)
		{
			System.out.print("Invalid Input. Enter height: ");

			heightMaybe = keyboardInput.nextDouble();
		}
		// closes outside so that you don't keep opening and closing the scanner
		keyboardInput.close();
		return heightMaybe;
	}
}// end of class
