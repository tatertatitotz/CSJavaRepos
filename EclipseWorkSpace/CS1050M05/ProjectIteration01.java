import java.util.Scanner;

public class ProjectIteration01
{
	public static void main(String[] args)
	{
		Scanner inputMain = new Scanner(System.in);
		String[] namesMain
		double[] heartRatesMain;
		double[] bmiMain;

		int numberOfAthletes = howManyAthletes(inputMain);

		namesMain = new String[numberOfAthletes];
		heartRatesMain = new double[numberOfAthletes];
		bmiMain = new double[numberOfAthletes];

		enterAthleteData(namesMain, bmiMain, heartRatesMain, inputMain);

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

	public static void enterAthleteData(String[] names, double[] bmi, double[] heartRates, Scanner input)
	{
		for (int count = 0; count < names.length; ++count)
		{
			System.out.print("Enter athlete's first name: ");
			names[count] = input.next();

			double weight = 0;
			double height = 0;
			double age = 0;
				System.out.print("Enter weight in pounds: ");
				weight = input.nextDouble();
				System.out.print("Enter height in inches: ");
				height = input.nextDouble();
				System.out.print("Enter age in years: ");
				age = input.nextDouble();
		} // end of for loop
	}// end enterAthleteData

}// end class
