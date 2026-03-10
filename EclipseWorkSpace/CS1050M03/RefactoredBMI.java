import java.util.Scanner;

public class RefactoredBMI
{

	public static void main(String[] args)
	{

		// Tell the user what the program will do.
		System.out.println(
				"This program will calculate your body mass index, or BMI using the imperial measurement system (pounds and inches).");
		System.out.println("There are 4 BMI Categories: " + "\n Obese: BMI = +40 " + "\n Overweight: BMI >= 25 "
				+ "\n Normal: BMI >= 18.5 " + "\n Underweight: BMI < 18.5.");
		System.out.println("The BMI formula used is: weight * 703 / height^2.");

		// new scanner because new method
		Scanner keyboardInput = new Scanner(System.in);
		// Variables
		// declared weight
		double weight;
		// declared height;
		double height;
		// The user's BMI

		weight = checkWeight(keyboardInput);

		height = checkHeight(keyboardInput);

		double bmi = calculateBMI(weight, height);

		// ---- BMI Categories ----

		// Display the user's BMI.
		String bmiCategory = calculateBMICategory(bmi);

		System.out.println("Athlete's BMI is: " + bmi + ". Category: " + bmiCategory);

	}// end of main

	// checks if the inputed weight is valid
	public static double checkWeight(Scanner inputAttempt)
	{
		double weightMaybe;

		// Get the user's weight.
		System.out.print("Enter your weight, in pounds: ");
		weightMaybe = inputAttempt.nextDouble();

		// while the height is negative or 0, allows you to input again.
		while (weightMaybe <= 0)
		{
			System.out.print("Invalid Input, cannot be negative or 0. Enter weight: ");
			weightMaybe = inputAttempt.nextDouble();
		}
		return weightMaybe;
	}

	// checks if the inputed height is valid
	public static double checkHeight(Scanner inputAttempt)
	{
		double heightMaybe;

		// Get the user's height.
		System.out.print("Enter your height, in inches: ");
		heightMaybe = inputAttempt.nextDouble();

		// while the height is negative or 0, allows you to input again.
		while (heightMaybe <= 0)
		{
			System.out.print("Invalid Input, cannot be negative or 0. Enter height: ");
			heightMaybe = inputAttempt.nextDouble();
		}
		return heightMaybe;
	}

	// calculates the BMI using initialized and checked weight and height
	public static double calculateBMI(double finalWeight, double finalHeight)
	{
		// Create constant an variables
		final int BMI_US_FACTOR = 703;
		double bmiResult;

		bmiResult = finalWeight * BMI_US_FACTOR / (Math.pow(finalHeight, 2));

		return bmiResult;
	}

	// determines BMI Category
	public static String calculateBMICategory(double bmiFinal)
	{
		String bmiCategoryName;
		if (bmiFinal >= 40)
		{
			bmiCategoryName = "Obese";
		} else if (bmiFinal >= 25)
		{
			bmiCategoryName = "Overweight";
		} else if (bmiFinal >= 18.5)
		{
			bmiCategoryName = "Normal";
		} else
		{
			bmiCategoryName = "Underweight";
		} // end else

		return bmiCategoryName;
	}

}// end of class
