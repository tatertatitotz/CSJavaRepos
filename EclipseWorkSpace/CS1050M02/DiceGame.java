
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

		// if the sum of both dice is equal to 7 OR 11 you win
		if (total == 7 || total == 11)
		{
			System.out.print("You win!");
		}
		// if both dice equal 6 it is a Jack pot
		// this is put before the doubles because it reads it first in the stack
		else if (dice1 == 6 && dice2 == 6)
		{
			System.out.print("Jackpot!");
		}
		// if both dice are equal
		else if (dice1 == dice2)
		{
			System.out.print("Doubles, you win!");
		}
		// any other values loses
		else
		{
			System.out.print("You lose :(");
		}

	}

}
