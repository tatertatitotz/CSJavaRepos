import java.util.Scanner;

public class LabL15ArraysIntro
{

	public static void main(String[] args)
	{
		Scanner keyboardInput = new Scanner(System.in);

		double[] finalGrades;
		String[] firstNames;

		System.out.print("How many students are in the class?: ");
		int arrayLength = keyboardInput.nextInt();

		finalGrades = new double[arrayLength];
		firstNames = new String[arrayLength];

		for (int count = 0; count < arrayLength; ++count)
		{
			System.out.print("First name of one student: ");
		}
	}

}
