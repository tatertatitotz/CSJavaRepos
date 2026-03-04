import java.util.Scanner;

public class CalculateSum
{

	public static void main(String[] args)
	{
		// declares/initializes sum
		int sum = 0;

		// scanner for max
		Scanner keyboardInput = new Scanner(System.in);

		// console prompt for max
		System.out.print("What is your max?: ");
		// declares/initializes max with user input
		int max = keyboardInput.nextInt();
		keyboardInput.close();

		// checks if max is valid (not negative)
		max = checkMax(max);
		System.out.println("Your max is: " + max);

		// calculates the sum
		sum = compoundingSum(sum, max);
		System.out.println("Your sum is: " + sum);
	}// end of main

	// max is now defined as inputtedMax
	public static int checkMax(int inputtedMax)
	{
		// while the inputtedMax it will prompt the user until valid
		while (inputtedMax <= 0)
		{
			Scanner keyboardInput = new Scanner(System.in);
			System.out.print("Incorrect input. Try again: ");
			inputtedMax = keyboardInput.nextInt();
			keyboardInput.close();
		}
		// checkMax(max) = inputtedMax
		return inputtedMax;

	}// end of checkMax

	// calculating the sum, takes both sum and max
	public static int compoundingSum(int completeSum, int initializedMax)
	{
		// adds 1 to add each time it loops
		for (int add = 0; add <= initializedMax; ++add)
		{
			completeSum = completeSum + add;
			// prints
			System.out.println(completeSum);
		}
		// compoundingSum(sum, max) == completeSum
		return completeSum;
	}

}// end of class
