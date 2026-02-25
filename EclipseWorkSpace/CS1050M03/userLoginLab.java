
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
	}

}
