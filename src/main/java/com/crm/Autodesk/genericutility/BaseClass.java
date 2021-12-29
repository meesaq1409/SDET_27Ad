package com.crm.Autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.LoginPage;

public class BaseClass  {

	public DatabaseUtility dlib=new DatabaseUtility();
public 	JavaUtility jlib =new JavaUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
		
	
	@BeforeSuite(groups={"smoke","regression"})
	public void DbConnection(){
		System.out.println("connection established");
		
	
	}
	//@Parameters("browser")
	@BeforeClass(groups={"smoke","regression"})
	public void getBrowser(/*String browser*/) throws Throwable
	{
	
		String browser = flib.getPropertyKeyValue("browser");
		String url = flib.getPropertyKeyValue("url");
		if(browser.equalsIgnoreCase("chrome"))
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
		sdriver=driver;
		System.out.println("browser open");
		wlib.maximizeWindow(driver);
		wlib.getPageForToLoad(driver);
		driver.get(url);
	}
	@BeforeMethod(groups={"smoke","regression"})
	public void  loginToApplication() throws Throwable
	{
		
		System.out.println("login successfully");
		String username = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		
		String email = flib.getPropertyKeyValue("email");

		//wlib.getPageForToLoad(driver);
	
		LoginPage lp=new LoginPage(driver);
		lp.getLoginInfo(username, password);
		//System.out.println("login successfully");
	}
	
	@AfterMethod(groups={"smoke","regression"})
	public void logoutToApplication()
	{
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.logout(driver);
	}
		
	@AfterClass(groups={"smoke","regression"})
	public void CloseBrowser()
	{
		driver.quit();
		
	}
	@AfterSuite(groups={"smoke","regression"})
	public void CloseDbConnection()
	{
		System.out.println("database connection is closed");
	}
		
		
		
	
	
	
	
}
