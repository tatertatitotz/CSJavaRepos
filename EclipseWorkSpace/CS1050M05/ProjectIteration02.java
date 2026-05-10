/*
 * 	Name: Tat Chock
 * 	Class: CS1050 (M/W)
 * 	Description: Project Iteration 01 Design Athlete Trainer Program
 * 
 * Allows a user to input custom data for a multitude of athletes
 * Program calculates Body Mass Index (BMI), BMI Category, and Max Heart Rate (MHR)
 * BMI Categories are Obese, Overweight, Normal, and Underweight
 * Displays athlete name, bmi, mhr, and bmi category
 * Displays all athletes above and below normal bmi category
 * Calculates average max heart rate
 * Displays athletes above or equal to average max heart rate
 * Displays person with highest MHR
 * Displays shortest and tallest athletes on a team
 * Writes the data (Names, BMI, Category, MHR) to a file named with the following convention:
 * [teamName].txt
 * Also displays the file path for the athlete data
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProjectIteration02
{
	public static void main(String[] args)
	{
		displayProgramSummary();

		// ===== TEST 1 =====
		String fileName = "team1.txt";

		try
		{
			System.out.println("Testing file: " + fileName);

			Team team = new Team("Nuggets", 3);

			teamSetUp(fileName, team);

			runAnalysis(team);

		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}

		// ===== TEST 2 =====
		fileName = "team2.txt";

		try
		{
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Team CS", 4);

			teamSetUp(fileName, team);

			runAnalysis(team);

		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}

		System.out.println("\nEnd of program");
	}

	public static void teamSetUp(String fileName, Team team) throws FileNotFoundException
	{
		File fileReference = new File(fileName);

		Scanner reader = new Scanner(fileReference);

		while (reader.hasNext())
		{
			Athlete athlete = new Athlete(reader.next(), reader.nextDouble(), reader.nextDouble(), reader.nextInt());
			team.addAthlete(athlete);
		}
	}

	public static void runAnalysis(Team team) throws FileNotFoundException
	{
		System.out.println("\n========== Athlete Summary ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getAthleteCount());
		System.out.println();

		team.displayAthleteResults();

		System.out.println("========== Team Analysis ==========");
		team.displayAthletesOutsideNormalBMI();

		double avg = team.calculateAverageMHR();
		System.out.println("\nAverage Max Heart Rate: " + avg + "\n");

		team.displayAthletesAboveAverageMHR(avg);
		team.displayHighestMHR();
		team.displaySmallestLargestHeight();
		String outputFileName = team.getTeamName() + ".txt";
		try
		{
			team.writeAthletesToFile(outputFileName);
		} catch (FileNotFoundException exception)
		{
			System.out.print("File Not Found");
		}

	}

	// ================= DISPLAY =================

	public static void displayProgramSummary()
	{
		System.out.println("**************************************");
		System.out.println("Team and Athlete Analysis");
		System.out.println("**************************************");
		System.out.println("Reads athlete data from file");
		System.out.println("Displays athlete results");
		System.out.println("Performs team analysis");
		System.out.println("Writes results to file");
		System.out.println();
	}
}

class Athlete
{
	private String name;
	private double weight;
	private double height;
	private double age;

	public Athlete(String name, double weight, double height, double age)
	{
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public double getHeight()
	{
		return height;
	}

	/**
	 * Calculates BMI using the formula
	 * 
	 * @return the fully calculated bmi for the array
	 */
	public double calculateBMI()
	{
		double bmi;
		final int BMI_FACTOR = 703;

		// bmi formula
		bmi = 703 * weight / Math.pow(height, 2);

		return bmi;
	}

	/**
	 * Uses the formula for MHR to calculate MHR
	 * 
	 * @param ageMHR is age of athletes
	 * @return max heart rate
	 */
	public double calculateMHR()
	{
		double mhr;
		final int MHR_FACTOR = 220;

		// MAX HEART RATE (MHR) formula
		mhr = MHR_FACTOR - age;
		return mhr;
	}

	/**
	 * Determines BMI category based on BMI ranges
	 * 
	 * Category Scale: Obese: > 40 Overweight: 39.999 to 25 Normal: 24.999 to 18.5
	 * Underweight: < 18.499
	 * 
	 * @return the category name
	 */
	public String bmiCategory()
	{
		double bmi = calculateBMI();
		String category;
		// categories for BMI ranges
		if (bmi >= 40)
		{
			category = "Obese";
		} else if (bmi >= 25)
		{
			category = "Overweight";
		} else if (bmi >= 18.5)
		{
			category = "Normal";
		} else
		{
			category = "Underweight";
		} // end else

		return category;
	}

	/**
	 * Displays the name, bmi, bmiCategory, and MHR of the athlete
	 */
	public void displayAthleteAnalysis()
	{
		System.out.println("Name: " + name + "\n" + "BMI: " + calculateBMI() + "\n" + "Category: " + bmiCategory()
				+ "\n" + "MHR: " + calculateMHR() + "\n");
	}
}

class Team
{
	private String name;
	private Athlete[] athletes;
	private int athleteCount;
	private int numberOfAthletes = 0;

	public Team(String name, int athleteCount)
	{
		this.name = name;
		this.athleteCount = athleteCount;
		athletes = new Athlete[athleteCount];
	}

	/**
	 * gets the team name
	 * 
	 * @return the name of the team that was given in the constructor
	 */
	public String getTeamName()
	{
		return name;
	}

	/**
	 * @return the number of athletes on the team
	 */
	public int getAthleteCount()
	{
		return athleteCount;
	}

