import java.util.Scanner;

public class LabL15ArraysIntro
{

	public static void main(String[] args)
	{
		Scanner keyboardInput = new Scanner(System.in);

		// declare arrays
		double[] finalGrades;
		String[] firstNames;
		// declare and initialize sum + average
		double sum = 0;
		double average = 0;

		// prompt for array length for both finalGrades and firstNames
		System.out.print("How many students are in the class?: ");
		int arrayLength = keyboardInput.nextInt();

		// allocates memory for arrays
		finalGrades = new double[arrayLength];
		firstNames = new String[arrayLength];

		// initializes both arrays
		for (int count = 0; count < arrayLength; ++count)
		{
			// allows user to input individual names for each array index
			System.out.print("First name of one student: ");
			firstNames[count] = keyboardInput.next();

			// allows user to input individual grades for each array index parallel to names
			// both arrays
			System.out.print(firstNames[count] + "'s grade: ");
			finalGrades[count] = keyboardInput.nextDouble();
		}

		// caluclates the sum
		sum = calculateSum(finalGrades);
		average = calculateAverage(sum, finalGrades);

		aboveAverageDisplay(finalGrades, firstNames, average);

		keyboardInput.close();
	}// end of main

	public static double calculateSum(double[] gradesForSum)
	{
		double finalGradeSum = 0;
		// goes though each value in the array index
		for (int count = 0; count < gradesForSum.length; ++count)
		{
			// Adds each array value to the finalGradeSum
			finalGradeSum = finalGradeSum + gradesForSum[count];

		}

		return finalGradeSum;
	}

	public static double calculateAverage(double calculatedSum, double[] gradesForAverage)
	{
		double finalAverage = 0;
		// average is calculated by sum and total number of values
		finalAverage = calculatedSum / gradesForAverage.length;
		// displays the class average
		System.out.println("The class average is: " + finalAverage);

		return finalAverage;
	}

	public static void aboveAverageDisplay(double[] displayGrades, String[] displayNames, double averageGrades)
	{

		for (int count = 0; count < displayGrades.length; ++count)
		{
			// goes through each student
			if (displayGrades[count] > averageGrades)
			{
				// prints out each student's name and grade ONLY IF they scored above average.
				System.out.println(
						displayNames[count] + " with a grade of " + displayGrades[count] + " is above Average");
			}
//			else
//			{
//				System.out
//						.println(displayNames[count] + " did not score above average. Grade: " + displayGrades[count]);
//			}

		}
	}
}
// end of class
