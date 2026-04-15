
public class TestSimpleCircle
{
	/** Main method */
	public static void main(String[] args)
	{
		// Create a circle with radius 1
		SimpleCircle circle1 = new SimpleCircle();
		System.out.println("The area of the circle of radius " + circle1.getRadius() + " is " + circle1.getArea());

		// Create a circle with radius 25
		SimpleCircle circle2 = new SimpleCircle(25);
		System.out.println("The area of the circle of radius " + circle2.getRadius() + " is " + circle2.getArea());

		// Create a circle with radius 125
		SimpleCircle circle3 = new SimpleCircle(125);
		System.out.println("The area of the circle of radius " + circle3.getRadius() + " is " + circle3.getArea());

		// Modify circle radius
		circle2.setRadius(100); // or circle2.setRadius(100)
		System.out.println("The area of the circle of radius " + circle2.getRadius() + " is " + circle2.getArea());

		// Create a circle with width/length 1
		Rectangle rectangle1 = new Rectangle();
		System.out.println("The area of the rectangle with a width of " + rectangle1.getWidth() + " and a length of "
				+ rectangle1.getLength() + " is " + rectangle1.getArea());

		// Create a rectangle with a width of 25 and a length of 30
		Rectangle rectangle2 = new Rectangle(25, 30);
		System.out.println("The area of the rectangle with a width of " + rectangle2.getWidth() + " and a length of "
				+ rectangle2.getLength() + " is " + rectangle2.getArea());

		// Create a rectangle with a width of 125 and a length of 250
		Rectangle rectangle3 = new Rectangle(125, 250);
		System.out.println("The area of the rectangle with a width of " + rectangle3.getWidth() + " and a length of "
				+ rectangle3.getLength() + " is " + rectangle3.getArea());

		// Modify rectangle width
		rectangle2.setWidth(100); // or circle2.setRadius(100)
		System.out.println("The area of the rectangle with a width of " + rectangle3.getWidth() + " and a length of "
				+ rectangle3.getLength() + " is " + rectangle3.getArea());

		Rectangle[] rectangles = new Rectangle[3];

		rectangles[0] = rectangle1;
		rectangles[1] = rectangle2;
		rectangles[2] = rectangle3;

		rectangles[2].setLength(400);

		Rectangle.printArrayRectangleInformation(rectangles);

		int indexLongestLength = Rectangle.findLongestLength(rectangles);

		System.out.print("The rectangle with the longest length is rectangle #" + (indexLongestLength + 1)
				+ " with a length of: " + rectangles[indexLongestLength].getLength());

		System.out.print("The sum of all the rectangles areas is: " + Rectangle.sumOfAreas(rectangles));
	}
}

// Define the circle class with two constructors
class SimpleCircle
{
	private double radius;

	/** Construct a circle with radius 1 */
	SimpleCircle()
	{
		radius = 1;
	}

	/** Construct a circle with a specified radius */
	SimpleCircle(double newRadius)
	{
		radius = newRadius;
	}

	/** Return the area of this circle */
	double getArea()
	{
		return radius * radius * Math.PI;
	}

	/** Return the perimeter of this circle */
	double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}

	/** Set a new radius for this circle */
	void setRadius(double newRadius)
	{
		radius = newRadius;
	}// end setRadius Method

	// returns object radius
	double getRadius()
	{
		return radius;
	}// end of getRadius
}// end class

class Rectangle
{
	private double width;
	private double length;

	/** Construct a rectangle with a width and length of 1 */
	Rectangle()
	{
		width = 1;
		length = 1;
	}

	/** Construct a rectangle with a specified width and length */
	Rectangle(double newWidth, double newLength)
	{
		width = newWidth;
		length = newLength;
	}

	/** Return the area of this rectangle */
	double getArea()
	{
		return width * length;
	}

	/** Return the perimeter of this rectangle */
	double getPerimeter()
	{
		return 2 * (width + length);
	}

	/** Set a new radius for this rectangle */
	void setWidth(double width)
	{
		this.width = width;
	}// end setWidth Method

	void setLength(double length)
	{
		this.length = length;
	}// end setLength Method

// returns object width
	double getWidth()
	{
		return width;

	}

	double getLength()
	{
		return length;

	}

	static void printArrayRectangleInformation(Rectangle[] rectangleList)
	{
		for (int count = 0; count < rectangleList.length; ++count)
		{
			System.out.println("\nRectangle #" + (count + 1) + " has a length of " + rectangleList[count].getLength()
					+ " and a width of " + rectangleList[count].getWidth() + ". \nIt's area is "
					+ rectangleList[count].getArea() + " and it's perimeter is " + rectangleList[count].getPerimeter()
					+ ".");
		}
	}

	static int findLongestLength(Rectangle[] rectangleList)
	{
		double longest = 0;
		int indexLength = 0;

		for (int count = 0; count < rectangleList.length; ++count)
		{
			if (longest < rectangleList[count].getLength())
			{
				longest = rectangleList[count].getLength();
				indexLength = count;
			}
		}
		return indexLength;
	}

	static double sumOfAreas(Rectangle[] rectangleList)
	{
		double areas = 0;

		for (int count = 0; count < rectangleList.length; ++count)
		{
			areas = areas + rectangleList[count].getArea();
		}
		return areas;
	}
}