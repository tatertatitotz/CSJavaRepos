/*
 * 	Name: Tat Chock
 * 	Class: CS1050 (M/W)
 * 	Description: Project Iteration 01 Design Athlete Trainer Program
 * 
 * Allows a user to input custom data for a multitude of athletes
 * Program calculates Body Mass Index (BMI), BMI Category, and Max Heart Rate (MHR)
 * BMI Categories are Obese, Overweight, Normal, and Underweight
 * Displays athlete name, bmi, mhr, and bmi category
 * Displays all athletes above and below normal bmi category
 * Displays athletes above or equal to max heart rate
 * Displays person with highest MHR
 * Calculates average max heart rate
 * Displays and Calculates training heart rate
 */

import java.util.Scanner;

public class ProjectIteration02
{
	public static void main(String[] args)
	{
		// variables for methods later in main
		Scanner inputMain = new Scanner(System.in);
		String[] namesMain;
		double[] heartRatesMain;
		double[] bmiMain;
		double averageMHRMain;

		// just a basic display for what the program does
		programOverview();

		// Formatting so the console is easier to read
		System.out.println("**************************************\r\n" + "Athlete Entry\r\n"
				+ "**************************************");
		// how many athletes are on the team
		int numberOfAthletes = howManyAthletes(inputMain);

		// sets length of arrays according to # team members
		namesMain = new String[numberOfAthletes];
		heartRatesMain = new double[numberOfAthletes];
		bmiMain = new double[numberOfAthletes];

		// console separation
		System.out.println("========== Athlete Summary==========");

		// console separation
		System.out.println("========== BMI Analysis ==========");

		// console separation
		System.out.println("========== MHR Analysis ==========");
		// calculates average Max Heart Rate from the team
		averageMHRMain = calculateAverageMHR(heartRatesMain);
		calculateHighestMHR(namesMain, heartRatesMain);
		// console separation
		System.out.print("\n");

		// console separation
		System.out.print("\n**************************************\n" + "Training Program Analysis Complete\n"
				+ "**************************************\n");

		inputMain.close();

	}// end main

	// displays program function in the console
	public static void programOverview()
	{
		System.out.println("**************************************\n" + "Program Overview\n"
				+ "**************************************\n" + "The trainer enters how many athletes are on the team.\n"
				+ "Then the trainer enters each athlete's weight, height and age.\n"
				+ "For each athlete, the program calculates BMI and Max Heart Rate.\n" + "BMI Categories\n"
				+ "Under 18.5: Underweight\r\n" + "18.5 to under 30: Normal\n" + "30 or greater: High\n" + "\n"
				+ "Calculates percentage of max heart rate for athlete training goal if needed" + "\n");
	}

	/**
	 * checks if the number given (checkNumber) is a positive non-zero number
	 * 
	 * @param checkNumber is the number that you are checking to be positive (can be
	 *                    an int or double)
	 * @return a boolean. True if positive, false it negative or zero. Allows while
	 *         loop usage.
	 */
	public static boolean getValidNumber(double checkNumber)
	{
		boolean positiveNumber = true;

		if (checkNumber <= 0)
		{
			// Error message for clarity
			System.out.println("Error: Value must be greater than 0.");
			positiveNumber = false;
		}

		return positiveNumber;
	}

	/**
	 * Prompts user how many Athletes there are to determine how many times the for
	 * loops in other methods should repeat for. getValidNumber means it must be a
	 * positive input
	 * 
	 * @param inputNumber is the number that you want to give an error message for
	 *                    when it not positive
	 * @return int indicating how long the parallel arrays should be
	 */
	public static int howManyAthletes(Scanner inputNumber)
	{
		int athletes;

		// forces them to repeat until they enter a valid number
		do
		{
			System.out.print("Enter the number of athletes on the team: \r");
			athletes = inputNumber.nextInt();
		} while (getValidNumber(athletes) == false);

		return athletes;
	}

	/**
	 * Calculates BMI using the formula
	 * 
	 * @param weight inputed in enterAthleteData
	 * @param height inputed in enterAthleteData
	 * @return the fully calculated bmi for the array
	 */
	public static double calculateBMI(double weightBMI, double heightBMI)
	{
		final int BMI_FACTOR = 703;
		double finalBMI;

		// bmi formula
		finalBMI = 703 * weightBMI / Math.pow(heightBMI, 2);

		return finalBMI;
	}

	/**
	 * Uses the formula for MHR to calculate MHR
	 * 
	 * @param ageMHR is age of athletes
	 * @return max heart rate
	 */
	public static double calculateMHR(double ageMHR)
	{
		final int MHR_FACTOR = 220;
		double mhr;

		// MAX HEART RATE (MHR) formula
		mhr = MHR_FACTOR - ageMHR;
		return mhr;
	}

	/**
	 * Determines BMI category based on BMI ranges
	 * 
	 * Category Scale: Obese: > 40 Overweight: 39.999 to 25 Normal: 24.999 to 18.5
	 * Underweight: < 18.499
	 * 
	 * @param bmiGiven is the Athletes bmi passed from the array
	 * @return the category name
	 */
	public static String bmiCategory(double bmiGiven)
	{
		// categories for BMI ranges
		String bmiCategoryName;
		if (bmiGiven >= 40)
		{
			bmiCategoryName = "Obese";
		} else if (bmiGiven >= 25)
		{
			bmiCategoryName = "Overweight";
		} else if (bmiGiven >= 18.5)
		{
			bmiCategoryName = "Normal";
		} else
		{
			bmiCategoryName = "Underweight";
		} // end else

		return bmiCategoryName;
	}

	/**
	 * Determines the person with the highest mhr by sifting through the entire
	 * array of mhrs
	 * 
	 * @param nameHigh is the athletes name
	 * @param mhrHigh  is all athletes max heart rates
	 */
	public static void calculateHighestMHR(String[] nameHigh, double[] mhrHigh)
	{
		double highestMHR = 0;
		int indexMHR = 0;
		// finds the index of the person with the highest MHR
		for (int count = 0; count < nameHigh.length; ++count)
		{
			if (highestMHR < mhrHigh[count])
			{
				highestMHR = mhrHigh[count];
				indexMHR = count;
			}
		}
		// prints the name and MHR of the person with the highestMHR
		System.out.println(nameHigh[indexMHR] + " has highest max heart rate: " + mhrHigh[indexMHR] + "\n");
	}

	/**
	 * Calculates average MHR from all the athletes
	 * 
	 * @param heartRatesForAvg all athletes max heart rates
	 * @return
	 */
	public static double calculateAverageMHR(double[] heartRatesForAvg)
	{
		double averageMHR = 0;

		for (int count = 0; count < heartRatesForAvg.length; ++count)
		{
			// sums all the athlete's mhrs
			averageMHR = averageMHR + heartRatesForAvg[count];
		}
		averageMHR = averageMHR / heartRatesForAvg.length;

		System.out.println("Team Average Max Heart Rates: " + averageMHR + "\n");

		return averageMHR;
	}
}// end class

class Athletes
{
	private String name;
	private double weight;
	private double height;
	private double age;

	Athletes()
	{

	}

}