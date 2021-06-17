package com.companyproject.excellogic.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteValue_PracticeSample {
	public static void main(String[] args) {
		try{

			File src=new File("C:\\Users\\dell\\Downloads\\AYS ticket.xls");

			FileInputStream fis=new FileInputStream(src);
			HSSFWorkbook wb=new HSSFWorkbook(fis);

			HSSFSheet sh1= wb.getSheetAt(0);
			
			int rowcount = sh1.getLastRowNum();
			System.out.println(" Ticket Number Row Size :: "+rowcount);

			for(int i=1;i<rowcount+1;i++) {
				String rowData=sh1.getRow(i).getCell(0).getStringCellValue(); 
				System.out.println(" Print Ticket Number ###"+rowData);
				
				
				
				{
					for(int j=1;j<rowcount+1;j++)
					{
						//String columnData=sh1.getRow(i).getCell(j).getStringCellValue(); 
						//System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
						sh1.getRow(i).createCell(j).setCellValue("sangeetha");
						FileOutputStream fout=new FileOutputStream(src);


						wb.write(fout);

						fout.close();
						
					}
				}
				

				
			
			}
			
			//to send values to textbox
			//to get description and set into excel sheet
			
			
	
		

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
}


