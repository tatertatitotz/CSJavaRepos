
/**
 * Calculate the BMI using formula in US units. 
 * User will enter weight in pounds and height in inches
 */

import java.util.Scanner;

public class BodyMassIndexActivity
{

	public static void main(String[] args)
	{
		// Create constant an variables
		final int BMI_US_FACTOR = 703;
		// factor formula in pounds
		// Variables
		// declared weight
		double weight;
		// declared height;
		double height;
		// The user's BMI

		Scanner keyboardInput = new Scanner(System.in);

		// Tell the user what the program will do.
		System.out.println("This program will calculate your " + "body mass index, or BMI.");
		// Get the user's weight.
		System.out.print("Enter your weight, in pounds: ");
		weight = keyboardInput.nextDouble();

		// Get the user's height.
		System.out.print("Enter your height, in inches: ");
		height = keyboardInput.nextDouble();

		// Calculate the user's body mass index.
		double bmi = weight * BMI_US_FACTOR / (height * height);
		double bmi = weight * BMI_US_FACTOR / (Math.pow(height, 2));

		// ---- BMI Categories ----
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
		}

		// Display the user's BMI.
		System.out.printf("Your body mass index (BMI) is %f", bmi);

		keyboardInput.close();
	}// end of main
}// end of class