package eliza;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

/**
 * Main class, this class calls ELIZA and user input to receive and analyze the
 * user input, this class then prints it in the console.
 * 
 * @author Oziel
 *
 */
public class ProgramController
{
	/**
	 * Main method, this method calls the UserInputer and ELIZA classes, it also
	 * delays the program process to make it appear that ELIZA is actually
	 * typing, it then prints ELIZA's response
	 * 
	 * @param args
	 *            not used
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws FileNotFoundException, InterruptedException
	{
		// do while method goes here
		ELIZA.keyWordsArray();
		ELIZA.responsesArray();
		String response;
		boolean continueProgram = true;
		System.out.println("Hello, my name is Eliza, how may I help you?");
		do
		{

			response = ELIZA.keywordVerifier(UserInputer.userInput());
			System.out.println("Typing...");
			TimeUnit.SECONDS.sleep(2);
			outputResponse(response);
			if (response.equals("Goodbye."))
			{
				continueProgram = false;
			}
		} while (continueProgram);
	}

	/**
	 * This method displays ELIZA's response in the console.
	 * 
	 * @param response
	 *            String of ELIZA]s response
	 */
	public static void outputResponse(String response)
	{

		// print response
		System.out.println(response);
	}

}
