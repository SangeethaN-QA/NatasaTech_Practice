package com.companyproject.excellogic.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TestRead_PracticeSample {
	public static void main(String[] args) throws IOException {
		
		File src= new File("C:\\Users\\dell\\Downloads\\AYS ticket.xls");
		FileInputStream fis=new FileInputStream(src);
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet Sheet1=wb.getSheetAt(0);
		int rowcount=Sheet1.getLastRowNum();
		System.out.println(" size :: "+rowcount);

		for(int i=1;i<rowcount+1;i++) {

			String data=Sheet1.getRow(i).getCell(0).getStringCellValue(); 
			System.out.println(" Print values ::: "+data);
		}
	}

}
