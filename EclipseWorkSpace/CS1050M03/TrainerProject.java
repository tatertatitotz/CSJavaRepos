public class TrainerProject
{

	public static void main(String[] args)
	{
		// prints program summary
		printSummary();

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

}
