import java.util.Scanner;

public class L010LabPart1
{

	public static void main(String[] args)
	{
		Scanner keyboardInput = new Scanner(System.in);
		int exponent;
		while (exponent <= 0);
		{
			System.out.println("Error: Exponent inputted is negative or zero.");
			System.out.print("Enter a positive number for an exponent: ");
			exponent = keyboardInput.nextInt();
		}

		System.out.printf("The exponent is: %d", exponent);

	}

}
