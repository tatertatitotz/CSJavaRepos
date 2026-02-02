/*
 *  Name: [TAT CHOCK]
 *  Class: CS1050 (M/W) 2/2/2026
 *  Description: Guided Exploration 01      
 *  The program will calculate a final grade for this class based on the category weights 
 */
public class GEM01GradeCalculations
{
	public static void main(String[] args)
	{
		// constant weights
		final double CLASS_PART = 0.15;
		final double GUIDED_EX = 0.2;
		final double QUIZZES = 0.25;
		final double PROJECTS = 0.2;
		final double FINAL_DEMO = 0.2;

		// grades
		double classPart = 95;
		double guidedEx = 92;
		double quizzes = 88;
		double projects = 87;
		double finalDemo = 93;

		double totalPart = CLASS_PART * classPart;

		System.out.println(totalPart);

	}// end of main

}// end of class
