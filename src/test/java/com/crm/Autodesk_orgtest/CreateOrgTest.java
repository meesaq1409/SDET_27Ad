package com.crm.Autodesk_orgtest;

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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.CreateORganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.LoginPage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationPage;
import com.crm.Autodesk.genericutility.ExcelUtility;
import com.crm.Autodesk.genericutility.FileUtility;
import com.crm.Autodesk.genericutility.JavaUtility;
import com.crm.Autodesk.genericutility.WebdriverUtility;
import com.mysql.cj.jdbc.Driver;

public class CreateOrgTest {

	public static void main(String[] args) throws Throwable {
		// read the data from properties file
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib =new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		WebdriverUtility wlib =new WebdriverUtility();
		
//		FileInputStream fis =new FileInputStream("./CommonData.properties");
//		Properties p=new Properties();
//		p.load(fis);
//		String url = p.getProperty("url");
//		String username = p.getProperty("username");
//		String password = p.getProperty("password");	
//		String browser = p.getProperty("browser");
//
//
//
//		Random rn=new Random();
//		int Randomnum=rn.nextInt(1000);
//
//
//
//		FileInputStream fis_e=new FileInputStream("./vtigerdata.xlsx");
//		Workbook wb=WorkbookFactory.create(fis_e);
//		Sheet sh = wb.getSheet("sheet1");
//		Row row = sh.getRow(1);
//		String orgName = row.getCell(2).getStringCellValue()+Randomnum;

		int random = jlib.getRandomNum();
		String url = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		String browser = flib.getPropertyKeyValue("browser");
		
		String orgName = elib.getDataFromExcelSheet("sheet1", 1, 2)+random;
		WebDriver driver;


		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		//login
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		wlib.getPageForToLoad(driver);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.getLoginInfo(username, password);
		
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).submit();
		HomePage hp=new HomePage(driver);
		hp.getcreateOrganization();
//		driver.findElement(By.linkText("Organizations")).click();
		OrganizationPage op=new OrganizationPage(driver);
		op.clickonCreateOrg();
		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		CreateORganizationPage cop=new CreateORganizationPage(driver);
		cop.createorg(orgName);
		//verify organization name 
		
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String act_msg = oip.getOrganizationinfo();
//		String act_msg=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(act_msg.contains(orgName))
			System.out.println("org issuccessfully created");
		else
			System.out.println("org is not created");
		
		//logout
//		Actions a=new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		WebElement ele1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		wlib.mouseOverOnElement(driver, ele1);
	oip.logout(driver);
		driver.quit();
		



	}

}
