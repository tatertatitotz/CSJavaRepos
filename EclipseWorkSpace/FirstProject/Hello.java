
public class Hello
{

	public static void main(String[] args)
	{

		int haveThisInteger = 4;

		System.out.print("Testing to see if github works!");

		if (haveThisInteger > 3)
		{
			if (haveThisInteger == 4)
			{
				System.out.print("Integer = 4");
			}

		} // end if

		int number = 5;

		switch (number)
		{

		case 1:
		{
			System.out.print("This sure is a 1");
			break;
		}
		case 2:
		{
			System.out.print("2 for you");
			break;
		}
		case 3:
		{
			System.out.print("3 for me");
			break;
		}
		case 4:
		{
			System.out.print("4 for more");
			break;
		}
		case 5:
		{
			System.out.print("5!");
			break;
		}
		default:
		{
			System.out.print("What is this <:'O");
			break;
		}

		}// end switch

		int prefix = 5;

		System.out.println(prefix);
		System.out.println(--prefix);

		int postfix = 3;
		System.out.println(postfix--);
		System.out.println(postfix);

		System.out.print(prefix);

	}// end main

}// end class
