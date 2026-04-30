
public class BubbleSort
{

	public static void main(String[] args)
	{
		int[] array =
		{ 2, 4, 8, 6, 7, 1, 3, 5 };

		for (int repeat = 0; repeat < array.length; ++repeat)
		{
			for (int count = 0; count < array.length; ++count)
			{
				int nextIndex = count + 1;
				if (nextIndex < array.length)
				{
					if (array[count] > array[nextIndex])
					{
						int temp = array[count];
						array[count] = array[nextIndex];
						array[nextIndex] = temp;
					}
				}
				System.out.print(array[count]);
			}
		}
	}
}
