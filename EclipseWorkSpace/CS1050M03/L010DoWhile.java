import java.util.Scanner;

public class L010DoWhile
{

	public static void main(String[] args)
	{
		// creates a scanner called keyboardInput
		Scanner keyboardInput = new Scanner(System.in);
		// declares exponent
		int exponent;
		do
		{
			{
				System.out.println("Error: Exponent inputted is negative or zero.");
			}
		} while (exponent <= 0);
		System.out.printf("The exponent is: %d", exponent);
	}

}
