package com.companyproject.excellogic.task;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Read_And_Delete_Excel_TestClass {
	
	Read_And_DeleteExcel_Method readFile = new Read_And_DeleteExcel_Method();
	public String shutCode;
	 
  @BeforeTest
  public void Test_A() throws IOException {
	  System.out.println("a get data");
	  shutCode = readFile.getExcelData(2, 1);
	  System.out.println( " get shut code for 1st exec #####  " +shutCode);
	  
	  readFile.deleteExcelData(2, 1);
	  System.out.println(" 1st exec shut code is deleted");
  }
  
  @Test
  public void Test_B() throws IOException {
	  System.out.println("b get data");
	  shutCode = readFile.getExcelData(2, 1);
	  System.out.println( " get shut code for 2nd exec #####  " +shutCode);
	  
	  readFile.deleteExcelData(2, 1);
	  System.out.println(" 2nd exec shut code is deleted");

  }
  
  @AfterTest
  public void Test_C() throws IOException {
	  System.out.println("c get data");
	  shutCode = readFile.getExcelData(2, 1);
	  System.out.println( " get shut code for 3rd exec #####  " +shutCode);

	  readFile.deleteExcelData(2, 1);
	  System.out.println(" 3rd exec shut code is deleted");
  }
}
