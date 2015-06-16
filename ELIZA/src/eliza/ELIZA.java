package eliza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * ELIZA, this class simulates a therapist.
 * 
 * @author Oziel
 *
 */
public class ELIZA
{

	private static ArrayList<String> keyWords = new ArrayList<String>();
	private static ArrayList<String> responses = new ArrayList<String>();
	private static File keywordsFile = new File("keywords.txt");
	private static File responsesFile = new File("responses.txt");

	/**
	 * Constructor, not used.
	 */
	private ELIZA()
	{
	}

	/**
	 * This static method finds the key words that relate to ELIZA's response
	 * and finds the index of the keyword that is on the keywords.txt file, it
	 * then calls the response method to find ELIZA's response.
	 * 
	 * @param userInputWordArray
	 *            array of Strings of the user input
	 * @return ELIZA's response
	 * @throws FileNotFoundException
	 */
	public static String keywordVerifier(String[] userInputWordArray) throws FileNotFoundException
	{
		for (int i = 0; i < userInputWordArray.length; i++)
		{
			if (userInputWordArray[i].equals("my"))
			{
				return response(keyWords.indexOf("my"), userInputWordArray, i);
			}
			else if(userInputWordArray[i].equals("im"))
			{
				return response(keyWords.indexOf("i am"), userInputWordArray, i);
			}
			else if ((userInputWordArray[i].equals("i") && i - 1 < userInputWordArray.length)||(userInputWordArray[i].equals("im")))
			{
				switch (userInputWordArray[i + 1])
				{
				case "think":
					return response(keyWords.indexOf("i think"), userInputWordArray, i);
				case "am":
					return response(keyWords.indexOf("i am"), userInputWordArray, i);
				}
				
			}
			for (int j = 0; j < keyWords.size(); j++)
			{
				if (userInputWordArray[i].equals(keyWords.get(j)))
				{
					return response(j);
				}
			}
		}
		return response(0);

	}

	/**
	 * This method gets the response of ELIZA taking in account the special
	 * cases.
	 * 
	 * @param userInputWordArray
	 *            a String array of the phrase the user typed to ELIZA
	 * @param indexOfSpecialKeyword
	 *            index of the special case keyword
	 * @param responseIndex
	 *            index of response of ELIZA in responses.txt
	 * @return response of ELIZA as a String
	 */
	private static String response(int responseIndex, String[] userInputWordArray,
			int indexOfSpecialKeyword)
	{
		String response = responses.get(responseIndex);
		if (responseIndex == keyWords.indexOf("i'm"))
		{
			for (int i = indexOfSpecialKeyword + 1; i < userInputWordArray.length; i++)
			{
				response = response.concat(userInputWordArray[i]);
			}

		}
		else if (responseIndex == keyWords.indexOf("i am"))
		{
			for (int i = indexOfSpecialKeyword + 2; i < userInputWordArray.length; i++)
			{
				response = response.concat(userInputWordArray[i]).concat(" ");
			}
		}
		else if (responseIndex == keyWords.indexOf("my"))
		{
			for (int i = indexOfSpecialKeyword + 1; i < userInputWordArray.length; i++)
			{
				response = response.concat(" ").concat(userInputWordArray[i])
						.replaceAll("me", "you");
			}
		}
		return response.concat(".");
	}

	/**
	 * This method gets the response of ELIZA.
	 * 
	 * @param responseIndex
	 *            index of response of ELIZA in responses.txt
	 * @return response of ELIZA as a String
	 */
	private static String response(int responseIndex)
	{
		if (responseIndex == 0)
		{
			Random rand = new Random();
			int randomResponse = rand.nextInt(5);
			switch (randomResponse)
			{
			case 0:
				return "What does that suggest to you?";
			case 1:
				return "I see.";
			case 2:
				return "I'm not sure I understand you fully";
			case 3:
				return "can you elaborate?";
			default:
				return responses.get(responseIndex);
			}
		}
		String response = responses.get(responseIndex);
		return response;
	}

	/**
	 * This method initializes the ArrayList keyWords adding the keywords as
	 * string from the file keywords.txt
	 * 
	 * @throws FileNotFoundException
	 */
	public static void keyWordsArray() throws FileNotFoundException
	{
		Scanner keyWordsScanner = new Scanner(keywordsFile);
		while (keyWordsScanner.hasNextLine())
		{
			keyWords.add(keyWordsScanner.nextLine());
		}
	}

	/**
	 * This method initializes the ArrayList responses adding the responses as
	 * string from the file responses.txt
	 * 
	 * @throws FileNotFoundException
	 */
	public static void responsesArray() throws FileNotFoundException
	{
		Scanner responsesScanner = new Scanner(responsesFile);
		while (responsesScanner.hasNextLine())
		{
			responses.add(responsesScanner.nextLine());
		}
	}
}
