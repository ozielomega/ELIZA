package eliza;

import java.util.Scanner;

/**
 * This class is used to receive the user input and return it to the Program
 * Controller to analyze and output ELIZA's response.
 * 
 * @author Oziel
 *
 */
public class UserInputer
{

	/**
	 * Constructor, not used.
	 */
	private UserInputer()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method receives the User input as a String and returns it ass an
	 * array of Strings to be analyzed.
	 * 
	 * @return
	 */
	public static String[] userInput()
	{
		String userInput;
		Scanner in = new Scanner(System.in);
		System.out.print(" - ");
		userInput = in.nextLine();
		userInput = userInput.toLowerCase();
		String[] inputPhrase = toArray(userInput);
		return inputPhrase;
	}

	/**
	 * Private method that converts the user input String to an Array of Strings
	 * without any punctuation.
	 * 
	 * @param input
	 *            user input as a String
	 * @return user input as an Array of strings without punctuation
	 */
	private static String[] toArray(String input)
	{
		String[] userInputArray = input.replaceAll("\\p{P}", "").split(" ");
		return userInputArray;
	}

}
