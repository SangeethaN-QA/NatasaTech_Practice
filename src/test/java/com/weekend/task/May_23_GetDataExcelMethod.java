package com.weekend.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class May_23_GetDataExcelMethod {
	
	
	@Test
	public void testGetDataMethod() throws IOException
	{
		String data = getData("userRegisterData", "Password");
		System.out.println(">>>>>>>>>>>" +data);
		
		String data1 = getData("userRegisterData", "UserName");
		System.out.println("------UserName------------" +data1);
		
		String data2 = getData("userRegisterData", "Email_id");
		System.out.println("------Email_id------------" +data2);
		
		String data3 = getData("userRegisterData", "LastName");
		System.out.println("------LastName------------" +data3);
	}
	
	public String getData(String sheetName,String Col_Name) throws IOException {
		
		String rowdata;
		XSSFRow row;
		XSSFCell cell;
		//String col_Name = "FirstName";
		String filepath = "..//natasaTech_Practice/src/test/resources/testData/AssignmentWeek_May23rd_2021.xlsx";
		
		FileInputStream file = new FileInputStream(filepath);
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		//userRegisterData
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		row = sheet.getRow(0);
		
		int size = row.getLastCellNum();
		System.out.println("---size--" +size);
		
//		int rowSize = sheet.getLastRowNum();
//		System.out.println("--total row size----" +rowSize);
		
		int col_num = 0;
		int i = 0;
		for(i=0;i<size;i++)
		{
			if(row.getCell(i).getStringCellValue().equals(Col_Name))
			{
				System.out.println("============= " +row.getCell(i).getStringCellValue());
				col_num = i;				
				break;
			
			}
		}
		
		row = sheet.getRow(1);
		cell = row.getCell(col_num);
		System.out.println(" cell num----- " +cell);
		rowdata = cell.getStringCellValue();
		System.out.println("--------'"+Col_Name+"' ------------ " +rowdata);
		return rowdata;
		
		
		
	}
	

}
