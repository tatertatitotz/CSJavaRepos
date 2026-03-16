import java.util.Scanner;

public class LabL15ArraysIntro
{

	public static void main(String[] args)
	{
		Scanner keyboardInput = new Scanner(System.in);

		double[] finalGrades;
		String[] firstNames;
		double sum = 0;
		double average = 0;

		System.out.print("How many students are in the class?: ");
		int arrayLength = keyboardInput.nextInt();

		finalGrades = new double[arrayLength];
		firstNames = new String[arrayLength];

		for (int count = 0; count < arrayLength; ++count)
		{
			System.out.print("First name of one student: ");
			firstNames[count] = keyboardInput.next();

			System.out.print("The Graded of the coresponding student: ");
			finalGrades[count] = keyboardInput.nextDouble();
		}

		sum = calculateSum(finalGrades);
		average = calculateAverage(sum, finalGrades);
	}// end of main

	public static double calculateSum(double[] gradesForSum)
	{
		double finalGradeSum = 0;
		for (int count = 0; count < gradesForSum.length; ++count)
		{
			finalGradeSum = finalGradeSum + gradesForSum[count];

		}

		return finalGradeSum;
	}

	public static double calculateAverage(double calculatedSum, double[] gradesForAverage)
	{
		double finalAverage = 0;
		finalAverage = calculatedSum / gradesForAverage.length;
		System.out.println("The class average is: " + finalAverage);

		return finalAverage;
	}
}
