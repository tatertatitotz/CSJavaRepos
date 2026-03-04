
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
		boolean loggedIn = false;
		System.out.println("You have 3 attempts.");
		// do this WHILE the while statement is met
		do
		{
			// the number of attempts begins at 0, there are no more than 3 attempts allowed
			for (int attempts = 0; attempts < 3; ++attempts)
			{
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
						// LOGGEDIN IS NOT ASSIGNED HERE, therefore, only this outcome allows the user
						// to pass the while loop
						System.out.print("Login successful!");
						// loggedIn
						loggedIn = true;
						// boots you out of the for loop
						attempts = 10;
					}
					// if ONLY the USER NAME is correct
					else
					{
						System.out.println("Incorrect password");
						// if the password is incorrect, logged in is false
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
						System.out.println("Login failed. Both username and password are incorrect.");
					}
				}
				// if the user is attempting, the number of attempts left will display.
				if (attempts < 2)
				{
					// displays the number of attempts remaining
					System.out.println("You have " + (2 - attempts) + " attempts left.");
				} else
				{
					// displays number of attempts
					System.out.println("You have 0 attempts left.");
					// allows an exit out of the while loop when the max attempts have been used
					loggedIn = true;
				}

			} // end of for
		} // end of do
			// as long as logged in is true, it will do what do does
		while (loggedIn == false);

		keyboardInput.close();
	}// end of main

}// end of class
