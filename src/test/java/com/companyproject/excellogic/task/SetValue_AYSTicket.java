package com.companyproject.excellogic.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;


public class SetValue_AYSTicket {
	public static void main(String[] args) throws IOException {
		
		File src= new File("C:\\Users\\dell\\Downloads\\AYS ticket.xls");
		FileInputStream fsIP=new FileInputStream(src);
		
        HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
          
        HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
          
        Cell cell = null; // declare a Cell object
        
        cell = worksheet.getRow(2).getCell(2);   // Access the second cell in second row to update the value
          
        cell.setCellValue("OverRide Last Name");  // Get current cell value value and overwrite the value
          
        fsIP.close(); //Close the InputStream
         
        FileOutputStream output_file =new FileOutputStream(src);  //Open FileOutputStream to write updates
          
        wb.write(output_file); //write changes
          
        output_file.close();

	}

}
