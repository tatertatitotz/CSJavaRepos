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

		// algorithm
		// weights * grades of the same name

		// calculates weighted class participation grade
		double totalPart = CLASS_PART * classPart;
		// calculates weighted guided exploration grade
		double totalGuided = GUIDED_EX * guidedEx;
		// calculates weighted quiz grade
		double totalQuizzes = QUIZZES * quizzes;
		// calculates weighted project grade
		double totalProjects = PROJECTS * projects;
		// calculates weighted final demonstration grade
		double totalFinalDem = FINAL_DEMO * finalDemo;

		// adds them all up for grade
		// final algorithm step
		double grade = totalPart + totalGuided + totalQuizzes + totalProjects + totalFinalDem;

		// testing results for each weighted grade

		// System.out.println(totalPart);
		// System.out.println(totalGuided);
		// System.out.println(totalQuizzes);
		// System.out.println(totalProjects);
		// System.out.println(totalFinalDem);

		// test output
		System.out.println("Your final grade is: " + grade);

	}// end of main

}// end of class
