
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

		// declared a boolean to fit in the scope of ALL LOOPS
		boolean loggedIn;

		// do this WHILE the while statement is met
		do
		{
			// the number of attempts begins at 0, there are no more than 3 attempts allowed
			for (int attempts = 0; attempts <= 3; ++attempts)
			{
				// initialized inputedUsername
				System.out.print("Input username: ");
				inputedUsername = keyboardInput.next();

				// initialized inputedPassword
				System.out.print("Input password: ");
				inputedPassword = keyboardInput.next();

				// assumes the log in is true no matter the previous attempts.
				// so if they get it right, this variable will allow the stack to move past the
				// while loop
				loggedIn = true;

				// if user name is correct
				if (USERNAME_ACTUAL.equals(inputedUsername))
				{
					// if both user name and password are correct
					if (PASSWORD_ACTUAL.equals(inputedPassword))
					{
						// LOGGEDIN IS NOT ASSIGNED HERE, therefore, only this outcome allows the user
						// to pass the while loop
						System.out.print("Login successful!");
					}
					// if ONLY the USER NAME is correct
					else
					{
						System.out.println("Incorrect password");
						// if the password is incorrect, logged in is false
						loggedIn = false;
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
						System.out.println("Both username and password are incorrect. Login failed.");
					}
					// if the user name is incorrect, boolean logged in will be false
					loggedIn = false;
				}
			}
		} // end of do
			// as long as this is false, it will do
		while (loggedIn == false);

		System.out.print("3 Attempts.");

		keyboardInput.close();
	}// end of main

}// end of class
