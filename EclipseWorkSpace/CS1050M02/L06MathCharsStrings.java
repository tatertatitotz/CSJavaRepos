
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

		System.out.println("length of the String: " + stringLength);
		System.out.println("fourth letter: " + firstInitial);

		// -------- practice -------------------

		// keyboardInput is the identifier for running the Scanner method
//		Scanner keyboardInput = new Scanner(System.in);
//
//		// console display for user
//		System.out.print("What is your first name?: ");
//		// declares and initializes name1 as the input given from the Scanner
//		String name1 = keyboardInput.next();
//
//		// console display for user
//		System.out.print("What is your last name?: ");
//		// declares and initializes lastIntial
//		char lastInitial = keyboardInput.next().charAt(0);
//
//		// Displays a Hello message with all given inputs
//		System.out.print("Hello " + name1 + " " + lastInitial + "!");
//
//		keyboardInput.close();

		// -------- Mad Lib ---------------------

		Scanner madLibInput = new Scanner(System.in);

		System.out.print("What is your first name?: ");
		String firstNameMadLib = madLibInput.next();

//		adjective
//		place
		System.out.print("What is your last names?: ");
		String lastName = madLibInput.next();

		System.out.print("Enter a noun: ");
		String noun = madLibInput.next();

		System.out.print("Enter a verb: ");
		String verb = madLibInput.next();

		System.out.print("Enter an Adjective: ");
		String adjective = madLibInput.next();
	}

}
