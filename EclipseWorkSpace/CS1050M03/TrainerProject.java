import java.util.Scanner;

public class TrainerProject
{

	public static void main(String[] args)
	{
		// prints program summary
		printSummary();

		// creates a scanner
		Scanner keyboardinput = new Scanner(System.in);

		// declared and initialized variables to assign later
		double weight = 0;
		double height = 0;
		double bmi = 0;
		boolean continueProcess;

		// while restart is true, do this
			// Get the user's weight.
			System.out.print("Enter your weight, in pounds: ");
			// weight
			weight = getPositiveDouble(keyboardinput, weight);

			// Get the user's weight.
			System.out.print("Enter your height, in inches: ");
			// height
			height = getPositiveDouble(keyboardinput, height);
	}

	public static void printSummary()
	{
		// Tell the user what the program will do.
		System.out.println(
				"This program will calculate your body mass index, or BMI using the imperial measurement system (pounds and inches).");
		System.out.println("There are 4 BMI Categories: " + "\n Obese: BMI = +40 " + "\n Overweight: BMI >= 25 "
				+ "\n Normal: BMI >= 18.5 " + "\n Underweight: BMI < 18.5.");
		System.out.println("The BMI formula used is: weight * 703 / height^2.");
	}

	public static double getPositiveDouble(Scanner input, double bmiInput)
	{
		return bmiInput;
	}
}
