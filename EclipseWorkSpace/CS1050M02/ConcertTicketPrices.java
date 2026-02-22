
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
		String sectionName;

		// initialize variables with scanner
		System.out.print("Choose your section by typing: " + "\n F: Front Section \n C: Center Section "
				+ "\n S: Side Section \n U: Upper Section" + "\n BEGIN HERE: ");
		/*
		 * initialize section. charAt(0) forces section to become a char even if a
		 * String is inputed. Character.toUpperCase forces section to be stored as the
		 * upper case version of the char.
		 */
		section = Character.toUpperCase(keyboardInput.next().charAt(0));

		switch (section)
		{
		case 'F':
		{
			sectionName = "Front Section";
			break;
		}
		case 'C':
		{
			sectionName = "Center Section";
			break;
		}
		case 'S':
		{
			sectionName = "Side Section";
			break;
		}
		case 'U':
		{
			sectionName = "Upper Section";
			break;
		}
		default:
		{
			System.out.print("Invalid section,  program ending");
			return;
		}

		}// end switch

		System.out.print("Input a row number between 1-60: ");
		// initialize row
		row = keyboardInput.nextInt();

		if (row <= 60 && row >= 31)
		{
			price = 200;

		} else if (row >= 30 && row >= 16)
		{
			price = 300;

		} else if (row >= 15 && row >= 1)
		{
			price = 450;
		}

		else
		{
			System.out.print("Invalid row, program ending");
			return;
		}

		// prices

		// ConcertTicketPrices console displays
		System.out.print("Selected " + sectionName);

	}

}
