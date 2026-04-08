import java.util.Scanner;

public class ProjectIteration01
{
	public static void main(String[] args)
	{
		Scanner inputMain = new Scanner(System.in);
		String[] namesMain;
		double[] weight;
		double[] height;
		double[] heartRatesMain;
		double[] bmiMain;

		int numberOfAthletes = howManyAthletes(inputMain);

	}// end main

	public static boolean getValidNumber(double checkNumber)
	{
		boolean positiveNumber = true;

		if (checkNumber <= 0)
		{
			System.out.println("Error: Value must be greater than 0.");
			positiveNumber = false;
		}

		return positiveNumber;
	}

	public static int howManyAthletes(Scanner inputNumber)
	{
		int athletes;

		do
		{
			System.out.print("Enter the number of athletes on the team: ");
			athletes = inputNumber.nextInt();
		} while (getValidNumber(athletes) == false);

		return athletes;
	}
}// end class
