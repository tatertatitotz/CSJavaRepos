
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

		// if BOTH user name and password are correct then the login is successful
		if (USERNAME_ACTUAL.equals(inputedUsername) && PASSWORD_ACTUAL.equals(inputedPassword))
		{
			System.out.print("Login successful!");
		}
		// if ONLY the PASSWORD is correct
		else if (PASSWORD_ACTUAL.equals(inputedPassword))
		{
			System.out.println("Incorrect username");
		}
		// if ONLY the USER NAME is correct
		else if (USERNAME_ACTUAL.equals(inputedUsername))
		{
			System.out.println("Incorrect password");
		}
		// if both are false
		else
		{
			System.out.print("Both username and password are incorrect. Login failed.");
		}

	}

}
