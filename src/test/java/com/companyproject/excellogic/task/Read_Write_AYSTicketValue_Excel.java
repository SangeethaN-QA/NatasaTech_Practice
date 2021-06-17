package com.companyproject.excellogic.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Read_Write_AYSTicketValue_Excel {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","H:\\Kirke_23_May_2019\\surveillance-kirke-junit-screenplay\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://atyourservice.verizon.com/ays");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		String strXpath = "//div[@class='search']//input[@name='q']";		
		List<WebElement>li = driver.findElements(By.xpath(strXpath));
		System.out.println("The search field Size is :  " +li.size());

		if(li.size()==1)
		{
			File src= new File("H:\\Sangeetha N\\VZ - Project - Files\\KIRKE\\Kirke - Automation\\AYS ticket.xls");
			FileInputStream fis=new FileInputStream(src);
			HSSFWorkbook wb=new HSSFWorkbook(fis);
			HSSFSheet Sheet1=wb.getSheetAt(0);
			int rowcount=Sheet1.getLastRowNum();
			System.out.println(" size :: "+rowcount);

			for(int i=1;i<rowcount+1;i++) {

				String data=Sheet1.getRow(i).getCell(0).getStringCellValue();  
				//System.out.println(" ### "+data);

				WebElement ele = driver.findElement(By.xpath(strXpath));
				ele.click();
				ele.sendKeys(Sheet1.getRow(i).getCell(0).getStringCellValue());

				
				String strSearch = "//button[@name='search']//img[@role='presentation']";
				WebElement element = driver.findElement(By.xpath(strSearch));
				element.click();
				
				String strDesc = "//label[contains(text(),'Description')]/following::pre[1]";
				WebElement description = driver.findElement(By.xpath(strDesc));
				String txtDescription = description.getText();
				System.out.println(" Print Description #### "+txtDescription);
				
				System.out.println(" ####### To Write the Description into excel data ######");
				
				
				
				String strHome = "//a[contains(text(),'Home')]";
				WebElement home = driver.findElement(By.xpath(strHome));
				home.click();
				System.out.println("Home Link is Clicked");
				
				System.out.println(" ###### To Start Passig Next Value From Excel #######");
				WebElement eleNext = driver.findElement(By.xpath(strXpath));
				eleNext.click();
				eleNext.sendKeys(Sheet1.getRow(i).getCell(0).getStringCellValue());
				
				String data1=Sheet1.getRow(i).getCell(0).getStringCellValue(); 
				System.out.println(" Reduced Size :: "+data1.length());
			}

		}
		
	}

}
