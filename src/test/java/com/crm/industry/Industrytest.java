package com.crm.industry;

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
import org.openqa.selenium.support.ui.Select;

import com.crm.Autodesk.ObjectRepository.CreateContactPage;
import com.crm.Autodesk.ObjectRepository.CreateORganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.LoginPage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationPage;
import com.crm.Autodesk.genericutility.ExcelUtility;
import com.crm.Autodesk.genericutility.FileUtility;
import com.crm.Autodesk.genericutility.JavaUtility;
import com.crm.Autodesk.genericutility.WebdriverUtility;

public class Industrytest {
public static void main(String[] args) throws Throwable {
//	FileInputStream fis=new FileInputStream("./data/CommonData.properties");
//	Properties p =new Properties();
//	p.load(fis);
//	String url = p.getProperty("url");
//	String username = p.getProperty("username");
//	String password = p.getProperty("password");	
//	String browser = p.getProperty("browser");
//	Random rn=new Random();
//	int Randomnum=rn.nextInt(1000);
//
//	
//	FileInputStream fis_e=new FileInputStream("./data/dataindusrty.xlsx");
//	Workbook wb=WorkbookFactory.create(fis_e);
//	Sheet sh = wb.getSheet("Sheet1");
//	Row row = sh.getRow(1);
//	String orgName = row.getCell(2).getStringCellValue()+Randomnum;
//
//	Sheet sh1 = wb.getSheet("Sheet2");
//	Row rw = sh1.getRow(1);
//	String indName = rw.getCell(4).getStringCellValue();
//	
//	String typeName = rw.getCell(5).getStringCellValue();
	FileUtility flib=new FileUtility();
	ExcelUtility elib =new ExcelUtility();
	JavaUtility jlib =new JavaUtility();
	WebdriverUtility wlib =new WebdriverUtility();
	int random = jlib.getRandomNum();
	String url = flib.getPropertyKeyValue("url");
	String username = flib.getPropertyKeyValue("username");
	String password = flib.getPropertyKeyValue("password");
	String browser = flib.getPropertyKeyValue("browser");
	String lastname = flib.getPropertyKeyValue("lastname")+random;
	String orgName = elib.getDataFromExcelSheet("sheet1", 1, 2)+random;
	String indName = elib.getDataFromExcelSheet("sheet2", 1, 4);
	String typeName = elib.getDataFromExcelSheet("sheet2", 1, 5);
//	
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
//	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	wlib.getPageForToLoad(driver);
	driver.get(url);
	
//	driver.findElement(By.name("user_name")).sendKeys(username);
//	driver.findElement(By.name("user_password")).sendKeys(password);
//	driver.findElement(By.id("submitButton")).submit();
//	driver.findElement(By.linkText("Organizations")).click();
//	
	         //step1: login
	LoginPage lp=new LoginPage(driver);
	lp.getLoginInfo(username, password);
			// step 2 :click on organization button
	HomePage hp=new HomePage(driver);
	hp.getcreateOrganization();
	         //step 3 :click on create organization button
	OrganizationPage op=new OrganizationPage(driver);
	op.clickonCreateOrg();
	
	
  //	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
			  //step 4 :filling text field and save it
	CreateORganizationPage cop=new CreateORganizationPage(driver);
	cop.createorg(orgName, indName, typeName);
	
//	driver.findElement(By.name("accountname")).sendKeys(orgName);
	//WebElement ele1 = driver.findElement(By.name("industry"));
//	Select s1=new Select(ele1);
//	s1.selectByVisibleText("Energy");
	//wlib.select(ele1, "Energy");
//	WebElement ele2 = driver.findElement(By.name("accounttype"));

//	Select s2 =new Select(ele2);
//	
//	s2.selectByVisibleText("Press");
	//wlib.select(ele2, "Press");
	//driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	
	
	
			//step 5: validation
	System.out.println(indName);
	System.out.println(typeName);
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String act_msg = oip.IndustryinfoTxt();
	
	if(act_msg.equals(indName) )
	{
		System.out.println("industry passed");
	}
	
	String act1_masg = oip.AccounttypeinfoTxt();
		if(act1_masg.equals(typeName))
	System.out.println("industry type passed");
	
	else
		System.out.println("test failed");

//		WebElement ele3 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		wlib.mouseOverOnElement(driver, ele3);
//		driver.findElement(By.linkText("Sign Out")).click();
				//step 6: logout
		oip.logout(driver);
	driver.quit();

	
	
}
}
