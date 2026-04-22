
/*
 * Name: Tat Chock
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DealershipTest
{

	public static void main(String[] args)
	{
		Car car1 = new Car("Ford", "Mustang", 32800);
		System.out.println(car1.getModel());
		car1.displayCarDetails();

		Dealership placeForCars = new Dealership("Name of Dealership", 2);
		System.out.println(placeForCars.getDealershipName());

		placeForCars.addCar(car1);

		Car car2 = new Car("Nissan", "Altima", 14500);
		placeForCars.addCar(car2);

		System.out.print("\n");

		System.out.print("The Most Expensive car is: ");
		placeForCars.findMostExpensiveCar().displayCarDetails();

		System.out.print("\n");

		System.out.println("Cars in the dealership are: ");
		placeForCars.displayCars();

		try
		{
			placeForCars.writeCarsToFile("Name_Of_Dealership.txt");

		} catch (FileNotFoundException exception)
		{
			System.out.print("Unable to find file: " + "Name_Of_Dealership.txt");
		}

	}// end main

}// end Dealership Test

class Car
{
	private String model;
	private String make;
	private double price;

	public Car(String model, String make, double price)
	{
		this.model = model;
		this.make = make;
		this.price = price;
	}

	public String getModel()
	{
		return model;
	}

	public String getMake()
	{
		return make;
	}

	public double getPrice()
	{
		return price;
	}

	public void displayCarDetails()
	{
		System.out.println(model + " " + make + " $" + price);
	}
}// end Car

class Dealership
{
	private String name;
	private Car[] cars;
	private static int currentCars = 0;

	public Dealership(String name, int maxNumberOfCars)
	{
		this.name = name;
		cars = new Car[maxNumberOfCars];
	}

	public String getDealershipName()
	{
		return name;
	}

	public void addCar(Car newCar)
	{
		cars[currentCars] = newCar;
		currentCars++;
	}

	public Car findMostExpensiveCar()
	{
		double expensiveCar = 0;
		int carIndex = 0;
		for (int count = 0; count < cars.length; ++count)
		{
			if (expensiveCar <= cars[count].getPrice())
			{
				expensiveCar = cars[count].getPrice();
				carIndex = count;
			}
		}

		return cars[carIndex];
	}

	public void displayCars()
	{
		for (int count = 0; count < cars.length; ++count)
		{
			cars[count].displayCarDetails();
		}
	}

	public void writeCarsToFile(String fileName) throws FileNotFoundException
	{
		{

			File fileReference = new File(fileName);

			System.out.println(fileReference.getAbsolutePath());

			PrintWriter write = new PrintWriter(fileReference);

			System.out.println("Printing to: " + fileName);
			for (int count = 0; count < cars.length; ++count)
			{
				write.println(cars[count].getModel() + " " + cars[count].getMake() + " $" + cars[count].getPrice());
			}

			readCarsToFile(fileReference);
		}
	}

	public void readCarsToFile(File fileRefRead) throws FileNotFoundException
	{
		Scanner fileScanner = new Scanner(fileRefRead);

		while (fileScanner.hasNext())
		{
			System.out.print(fileScanner.nextLine());
		}
	}
}
