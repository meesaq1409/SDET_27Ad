package practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.ContactPage;
import com.crm.Autodesk.ObjectRepository.CreateContactPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.genericutility.BaseClass;
import com.crm.Autodesk.genericutility.DatabaseUtility;
import com.crm.Autodesk.genericutility.ExcelUtility;
import com.crm.Autodesk.genericutility.FileUtility;
import com.crm.Autodesk.genericutility.JavaUtility;
import com.crm.Autodesk.genericutility.WebdriverUtility;



@Listeners(com.crm.Autodesk.genericutility.ListenerImplementation.class)
public class CreateContactTestng extends BaseClass{


	@Test(groups={"smoke","regression"},retryAnalyzer=com.crm.Autodesk.genericutility.RetryAnalyzer.class)
	public void CreateContactTestng1() throws Throwable
	{
		int ran = jlib.getRandomNum();
		HomePage hp=new HomePage(driver);
		hp.getCreateContacts();
		ContactPage cp=new ContactPage(driver);
		cp.clickonCreateContact();
		CreateContactPage ccp=new CreateContactPage(driver);
		String lastname = flib.getPropertyKeyValue("lastname")+ran;
		ccp.createCont(lastname);
		ccp.getSavebtn();
		ContactInfoPage cip =new ContactInfoPage(driver);
		String ActTitle = cip.getContactinfo();
		SoftAssert sa=new SoftAssert();
		
		sa.assertTrue(ActTitle.contains(lastname));
		sa.fail();
		sa.assertAll();
//		if(ActTitle.contains(lastname))
//			
//			System.out.println("contact created");
//		else
//			System.out.println("contact is not created");
		
	}
	
}
