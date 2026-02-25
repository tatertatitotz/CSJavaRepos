
//added scanner for user input
import java.util.Scanner;

public class nestedIfUserLoginLab
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

		// if user name is correct
		if (USERNAME_ACTUAL.equals(inputedUsername))
		{
			// if both user name and password are correct
			if (PASSWORD_ACTUAL.equals(inputedPassword))
			{
				System.out.print("Login successful!");
			}
			// if ONLY the USER NAME is correct
			else
			{
				System.out.println("Incorrect password");
			}
		}
		// if user name is incorrect
		else
		{
			// if ONLY the password is correct
			if (PASSWORD_ACTUAL.equals(inputedPassword))
			{
				System.out.println("Incorrect username");

			}
			// if BOTH are incorrect
			else
			{
				System.out.print("Both username and password are incorrect. Login failed.");
			}
		}

		keyboardInput.close();
	}

}
