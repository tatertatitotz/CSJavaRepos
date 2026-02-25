
public class DiceGame
{

	public static void main(String[] args)
	{
		// declared dice1 and dice2
		int dice1;
		int dice2;

		// initialized dice1 and dice 2 as Math.random which has a range of 1 <= x < 7
		dice1 = (int) (Math.random() * 6 + 1);
		dice2 = (int) (Math.random() * 6 + 1);

		int total = (dice1 + dice2);
		System.out.println("You rolled: " + dice1 + " and " + dice2);

		if (total == 7 || total == 11)
		{
			System.out.print("You win!");
		} else if (dice1 == 6 && dice2 == 6)
	}

}
