package com.weekend.task;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class May_23rd_excelData_Pass_To_Automation {
	
	public static void main(String[] args) throws IOException {
		
		May_23_GetDataExcelMethod excel = new May_23_GetDataExcelMethod();
		
		System.setProperty("webdriver.chrome.driver",
				"..//natasaTech_Practice/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.utsavfashion.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='header-account']//a[text()='Log In']")).click();
		WebElement ele  = driver.findElement(By.xpath("//div[contains(@class,'fright right-block')]/descendant::div[@class='dg-prpopupheading']"));
		System.out.println("---text----" +ele.getText());
		driver.findElement(By.xpath("//span/a[text()='Create an Account']")).click();
		
		String first_name = excel.getData("userRegisterData", "FirstName");
		System.out.println("---first name----" +first_name);
		
		String LastName = excel.getData("userRegisterData", "LastName");
		System.out.println("---LastName name----" +LastName);
		
		String Email_id = excel.getData("userRegisterData", "Email_id");		
		System.out.println("---Email_id name----" +Email_id);
		
		String Password = excel.getData("userRegisterData", "Password");
		System.out.println("---Password name----" +Password);
		
		driver.findElement(By.xpath("//input[@id='prpop-firstname']")).sendKeys(first_name);
		driver.findElement(By.xpath("//input[@id='prpop-lastname']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@id='prpop-email_address']")).sendKeys(Email_id);
		driver.findElement(By.xpath("//input[@id='prop-password']")).sendKeys(Password);
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		List<WebElement> li = driver.findElements(By.xpath("//div[contains(@class,'carousel-cell carousel-promo')]//a"));
		System.out.println("size-------- " +li.size());
		
		for(int i=0;i<li.size();i++)
		{
			System.out.println("--------text--------" +li.get(i).getText());
		}
	
		
		driver.close();
		
	}

}