	/**
	 * adds athletes and increments through the array to prevent overlap.
	 * 
	 * @param takes an athlete to add to the athlete list/array
	 */
	public void addAthlete(Athlete athlete)
	{
		if (numberOfAthletes < athleteCount)
		{
			this.athletes[numberOfAthletes] = athlete;
			++numberOfAthletes;
		} else
		{
			System.out.print("Team is full.");
		}
	}

	/**
	 * Displays each athlete's stats: Name, BMI, Category, MHR
	 */
	public void displayAthleteResults()
	{
		for (int count = 0; count < athletes.length; ++count)
		{
			athletes[count].displayAthleteAnalysis();
		}
	}

	/**
	 * Displays the names of the athletes who are not within normal bmi range.
	 */
	public void displayAthletesOutsideNormalBMI()
	{
		System.out.println("Athletes Outside Normal BMI Range:");
		int normalBMI = 0;

		for (int count = 0; count < athletes.length; ++count)
		{
			double bmi = athletes[count].calculateBMI();
			// different messages depending on if the athlete is above or below normal BMI
			if (bmi >= 25)
			{
				System.out.println("Above Normal: " + athletes[count].getName());
			} else if (bmi < 18.5)
			{
				System.out.println("Below Normal: " + athletes[count].getName());
			} else
			{
				++normalBMI;
			}
		}
		// if all of them are within normal this is run
		if (normalBMI == athletes.length)
		{
			System.out.println("No athletes outside of normal range");
		}
	}

	/**
	 * Calculates average MHR from all the athletes
	 * 
	 * @return average max heart rate so displayAthletesAboveAverageMHR can use it
	 *         for reference
	 */
	public double calculateAverageMHR()
	{
		double averageMHR = 0;

		for (int count = 0; count < athletes.length; ++count)
		{
			// sums all the athlete's mhrs
			averageMHR = averageMHR + athletes[count].calculateMHR();
		}
		averageMHR = averageMHR / athletes.length;

		return averageMHR;
	}

	/**
	 * displays the names of everyone that has a max heart rate higher or equal to
	 * average max heart rate
	 * 
	 * @param average is taken from calculateAverageMHR
	 */
	public void displayAthletesAboveAverageMHR(double average)
	{
		System.out.print("Athletes above or equal to average MHR: \n");
		for (int count = 0; count < athletes.length; ++count)
		{
			// prints and athletes name if they are above or equal to averageMHR
			if (athletes[count].calculateMHR() >= average)
			{
				System.out.println(athletes[count].getName());
			}
		}
	}

	/**
	 * @return
	 */
	public Athlete calculateHighestMHRIndex()
	{
		double highestMHR = 0;
		int index = 0;
		// finds the index of the person with the highest MHR
		for (int count = 0; count < athletes.length; ++count)
		{
			if (highestMHR < athletes[count].calculateMHR())
			{
				highestMHR = athletes[count].calculateMHR();
				index = count;
			}
		}
		return athletes[index];
	}

	/**
	 * Determines the person with the highest mhr by sifting through the entire
	 * array of mhrs
	 */
	public void displayHighestMHR()
	{
		Athlete athlete = calculateHighestMHRIndex();
		// prints the name and MHR of the person with the highestMHR
		System.out.println("\nHighest Max Heart Rate: \n" + athlete.getName() + ": " + athlete.calculateMHR() + "\n");
	}

	/**
	 * determines the athlete with the smallest height
	 * 
	 * @return the shortest athlete's data
	 */
	public Athlete calculateShortestAthlete()
	{
		int index = 0;
		// finds the index of the person with the highest MHR
		for (int count = 0; count < athletes.length - 1; ++count)
		{
			double height = athletes[0].getHeight();
			if (height >= athletes[count + 1].getHeight())
			{
				height = athletes[count + 1].getHeight();
				index = count + 1;
			}
		}
		return athletes[index];
	}

	/**
	 * determines the athlete with the largest height
	 * 
	 * @return the tallest athlete's data
	 */
	public Athlete calculateTallestAthlete()
	{
		double height = 0;
		int index = 0;
		// finds the index of the person with the highest MHR
		for (int count = 0; count < athletes.length; ++count)
		{
			if (height < athletes[count].getHeight())
			{
				height = athletes[count].getHeight();
				index = count;
			}
		}
		return athletes[index];
	}

	/**
	 * Displays both the name and height of the shortest and tallest athletes
	 */
	public void displaySmallestLargestHeight()
	{
		Athlete shortest = calculateShortestAthlete();
		Athlete tallest = calculateTallestAthlete();
		System.out.println("Shortest Athlete: \n" + shortest.getName() + " - " + shortest.getHeight());
		System.out.println("Tallest Athlete: \n" + tallest.getName() + " - " + tallest.getHeight() + "\n");
	}

	/**
	 * Writes all the athlete data like Name, BMI, Category, and MHR for all
	 * athletes on the team to a separate txt file stored on their computer. It also
	 * tells the user which path to find the file at.
	 * 
	 * @param fileName so you can create a file on the users computer
	 * @throws FileNotFoundException in case an error occurs, it will allow to user
	 *                               to know
	 */
	public void writeAthletesToFile(String fileName) throws FileNotFoundException
	{
		{
			File fileReference = new File(fileName);

			PrintWriter write = new PrintWriter(fileReference);

			System.out.println("Printing to: " + fileName);
			for (int count = 0; count < athletes.length; ++count)
			{
				write.println("Name: " + name + "\n" + "BMI: " + athletes[count].calculateBMI() + "\n" + "Category: "
						+ athletes[count].bmiCategory() + "\n" + "MHR: " + athletes[count].calculateMHR() + "\n");
			}

			write.close();

			System.out.print("Results written to file: " + fileReference.getAbsolutePath() + "\n");
		}
	}
}