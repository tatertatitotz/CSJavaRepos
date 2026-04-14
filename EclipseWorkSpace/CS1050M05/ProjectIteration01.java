import java.util.Scanner;

public class ProjectIteration01
{
	public static void main(String[] args)
	{
		Scanner inputMain = new Scanner(System.in);
//		String[] namesMain;
//		double[] heartRatesMain;
//		double[] bmiMain;
		double averageMHRMain;

		programOverview();

		System.out.println("**************************************\r\n" + "Athlete Entry\r\n"
				+ "**************************************");

		int numberOfAthletes = 6;// howManyAthletes(inputMain);

//		namesMain = new String[numberOfAthletes];
//		heartRatesMain = new double[numberOfAthletes];
//		bmiMain = new double[numberOfAthletes];

		String[] namesMain =
		{ "Gregg", "Vivian", "Tabu", "Horus", "Vezzek", "Endren" };
		double[] heartRatesMain =
		{ 120, 200, 200, 300, 220, 240 };
		double[] bmiMain =
		{ 20, 20, 20, 20, 20, 20 };

		// enterAthleteData(namesMain, bmiMain, heartRatesMain, inputMain);

		System.out.println("========== Athlete Summary==========");
		displayAthleteBMI(namesMain, bmiMain, heartRatesMain);

		System.out.println("========== BMI Analysis ==========");
		outsideNormalBMI(namesMain, bmiMain);

		System.out.println("========== MHR Analysis ==========");
		averageMHRMain = calculateAverageMHR(heartRatesMain);
		calculateHighestMHR(namesMain, heartRatesMain);
		displayAboveAverage(namesMain, heartRatesMain, averageMHRMain);
		System.out.print("\n");
		trainingHeartRate(namesMain, heartRatesMain, inputMain);

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
			System.out.println("Enter the number of athletes on the team: \r");
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
				System.out.print("Enter age in years: " + "\r");
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

	public static void displayAthleteBMI(String[] nameBMI, double[] bmiDisplay, double[] mhrDisplay)
	{

		for (int count = 0; count < nameBMI.length; ++count)
		{
			System.out.println(nameBMI[count]);
			System.out.println("BMI: " + bmiDisplay[count]);
			System.out.println("Category: " + bmiCategory(bmiDisplay[count]));
			System.out.println("MHR: " + mhrDisplay[count] + "\n");
		}
	}

	public static String bmiCategory(double bmiGiven)
	{
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
			if (bmiNoNorm[count] >= 25)
			{
				System.out.print("Above Normal: " + nameNoNorm[count]);
			} else if (bmiNoNorm[count] < 18.5)
			{
				System.out.print("Below Normal: " + nameNoNorm[count]);
			} else
			{
				++normalBMI;
			}
		}
		if (normalBMI == nameNoNorm.length)
		{
			System.out.print("No athletes outside of normal range");
		}
		System.out.println("\n");
	}

	public static void calculateHighestMHR(String[] nameHigh, double[] mhrHigh)
	{
		double highestMHR = 0;
		int indexMHR = 0;
		for (int count = 0; count < nameHigh.length; ++count)
		{
			if (highestMHR < mhrHigh[count])
			{
				highestMHR = mhrHigh[count];
				indexMHR = count;
			}
		}
		System.out.println(nameHigh[indexMHR] + " has highest max heart rate: " + mhrHigh[indexMHR] + "\n");
	}

	public static double calculateAverageMHR(double[] heartRatesForAvg)
	{
		double averageMHR = 0;

		for (int count = 0; count < heartRatesForAvg.length; ++count)
		{
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
			if (mhrCheckAbove[count] >= averageCompare)
			{
				System.out.println(nameAbove[count]);
			}
		}
	}

	public static void trainingHeartRate(String[] nameTrain, double[] mhrTrain, Scanner answerInput)
	{
		char answer;

		do
		{
			System.out.print("Do you want to calculate the training heart rates? (y/n): ");
			answer = Character.toLowerCase(answerInput.next().charAt(0));

			if (answer != 'y' && answer != 'n')
			{
				System.out.println("Error: enter y, Y, n, or N.");
			}
		} while (answer != 'y' && answer != 'n');
	}
}// end class
