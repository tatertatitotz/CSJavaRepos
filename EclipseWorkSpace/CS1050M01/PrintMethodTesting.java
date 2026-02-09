
public class PrintMethodTesting
{

	/**
	 * This class is just about testing print() and its variations
	 */
	public static void main(String[] args)
	{
		int age = 10;

		System.out.printf("My age is %d", age);

		// possible mistake
		double testOne = 6 * 9 ^ 2;
		System.out.println("6 * 9 ^ 2 = " + testOne);

		// intended result
		double testTwo = (6 * 9) ^ 2;
		System.out.print("(6 * 9)^ 2 = " + testTwo);
	}

}
