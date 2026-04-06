import java.util.Scanner;

public class TestMethod
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		displayProgramOverview(input);

		double[] testCase =
		{ 190, 190, 197, 192, 161, 200 };

		System.out.print(calcAvgMHR(testCase));

	}// end main

	public static void displayProgramOverview(Scanner overviewInput)
	{
		System.out.println("**************************************\r\n" + "Program Overview\r\n"
				+ "**************************************\r\n"
				+ "The trainer enters how many athletes are on the team.\r\n"
				+ "Then the trainer enters each athlete's weight, height and age.\r\n"
				+ "For each athlete, the program calculates BMI and Max Heart Rate.\r\n" + "BMI Categories\r\n"
				+ "Under 18.5: Underweight\r\n" + "18.5 to under 30: Normal\r\n" + "30 or greater: High\r\n" + "\r\n"
				+ "Calculates percentage of max heart rate for athlete training goal if needed\r\n" + "");
	}

	public static double calcAvgMHR(double[] MHR)
	{
		double average = 0;
		double sum = 0;

		for (int index = 0; index < MHR.length; index++)
		{
			sum = sum + MHR[index];
		}

		average = sum / MHR.length;
		return average;
	}

}
