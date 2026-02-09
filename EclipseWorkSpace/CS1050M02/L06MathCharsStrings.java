/**
 * 
 */

/**
 * 
 */
public class L06MathCharsStrings
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
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

	}

}
