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

		calculateSum(finalGrades);
	}// end of main
	public static double calculateSum(double[] gradesForSum)
	{
		double finalGradeSum = 0;
		for (int count = 0; count < gradesForSum.length; ++count)
		{
			System.out.print("The Graded of the coresponding student: ");
			finalGradeSum = finalGradeSum + gradesForSum[count];
		}

		return finalGradeSum;
	}

}
