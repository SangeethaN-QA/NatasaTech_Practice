package com.companyproject.excellogic.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadAndWrite_ErrorMsg_Google {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		String strXpath = "//input[@name='q']";		
		List<WebElement>li = driver.findElements(By.xpath(strXpath));
		System.out.println("The input field Size is :  " +li.size());

		if(li.size()==1)
		{
			File src= new File("C:\\Users\\dell\\Downloads\\AYS ticket.xls");
			FileInputStream fis=new FileInputStream(src);
			HSSFWorkbook wb=new HSSFWorkbook(fis);
			HSSFSheet Sheet1=wb.getSheetAt(0);
			int rowcount=Sheet1.getLastRowNum();
			System.out.println(" size :: "+rowcount);

			for(int i=1;i<rowcount+1;i++) {

				System.out.println(" ###### To Pass the data into input text box ######");
				String data=Sheet1.getRow(i).getCell(0).getStringCellValue();  
				//System.out.println(" ### "+data);

				WebElement ele = driver.findElement(By.xpath(strXpath));
				ele.click();
				ele.clear();
				ele.sendKeys(Sheet1.getRow(i).getCell(0).getStringCellValue());
				System.out.println("Print first value :: "+Sheet1.getRow(i).getCell(0).getStringCellValue());
				
				System.out.println(" ###### To Click on Login Button ######");

				String strbtn = "//button[@id='login_submit']";
				WebElement btn = driver.findElement(By.xpath(strbtn));
				btn.click();

				System.out.println(" ###### To Get the Error Message ######");

				String strDesc = "//div[contains(text(),'You must specify a username to log in.')]";
				WebElement description = driver.findElement(By.xpath(strDesc));
				String txtDescription = description.getText();
				System.out.println(" Print Description #### "+txtDescription);

				//set value in excel

				System.out.println(" ####### To Write the Error Message into excel data ######");

				for(int j=1;j<rowcount+1;j++)
				{
					//String columnData=sh1.getRow(i).getCell(j).getStringCellValue(); 
					//System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
					Sheet1.getRow(i).createCell(j).setCellValue(txtDescription);
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					fout.close();

				}

				String data1=Sheet1.getRow(i).getCell(0).getStringCellValue(); 
				System.out.println(" Reduced Size :: "+data1.length());
			}

		}

	}

}
