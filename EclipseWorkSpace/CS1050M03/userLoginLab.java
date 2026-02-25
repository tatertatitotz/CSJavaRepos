
//added scanner for user input
import java.util.Scanner;

public class userLoginLab
{

	public static void main(String[] args)
	{
		// created scanner keyboardInput
		Scanner keyboardInput = new Scanner(System.in);

		// constants for testing
		final String USERNAME_ACTUAL = "username123";
		final String PASSWORD_ACTUAL = "password123";

		// declared space for inputs
		String inputedUsername;
		String inputedPassword;

		// initialized inputedUsername
		System.out.print("Input username: ");
		inputedUsername = keyboardInput.next();

		// initialized inputedPassword
		System.out.print("Input password: ");
		inputedPassword = keyboardInput.next();

		// if both user name and password are correct then the login is successful
		if (USERNAME_ACTUAL.equals(inputedUsername) && PASSWORD_ACTUAL.equals(inputedPassword))
		{
			System.out.print("Login successful!");
		} else
		{
			System.out.print("failed");
		}

	}

}
