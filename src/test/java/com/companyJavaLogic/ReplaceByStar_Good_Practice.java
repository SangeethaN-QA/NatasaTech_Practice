package com.companyJavaLogic;

public class ReplaceByStar_Good_Practice {
		  
	
	// Function takes two parameter
	static String censor(String text,
						String word)
	{

		// Break down sentence by ' ' spaces
		// and store each individual word in
		// a different list
		String[] word_list = text.split("\\s+");
		// A new string to store the result
		String result = "";
		// Creating the censor which is an asterisks
		// "*" text of the length of censor word
		String stars = "";
		for (int i = 0; i < word.length(); i++)
		{
			stars += '*';
		}
		// Iterating through our list
		// of extracted words
		int index = 0;
		for (String i : word_list)
		{
			if (i.compareTo(word) == 0)
			{

				// changing the word to created asterisks
				word_list[index] = stars;
				System.out.println("^^^^^^^^^^^  " +word_list[index]);
			}
			index++;
		}

		// join the words
		for (String i : word_list)
		{
			//result += i + ' ';
			result = result + i;
			//System.out.println("--------------" +result);
		}

		return result;
	}

	// Driver code
	public static void main(String[] args)
	{
//		String extract = "GeeksforGeeks is a computer science "+
//						"portal for geeks. I am pursuing my " +
//						"major in computer science. ";
//		String cen = "major";
		
		String sentence = "This is a sample only the sky is blue water is transparent ";
		String pattern = "only";
		System.out.println(censor(sentence, pattern));
	}
	


	// This code is contributed by
	// sanjeev2552

}
 