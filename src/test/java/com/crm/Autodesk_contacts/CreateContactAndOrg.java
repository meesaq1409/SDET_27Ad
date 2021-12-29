package com.crm.Autodesk_contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.sevenz.CLI;
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
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.ContactPage;
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

public class CreateContactAndOrg {
public static void main(String[] args) throws Throwable {
	FileUtility flib=new FileUtility();
	ExcelUtility elib =new ExcelUtility();
	JavaUtility jlib =new JavaUtility();
	WebdriverUtility wlib =new WebdriverUtility();
//	FileInputStream fis =new FileInputStream("./CommonData.properties");
//	Properties p=new Properties();
//	//load the data 
//	p.load(fis);
//	String url = p.getProperty("url");
//	String username = p.getProperty("username");
//	String password = p.getProperty("password");	
//	String browser = p.getProperty("browser");
//	Random rn=new Random();
//	int Randomnum=rn.nextInt(1000);
//	String lastname = p.getProperty("lastname")+Randomnum;

	int random = jlib.getRandomNum();
	String url = flib.getPropertyKeyValue("url");
	String username = flib.getPropertyKeyValue("username");
	String password = flib.getPropertyKeyValue("password");
	String browser = flib.getPropertyKeyValue("browser");
	String lastname = flib.getPropertyKeyValue("lastname")+random;

//	FileInputStream fis_e=new FileInputStream("./vtigerdata.xlsx");
//	Workbook wb=WorkbookFactory.create(fis_e);
//	Sheet sh = wb.getSheet("sheet1");
//	Row row = sh.getRow(1);
//	String orgName = row.getCell(2).getStringCellValue()+Randomnum;
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
	
//	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	wlib.getPageForToLoad(driver);
	driver.get(url);
	           //step 1:login
	LoginPage lp =new LoginPage(driver);
	lp.getLoginInfo(username, password);
	
//	driver.findElement(By.name("user_name")).sendKeys(username);
//	driver.findElement(By.name("user_password")).sendKeys(password);
//	driver.findElement(By.id("submitButton")).submit();
	
	
				//step 2: click on organization
	HomePage hp=new HomePage(driver);
	hp.getcreateOrganization();
//	driver.findElement(By.linkText("Organizations")).click();
//	
	
				// step3:click on create button
	
	OrganizationPage op=new OrganizationPage(driver);
	op.clickonCreateOrg();
	
//	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	
	
				//step4: filling data and save
	CreateORganizationPage cop =new CreateORganizationPage(driver);
	cop.createorg(orgName);
	
//	driver.findElement(By.name("accountname")).sendKeys(orgName);
//	driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	
	
	
			//step5: wait until element to be clickable

	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	oip.getOrganizationtxtwait(driver);
//	WebElement ele1 = driver.findElement(By.className("dvHeaderText"));
//	wlib.waitElementToBeClickable(driver, ele1);
	
	
				//step 6: click on contact page
	
	oip.getCreateContacts();
//	driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();

	
				//step7: click on create button
	ContactPage cp=new ContactPage(driver);
	cp.clickonCreateContact();
	//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	
			//step 8: lastname and click on org list button
	
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.createContAndorg(lastname);
//	driver.findElement(By.name("lastname")).sendKeys(lastname);
//	driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();

	
		//step9: switch window to accounts and click current orgname

		ccp.switchWin(driver, "Accounts",orgName);
	
	
		
//	wlib.switchToWindow(driver, "Accounts");
//	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
	
		//step10: switch window to parent and save it
		
			
		wlib.switchToWindow(driver, "Contacts");
	//driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();

	ccp.saveorg();
		WebElement ele2 = driver.findElement(By.className("dvHeaderText"));
		wlib.waitElementToBeClickable(driver, ele2);
		
		//verify
		
		//String act_msg=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']/a[text()='"+orgName+"']")).getText();
		//String act_msg=driver.findElement(By.linkText(orgName)).getText();
		ContactInfoPage cip=new ContactInfoPage(driver);
		String act_msg = cip.getContactinfo(driver, orgName);
	
	System.out.println(act_msg);
	
		//Thread.sleep(2000);
		if(act_msg.equals(orgName))
			System.out.println("contact is successfully created");
		else
			System.out.println("contact is not created");
		
		//logout
//	
//		WebElement ele3 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		wlib.mouseOverOnElement(driver, ele3);
		cip.logout(driver);
		driver.quit();
	
	}
	
}

