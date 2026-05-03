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
 * Displays athletes above or equal to max heart rate
 * Displays person with highest MHR
 * Calculates average max heart rate
 * Displays and Calculates training heart rate
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
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Nuggets", 6);

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
		System.out.println("\n========== Team Analysis ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getAthleteCount());
		System.out.println();

		team.displayAthleteResults();
		team.displayAthletesOutsideNormalBMI();

		double avg = team.calculateAverageMHR();
		System.out.println("\nAverage Max Heart Rate: " + avg);

		team.displayAthletesAboveAverageMHR(avg);
		team.displayHighestMHR();
		team.displaySmallestLargestHeight();
		String outputFileName = team.getTeamName() + ".txt";
		team.writeAthletesToFile(outputFileName);

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
	 * Determines BMI category based on BMI ranges
	 * 
	 * Category Scale: Obese: > 40 Overweight: 39.999 to 25 Normal: 24.999 to 18.5
	 * Underweight: < 18.499
	 * 
	 * @return the category name
	 */
	public String determineBMICategory()
	{
		double bmi = calculateBMI();
		String category = "";
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
	 * Uses the formula for MHR to calculate MHR
	 * 
	 * @param ageMHR is age of athletes
	 * @return max heart rate
	 */
	public double calculateMHR()
	{
		final int MHR_FACTOR = 220;
		double mhr;

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
	public String bmiCategory(double bmi)
	{
		// categories for BMI ranges
		String category;
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

	public void displayAthleteAnalysis()
	{
		System.out.println("Name: " + name + "\n" + "BMI: " + calculateBMI() + "\n" + "Category: "
				+ bmiCategory(calculateBMI()) + "\n" + "MHR: " + calculateMHR());
	}
}

class Team
{
	private String name;
	private Athlete[] athletes;
	private int athleteCount;
	private static int numberOfAthletes = 0;

	public Team(String name, int athleteCount)
	{
		this.name = name;
		this.athleteCount = athleteCount;
		athletes = new Athlete[athleteCount];
	}

	public String getTeamName()
	{
		return name;
	}

	public int getAthleteCount()
	{
		return athleteCount;
	}

	public void addAthlete(Athlete athlete)
	{
		this.athletes[numberOfAthletes] = athlete;
		++numberOfAthletes;
	}

	public void displayAthleteResults()
	{
		for (int count = 0; count < athletes.length; ++count)
		{
			athletes[count].displayAthleteAnalysis();
		}
	}

	public void displayAthletesOutsideNormalBMI()
	{
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
		System.out.print("\n");
	}

	/**
	 * Calculates average MHR from all the athletes
	 * 
	 * @return
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

		System.out.println("Team Average Max Heart Rates: " + averageMHR + "\n");

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

	public int calculateHighestMHRIndex()
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
		return index;
	}

	/**
	 * Determines the person with the highest mhr by sifting through the entire
	 * array of mhrs
	 */
	public void displayHighestMHR()
	{
		int index = calculateHighestMHRIndex();
		// prints the name and MHR of the person with the highestMHR
		System.out.println(
				athletes[index].getName() + " has highest max heart rate: " + athletes[index].calculateMHR() + "\n");
	}

	public int calculateSmallestHeightIndex()
	{
	}

	public int calculateLargestHeightIndex()
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
		return index;
	}

	public void displaySmallestLargestHeight()
	{
	public void writeAthletesToFile(String fileName)
	{
		File fileReference = new File(fileName);
		}

	}
}