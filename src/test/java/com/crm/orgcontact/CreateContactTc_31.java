package com.crm.orgcontact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.Autodesk.genericutility.ExcelUtility;
import com.crm.Autodesk.genericutility.FileUtility;
import com.crm.Autodesk.genericutility.JavaUtility;
import com.crm.Autodesk.genericutility.WebdriverUtility;

public class CreateContactTc_31 {
	public static void main(String[] args) throws Throwable {
//		FileInputStream fis =new FileInputStream("./data/CommonData.properties");
//		Properties p=new Properties ();
//		p.load(fis);
//		String url = p.getProperty("url");
//		String username = p.getProperty("username");
//		String password = p.getProperty("password");
//		String browser = p.getProperty("browser");
//		 String email = p.getProperty("email");
//		
		FileUtility flib=new FileUtility();
		ExcelUtility elib =new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		WebdriverUtility wlib =new WebdriverUtility();
		int random = jlib.getRandomNum();
		String url = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		String browser = flib.getPropertyKeyValue("browser");
		String lastname = flib.getPropertyKeyValue("lastname");
		String email = flib.getPropertyKeyValue("email");
		String orgName = elib.getDataFromExcelSheet("sheet1", 1, 2);
		
//		Random rn=new Random();
//		int randomvalue = rn.nextInt();
//		String lastname = p.getProperty("lastname")+randomvalue;

		WebDriver driver;
		
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		
		else 
			driver=new ChromeDriver();
		
		//login into vtiger
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wlib.getPageForToLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		
		//click on create contact
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		
		//click on + button
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		//input
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.id("email")).sendKeys(email);
		 WebElement ele1 = driver.findElement(By.name("portal"));
		ele1.click();
		if(ele1.isEnabled())
			System.out.println("portel is enabled");
		
		else
			System.out.println("portel is not enabled");
		//save
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
//		Actions a=new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
			WebElement ele2 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			wlib.mouseOverOnElement(driver, ele2);

			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
	}

}
