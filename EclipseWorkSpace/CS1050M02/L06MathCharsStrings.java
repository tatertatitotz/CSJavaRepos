
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
		Scanner keyboardInput = new Scanner(System.in);

		// console display for user
		System.out.print("What is your first name?: ");
		// declares and initializes name1 as the input given from the Scanner
		String name1 = keyboardInput.next();

		// console display for user
		System.out.print("What is your last name?: ");
		// declares and initializes lastIntial
		char lastInitial = keyboardInput.next().charAt(0);

		// Displays a Hello message with all given inputs
		System.out.println("Hello " + name1 + " " + lastInitial + "!");

		// -------- Mad Lib ---------------------

		// Added a scanner keyboardInput already added above at line 45

		// Disclaimer because next() ends its function at a space
		System.out.println("Please provide one word answers only!");

		// This section is declaring and initializing variables

		// Asking a question to display in console
		System.out.print("What is your first name?: ");
		/*
		 * declared and initialized firstNameMadLib as the next String detected by
		 * madLibInput. Strings are concatenated (or series of) chars. When you are
		 * spelling, you are concatenating by putting the letters in a certain order.
		 * 
		 * You can initialize a char as a string, but you cannot declare a String as a
		 * char.
		 */
		String firstNameMadLib = keyboardInput.next();

		// Asking a question to display in console
		System.out.print("What is your last name?: ");
		/*
		 * declared and initialized lastName as the first character detected by
		 * madLibInput. charAt(0) means that the first char in the string is going to be
		 * read.
		 */
		char lastName = keyboardInput.next().charAt(0);

		// Asking a question to display in console
		System.out.print("Enter a noun: ");
		/*
		 * When reading a String, the method next() reads the concatenated chars until
		 * it reads a space. A space ends the method.
		 */
		String noun = keyboardInput.next();

		// Asking a question to display in console
		System.out.print("Enter a verb: ");
		// declared and initialized verb as the next String detected by madLibInput
		String verb = keyboardInput.next();

		// Asking a question to display in console
		System.out.print("Enter an Adjective: ");
		// declared and initialized adjective as the next String detected by madLibInput
		String adjective = keyboardInput.next();

		// Asking a question to display in console
		System.out.print("Enter a place: ");
		// declared and initialized firstNameMadLib as the next String detected by
		// madLibInput
		String place = keyboardInput.next();

		System.out.print("What is your favorite letter?: ");
		/*
		 * declared and initialized favoriteLetter as the first character detected by
		 * madLibInput.
		 * 
		 */
		char favoriteLetter = keyboardInput.next().charAt(0);

		// Adds all the variables together!
		// Don't forget to add spaces between everything.
		System.out.print(firstNameMadLib + " " + lastName + " was at " + place + " and " + verb + " with a " + adjective
				+ " " + noun + ". " + firstNameMadLib + " couldn't help but think: " + favoriteLetter
				+ " is my favorite letter.");

		keyboardInput.close();
	}

}
