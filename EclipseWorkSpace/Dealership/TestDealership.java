import java.io.File;
import java.io.FileNotFoundException;

public class TestDealership
{
	public static void main(String[] args)
	{
		displayProgramSummary();
		String fileName = "cars1.txt";

		// try this
		try
		{
			System.out.println("\nTesting file: " + fileName);
			// creates a dealership
			Dealership dealership = new Dealership("CS Dealership", 6);

			// File name
			dealershipSetUp(fileName, dealership);
			dealership.displayCars();

			System.out.println("\nMost Expensive Car:");
			dealership.displayMostExpensiveCar();
			String outputFileName = dealership.getDealershipName() + ".txt";
			dealership.writeCarsToFile(outputFileName);
		}
		// when something goes wrong this happens
		catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}
		System.out.println("\nEnd of program");
	}

	// if something goes wrong in here it throws the following exception

	/**
	 * Reads from an external file to import the data to the online dealership
	 * 
	 * @param fileName      car1.txt
	 * @param newDealership dealership for car storage
	 * @throws FileNotFoundException
	 */
	public static void dealershipSetUp(String fileName, Dealership newDealership) throws FileNotFoundException
	{
		File inputFile = new File(fileName);
		Scanner fileScanner = new Scanner(inputFile);
		while (fileScanner.hasNext())
		{
			String make = fileScanner.next();
			String model = fileScanner.next();
			double price = fileScanner.nextDouble();
			Car car = new Car(make, model, price);
			newDealership.addCar(car);
		}
		fileScanner.close();
	}

	public static void displayProgramSummary()
	{
		System.out.println("**************************************");
		System.out.println("Dealership and Car Analysis");
		System.out.println("**************************************");
		System.out.println("Reads car data from a file");
		System.out.println("Displays all cars");
		System.out.println("Finds most expensive car");
		System.out.println();
	}
}
