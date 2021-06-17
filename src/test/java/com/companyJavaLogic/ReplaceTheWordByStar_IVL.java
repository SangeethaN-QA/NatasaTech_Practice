package com.companyJavaLogic;

public class ReplaceTheWordByStar_IVL {
	
		public static String replaceWordByStar(String sentence,String word)
		{

			String starText = "";
			String stars = "";
			int count = 0;
			
			String[] list = sentence.split("\\s+");
		
			for (int i = 0; i < word.length(); i++)
			{
				stars += '*';
			}
				
			for (String str : list)
			{
				if (str.compareTo(word) == 0)
				{
					list[count] = stars;
					System.out.println("^^^^^^^^^^^  " +list[count]);
				}
				count++;
			}

			for (String str : list)
			{
				starText += str + ' ';
			
			}

			return starText;
		}

		// Driver code
		public static void main(String[] args)
		{
			String sentence = "This Country Name is India"; //country replaced by *****(true)
			//String sentence = "ThisCountry Name is India"; // country not replaced by *****(false)
			String word = "Country";
			System.out.println(replaceWordByStar(sentence, word));
		}
		


}
