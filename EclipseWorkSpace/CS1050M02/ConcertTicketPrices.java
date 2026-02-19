
//create object Scanner
import java.util.Scanner;

public class ConcertTicketPrices
{

	public static void main(String[] args)
	{
		// Scanner
		Scanner keyboardInput = new Scanner(System.in);

		// declare variables
		char section;
		int row;
		double price;

		// initialize variables with scanner
		System.out.print("Choose your section by typing: " + "\n F: Front Section \n C: Center Section "
				+ "\n S: Side Section \n U: Upper Section" + "\n BEGIN HERE: ");
		/*
		 * initialize section. charAt(0) forces section to become a char even if a
		 * String is inputed. Character.toUpperCase forces section to be stored as the
		 * upper case version of the char.
		 */
		section = Character.toUpperCase(keyboardInput.next().charAt(0));

		if (section != 'F' || section != 'C' || section != 'S' || section != 'U')
			;
		{
			System.out.print("Invalid section,  program ending");
			return;
		}

		// initialize row

		// prices

		// ConcertTicketPrices console displays

	}

}
