
public class PrintMethodTesting
{

	/**
	 * This class is just about testing print() and its variations
	 */
	public static void main(String[] args)
	{
		char charTest = 'a';
		int charAsciiValue = (int) charTest;
		String firstName = "Heriberto";

		System.out.printf("char: %c ascii value: %d \n", charTest, charAsciiValue);
		System.out.println("Hello " + firstName);

		int compileTimeError = 4;

		int num1 = 10;
		int num2 = 2;

		charAsciiValue = (num1 / (num2 + num2));

		System.out.print(charAsciiValue);
	}

}
