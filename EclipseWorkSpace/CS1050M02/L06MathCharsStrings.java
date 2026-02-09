
import java.util.Scanner;

public class L06MathCharsStrings
{

	public static void main(String[] args)
	{
		// ------- Math --------------------
		// What is happening for each line?
		// creates a random double
		double randomDouble = Math.random();
		/*
		 * randomInt will always equal 0 because it creates a double starting with 0
		 * randomInt is then turned into an integers all decimal numbers are removed,
		 * leaving 0
		 */
		int randomInt = (int) Math.random();
		// multiplies the double and cuts off the numbers post-decimal
		// this creates a single digit number between 0 =< x < 9
		randomInt = (int) (Math.random() * 10);
		// creates a single digit number between 1 =< x < 10
		randomInt = (int) (Math.random() * 10 + 1);

		// -------- char -------------------

		// declares and initializes charTest as character 'a'
		char charTest = 'a';
		// declares and initializes charAsciiValue as the AsciiValue of charTest
		int charAsciiValue = (int) charTest;
		// declares and initializes firstName as a String "Heriberto"
		String firstName = "Heriberto";

		// measures the # of chars in a String
		int stringLength = firstName.length();
		// points at individual chars at an assigned
		char firstInitial = firstName.charAt(3);
	}

}
