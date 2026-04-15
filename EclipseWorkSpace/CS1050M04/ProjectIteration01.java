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

public class ProjectIteration01
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

		// allows user to enter custom athlete data
		enterAthleteData(namesMain, bmiMain, heartRatesMain, inputMain);

		// console separation
		System.out.println("========== Athlete Summary==========");
		// console output with all athlete data that was inputed
		displayAthleteBMI(namesMain, bmiMain, heartRatesMain);

		// console separation
		System.out.println("========== BMI Analysis ==========");
		// makes a list of people above/below normal bmi category (if none it displays
		// that too)
		outsideNormalBMI(namesMain, bmiMain);

		// console separation
		System.out.println("========== MHR Analysis ==========");
		// calculates average Max Heart Rate from the team
		averageMHRMain = calculateAverageMHR(heartRatesMain);
		calculateHighestMHR(namesMain, heartRatesMain);
		// all athlete that have an mhr above average have their names listed
		displayAboveAverage(namesMain, heartRatesMain, averageMHRMain);
		// console separation
		System.out.print("\n");
		// asks user if they want to calculate training heart rates (displays them too)
		displayTrainingHeartRate(namesMain, heartRatesMain, inputMain);
		// console separation
		System.out.print("\n**************************************\n" + "Training Program Analysis Complete\n"
				+ "**************************************\n");

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
	 * Allows the user to input custom data like names, weight, height, and age
	 * Calculates bmi and mhr using other methods Just sets up the parallel arrays
	 * 
	 * @param names      is for setting names
	 * @param bmi        is determined by weight and height
	 * @param heartRates determined by age
	 * @param input      a scanner for the custom inputs
	 */
	public static void enterAthleteData(String[] names, double[] bmi, double[] heartRates, Scanner input)
	{
		// allows the user to assign each athlete a name, weight, height and age.
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

			// completes the bmi calculation in the background (no display for calc)
			bmi[count] = calculateBMI(weight, height);
			do
			{
				System.out.print("Enter age in years: " + "\r");
				age = input.nextInt();

			} while (getValidNumber(age) == false);
			// completes the mhr calculation in the background (no display for calc)
			heartRates[count] = calculateMHR(age);

		} // end of for loop
	}// end enterAthleteData

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
	 * Just prints the names bmi and mhr of all athletes.
	 * 
	 * @param nameBMI    names of athletes
	 * @param bmiDisplay bmi for athletes
	 * @param mhrDisplay max heart rates of athletes
	 */
	public static void displayAthleteBMI(String[] nameBMI, double[] bmiDisplay, double[] mhrDisplay)
	{
		// basic list of athletes and their newly calculated stats (IE: BMI and MHR)
		for (int count = 0; count < nameBMI.length; ++count)
		{
			System.out.println(nameBMI[count]);
			System.out.println("BMI: " + bmiDisplay[count]);
			// category is calculated during the print part so that it isn't taking up space
			// in memory
			System.out.println("Category: " + bmiCategory(bmiDisplay[count]));
			System.out.println("MHR: " + mhrDisplay[count] + "\n");
		}
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
	 * Displays the names and orientation relative to the normal bmi category
	 * parameter
	 * 
	 * Above Normal: > 25 Below Normal: < 18.4999
	 * 
	 * if neither apply and they've gone through every Athlete, it displays that all
	 * are normal
	 *
	 * @param nameNoNorm athlete names
	 * @param bmiNoNorm  athlete Calculated bmi
	 */
	public static void outsideNormalBMI(String[] nameNoNorm, double[] bmiNoNorm)
	{
		int normalBMI = 0;

		for (int count = 0; count < nameNoNorm.length; ++count)
		{
			// different messages depending on if the athlete is above or below normal BMI
			if (bmiNoNorm[count] >= 25)
			{
				System.out.println("Above Normal: " + nameNoNorm[count]);
			} else if (bmiNoNorm[count] < 18.5)
			{
				System.out.println("Below Normal: " + nameNoNorm[count]);
			} else
			{
				++normalBMI;
			}
		}
		// if all of them are within normal this is run
		if (normalBMI == nameNoNorm.length)
		{
			System.out.println("No athletes outside of normal range");
		}
		System.out.print("\n");
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

	/**
	 * displays the names of everyone that has a max heart rate higher or equal to
	 * average max heart rate
	 * 
	 * @param nameAbove      names of all the athletes on the team
	 * @param mhrCheckAbove  max heart rates of all the athletes
	 * @param averageCompare average of all max heart rates
	 */
	public static void displayAboveAverage(String[] nameAbove, double[] mhrCheckAbove, double averageCompare)
	{
		System.out.print("Athletes above or equal to average MHR: \n");
		for (int count = 0; count < nameAbove.length; ++count)
		{
			// prints and athletes name if they are above or equal to averageMHR
			if (mhrCheckAbove[count] >= averageCompare)
			{
				System.out.println(nameAbove[count]);
			}
		}
	}

	/**
	 * Asks you if you want to calculate training heart rates. Prompts you with a
	 * yes or no answer checks if your input is valid (only accepts yes and no)
	 * Multiplies the given mhr to the percentage defined by the user displays names
	 * and newly calculated training heart rates
	 * 
	 * @param nameTrain   array with all athletes names
	 * @param mhrTrain    max heart rates names
	 * @param answerInput scanner to detect
	 */
	public static void displayTrainingHeartRate(String[] nameTrain, double[] mhrTrain, Scanner answerInput)
	{
		char answer;

		// did a do-while with an if statement so that I didn't have to re write the
		// prompt when the answer was invalid.
		do
		{
			System.out.print("Do you want to calculate the training heart rates? (y/n): ");
			answer = Character.toLowerCase(answerInput.next().charAt(0));

			if (answer != 'y' && answer != 'n')
			{
				System.out.println("Error: enter y, Y, n, or N.");
			}
		} while (answer != 'y' && answer != 'n');

		// initialize variables for calculation
		final int TO_PERCENT = 100;
		double trainingPercentage;

		// if the answer determined in the first part of this method is yes (y) the
		// calculation and display runs
		if (answer == 'y')
		{
			do
			{
				System.out.print("Enter training percentage: \r");
				trainingPercentage = answerInput.nextDouble();

			} while (getValidNumber(trainingPercentage) == false);

			for (int count = 0; count < nameTrain.length; ++count)
			{
				mhrTrain[count] = mhrTrain[count] * (trainingPercentage / TO_PERCENT);

				System.out.println(nameTrain[count] + " Training Heart Rate: " + mhrTrain[count]);
			}
		}
		// if the answer determined in the first part is NOT y, but instead n (only
		// other option)
		// then the method ends.
		else
		{
			return;
		}
	}
}// end class
