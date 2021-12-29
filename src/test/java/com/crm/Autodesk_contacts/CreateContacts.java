package com.crm.Autodesk_contacts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.ContactPage;
import com.crm.Autodesk.ObjectRepository.CreateContactPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.LoginPage;
import com.crm.Autodesk.genericutility.FileUtility;
import com.crm.Autodesk.genericutility.JavaUtility;
import com.crm.Autodesk.genericutility.WebdriverUtility;

public class CreateContacts {
	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wlib= new WebdriverUtility();
		String url = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		String browser = flib.getPropertyKeyValue("browser");
		int ran = jlib.getRandomNum();
		String lastname = flib.getPropertyKeyValue("lastname")+ran;
		
		
//		FileInputStream fis =new FileInputStream("./CommonData.properties");
//		Properties p=new Properties();
//		p.load(fis);
//		String url = p.getProperty("url");
//		String username = p.getProperty("username");
//		String password = p.getProperty("password");	
//		String browser = p.getProperty("browser");
//		Random rn=new Random();
//		int Randomnum=rn.nextInt(1000);
//		String lastname = p.getProperty("lastname")+Randomnum;

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
		
//		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);\
		wlib.getPageForToLoad(driver);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.getLoginInfo(username, password);
		
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).submit();
		
		
//		driver.findElement(By.linkText("Contacts")).click();
		HomePage hp=new HomePage(driver);
		hp.getCreateContacts();
		
		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		ContactPage cp=new ContactPage(driver);
		cp.clickonCreateContact();
//		driver.findElement(By.name("lastname")).sendKeys(lastname);
//		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
//		String ActTitle=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createCont(lastname);
		ccp.getSavebtn();
		ContactInfoPage cip =new ContactInfoPage(driver);
		String ActTitle = cip.getContactinfo();
		
		if(ActTitle.contains(lastname))
			System.out.println("contact created");
		else
			System.out.println("contact is not created");
		
//		Actions a=new Actions(driver);
//		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		wlib.mouseOverOnElement(driver, ele);
//		driver.findElement(By.linkText("Sign Out")).click();
//		
		cip.logout(driver);
		driver.quit();
	}
}
