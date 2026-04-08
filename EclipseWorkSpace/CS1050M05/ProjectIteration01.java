import java.util.Scanner;

public class ProjectIteration01
{
	public static void main(String[] args)
	{
		Scanner inputMain = new Scanner(System.in);
		String[] namesMain;
		double[] heartRatesMain;
		double[] bmiMain;

		programOverview();

		int numberOfAthletes = howManyAthletes(inputMain);

		namesMain = new String[numberOfAthletes];
		heartRatesMain = new double[numberOfAthletes];
		bmiMain = new double[numberOfAthletes];

		enterAthleteData(namesMain, bmiMain, heartRatesMain, inputMain);

	}// end main

	public static void programOverview()
	{
		System.out.println("**************************************\n" + "Program Overview\n"
				+ "**************************************\n" + "The trainer enters how many athletes are on the team.\n"
				+ "Then the trainer enters each athlete's weight, height and age.\n"
				+ "For each athlete, the program calculates BMI and Max Heart Rate.\n" + "BMI Categories\n"
				+ "Under 18.5: Underweight\r\n" + "18.5 to under 30: Normal\n" + "30 or greater: High\n" + "\n"
				+ "Calculates percentage of max heart rate for athlete training goal if needed" + "\n");
	}

	public static boolean getValidNumber(double checkNumber)
	{
		boolean positiveNumber = true;

		if (checkNumber <= 0)
		{
			System.out.println("Error: Value must be greater than 0.");
			positiveNumber = false;
		}

		return positiveNumber;
	}

	public static int howManyAthletes(Scanner inputNumber)
	{
		int athletes;

		do
		{
			System.out.print("Enter the number of athletes on the team: ");
			athletes = inputNumber.nextInt();
		} while (getValidNumber(athletes) == false);

		return athletes;
	}

	public static void enterAthleteData(String[] names, double[] bmi, double[] heartRates, Scanner input)
	{
		for (int count = 0; count < names.length; ++count)
		{
			System.out.print("Enter athlete's first name: ");
			names[count] = input.next();

			double weight = 0;
			double height = 0;
			int age = 0;

			do
			{
				System.out.print("Enter weight in pounds: ");
				weight = input.nextDouble();
			} while (getValidNumber(weight) == false);

			do
			{
				System.out.print("Enter height in inches: ");
				height = input.nextDouble();
			} while (getValidNumber(height) == false);

			bmi[count] = calculateBMI(weight, height);
			do
			{
				System.out.print("Enter age in years: ");
				age = input.nextInt();

			} while (getValidNumber(age) == false);

			heartRates[count] = calculateMHR(age);

		} // end of for loop
	}// end enterAthleteData

	public static double calculateBMI(double weight, double height)
	{
		final int BMI_FACTOR = 703;
		double finalBMI;

		finalBMI = 703 * weight / Math.pow(height, 2);

		return finalBMI;
	}

	public static double calculateMHR(double ageMHR)
	{
		final int MHR_FACTOR = 220;
		double mhr;
		mhr = MHR_FACTOR - ageMHR;
		return mhr;
	}

	public static double calculateAverageMHR(double[] heartRatesForAvg)
	{
		double averageMHR;

		return averageMHR;
	}
}// end class
