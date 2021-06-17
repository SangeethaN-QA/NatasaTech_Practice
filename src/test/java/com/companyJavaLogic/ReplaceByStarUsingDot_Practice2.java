package com.companyJavaLogic;

public class ReplaceByStarUsingDot_Practice2 {


	static String replace_word(String Sentence, String replaceWord){
		String[] word_list = Sentence.split("\\s+");
		String my_result = "";
		String asterisk_val = "";
		for (int i = 0; i < replaceWord.length(); i++)
		{
			asterisk_val += '*';
			}
			
		int my_index = 0;
		for (String i : word_list){
			
			if (i.compareTo(replaceWord) == 0)
			{
				word_list[my_index] = asterisk_val;
			}
			my_index++;
		}
		
		for (String i : word_list)
		{
			my_result += i + ' ';
		}
			
		return my_result;
	}
	public static void main(String[] args){
		String sentence = "This is a sample only, the sky is blue, water is transparent ";
		String pattern = "only";
		System.out.println(replace_word(sentence, pattern));
	}


}
