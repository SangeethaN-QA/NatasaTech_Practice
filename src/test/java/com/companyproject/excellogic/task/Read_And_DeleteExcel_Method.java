package com.companyproject.excellogic.task;

import java.io.IOException;

import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class Read_And_DeleteExcel_Method{

	public String shutCode;
	
	public String getExcelData(int row,int column)
	{
		String filePath = "../ReadExternalFile/src/test/resources/testData/ShutCodeData.xlsx";

		Workbook wb = new Workbook();
		wb.loadFromFile(filePath);
		Worksheet sheet = wb.getWorksheets().get("shutCode");

		int rowSize = sheet.getRows().length;
		System.out.println(" row size #######  " +rowSize);
		//		String data = sheet.get(1, 1).getText();
		//		System.out.println("data---------- " +data);
		shutCode = sheet.get(row, column).getNumberText();
		System.out.println("get Shut Code ::::  " +shutCode);
		return shutCode;


	}

	public void deleteExcelData(int row,int column) throws IOException
	{
		String filePath = "../ReadExternalFile/src/test/resources/testData/ShutCodeData.xlsx";
		Workbook wb = new Workbook();
		wb.loadFromFile(filePath);

		Worksheet sheet = wb.getWorksheets().get("shutCode");
		String data = sheet.get(row, column).getNumberText();
		sheet.removeRange(row, column);
		System.out.println(" Shut code ::::  '"+data+"' is deleted");
		for (int i = sheet.getLastRow(); i >= 1; i--)
		{
			if (sheet.getRows()[i-1].isBlank())
			{
				sheet.deleteRow(i);
			}
		}

		for (int j = sheet.getLastColumn(); j >= 1; j--)
		{
			if (sheet.getColumns()[j-1].isBlank())
			{
				sheet.deleteColumn(j);
			}
		}

		wb.saveToFile(filePath);
		System.out.println("#####   After deleting data file has saved successfully   #####");
	}
}

