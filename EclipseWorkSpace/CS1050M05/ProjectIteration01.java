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
		trainingHeartRate(namesMain, heartRatesMain, inputMain);

		// console separation
		System.out.print("\n**************************************\n" + "Training Program Analysis Complete\n"
				+ "**************************************\n");

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

	// checks if the custom ints and doubles aren't 0 or negative for proper inputs.
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

	public static double calculateBMI(double weight, double height)
	{
		final int BMI_FACTOR = 703;
		double finalBMI;

		// bmi formula
		finalBMI = 703 * weight / Math.pow(height, 2);

		return finalBMI;
	}

	public static double calculateMHR(double ageMHR)
	{
		final int MHR_FACTOR = 220;
		double mhr;

		// MAX HEART RATE (MHR) formula
		mhr = MHR_FACTOR - ageMHR;
		return mhr;
	}

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
	}

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

	public static void trainingHeartRate(String[] nameTrain, double[] mhrTrain, Scanner answerInput)
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

		double trainingPercentage;
		final int TO_PERCENT = 100;

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
	}
}// end class
