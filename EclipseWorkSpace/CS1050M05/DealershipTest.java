
public class DealershipTest
{

	public static void main(String[] args)
	{
		Car car1 = new Car("Ford", "Mustang", 32800);
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
}// end Car
