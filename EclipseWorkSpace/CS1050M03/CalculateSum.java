import java.util.Scanner;

public class CalculateSum
{

	public static void main(String[] args)
	{
		int sum = 0;

		Scanner keyboardInput = new Scanner(System.in);

		System.out.print("What is your max?: ");
		int max = keyboardInput.nextInt();

		userMax(max);
		System.out.print(max);
	}// end of main

	// max is now defined as inputtedMax
	public static int userMax(int inputtedMax)
	{
		while (inputtedMax <= 0)
		{
			Scanner keyboardInput = new Scanner(System.in);
			inputtedMax = keyboardInput.nextInt();
		}
}// end of class
