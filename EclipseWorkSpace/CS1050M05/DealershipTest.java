
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
	}
}
