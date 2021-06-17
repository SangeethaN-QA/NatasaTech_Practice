package com.companyJavaLogic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReplaceTheWordByStarFromExcel_IVL3 {

	public static String getExcelData(String strTitle,String word_OR_sentence) throws IOException
	{
		String finalWord = null ;
		XSSFRow row;
		XSSFCell cell;
		String filepath = "..//natasaTech_Practice/src/test/resources/testData/Profanity_Words_Data.xlsx";

		FileInputStream file = new FileInputStream(filepath);

		XSSFWorkbook wb = new XSSFWorkbook(file);
		//profanity_Words
		XSSFSheet sheet = wb.getSheet("profanity_Words");


		int rowSize = sheet.getLastRowNum();
		//System.out.println("--total row size----" +rowSize);

		int col_num = 0;
		int i = 0;
		for(i=1;i<=rowSize;i++)
		{
			String excelData=sheet.getRow(i).getCell(0).getStringCellValue();  

			if(strTitle.equals("Single Word"))
			{
				//System.out.println(excelData);
				if(word_OR_sentence.equalsIgnoreCase(excelData))
				{
					//ass=ass
					finalWord = replaceWordByStar(word_OR_sentence);
					col_num = i;
					break;
				}
			}else if (strTitle.equals("Sentence"))

			{
				int word_OR_sentence_Size = word_OR_sentence.length();
				int exceldata_Size = excelData.length(); 
				//assbanger = ass/assbanger
				if(word_OR_sentence.contains(excelData))
				{
					System.out.println("----" +excelData);
					System.out.println("----" +word_OR_sentence);
					//Hi am in Assbanger = Assbanger
					if(word_OR_sentence_Size==exceldata_Size)
					{
						//	System.out.println("'"+word_OR_sentence_Size+"'  ===========   '"+exceldata_Size+"' ");
						finalWord = replaceSentenceByStar(word_OR_sentence,excelData);
						col_num = i;
						break;
					}else {
						System.out.println("'"+word_OR_sentence_Size+"'  ===size is mismatched========   '"+exceldata_Size+"' ");
						finalWord = replaceSentenceByStar(word_OR_sentence,excelData);
						col_num = i;
						break;
					}

				}


			}
			excelData=sheet.getRow(i).getCell(0).getStringCellValue();  
			//System.out.println(excelData);
		}

		return finalWord;



	}

	public static String replaceWordByStar(String word)
	{

		String wordByStar = word.replaceAll( "[A-Za-z0-9]", "*" );

		return wordByStar;
	}

	public static String replaceSentenceByStar(String sentence,String word)
	{

		String sentenceofWordByStar = "";
		String stars = "";
		int count = 0;


		String[] list = sentence.split("\\s+");
		//String[] list = sentence.replaceAll("\\s", "");


		for (int i = 0; i < word.length(); i++)
		{
			stars += '*';
		}

		for (String str : list)
		{
			if (str.compareTo(word) == 0)
			{
				list[count] = stars;
			}
			count++;
		}

		for (String str : list)
		{
			sentenceofWordByStar += str + ' ';

		}

		return sentenceofWordByStar;
	}
	public static void main(String[] args) throws IOException
	{

		//Sentence Example
		String finalWordByStar = replaceSentenceByStar("Hi am in CLITFACE City","CLITFACE");   //True
		System.out.println("---- Sentence ---------  " +finalWordByStar);

		//		
		//Word Example
		String finalWordByStar1 = getExcelData("Single Word","BLOW JOB");   //True
		System.out.println("---- Single Word ---------  " +finalWordByStar1);
		//
		//		//Invalid Word Example
		//		String finalWordByStar2 = getExcelData("Single Word","WELCOME");   //False
		//		System.out.println("---- Invalid Word ---------  " +finalWordByStar2);
		//
		//		//Invalid Sentence Example
		//		String finalWordByStar3 = getExcelData("Single Word","I am WELCOME by my Friend");   //False
		//		System.out.println("---- Invalid Sentence---------  " +finalWordByStar3);
	}
}




