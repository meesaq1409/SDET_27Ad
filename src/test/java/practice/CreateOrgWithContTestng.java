package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.ContactPage;
import com.crm.Autodesk.ObjectRepository.CreateContactPage;
import com.crm.Autodesk.ObjectRepository.CreateORganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationPage;
import com.crm.Autodesk.genericutility.BaseClass;
@Listeners(com.crm.Autodesk.genericutility.ListenerImplementation.class)
public class CreateOrgWithContTestng extends BaseClass {

	@Test(groups={"","regression"})
	public void CreateOrgWithContTestng1() throws Throwable {
		int random = jlib.getRandomNum();
		String lastname = flib.getPropertyKeyValue("lastname") + random;
		String orgName = elib.getDataFromExcelSheet("Sheet1", 01, 02)+random;
		// click on organization page
		HomePage hp = new HomePage(driver);
		hp.getcreateOrganization();

		// click on create org button
		OrganizationPage op = new OrganizationPage(driver);
		op.clickonCreateOrg();
		// create organization
		CreateORganizationPage cop = new CreateORganizationPage(driver);

		cop.createorg(orgName);
		// click on contact page
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.getOrganizationtxtwait(driver);
		oip.getCreateContacts();
		Assert.fail();
		// click on create contact button
		ContactPage cp=new ContactPage(driver);
		cp.clickonCreateContact();
		
		//create contact account
		CreateContactPage ccp = new CreateContactPage(driver);

		ccp.createContAndorg(lastname);
		ccp.switchWin(driver, "Accounts", orgName);
		
		wlib.switchToWindow(driver, "Contacts");
		
		ccp.saveorg();
		WebElement ele2 = driver.findElement(By.className("dvHeaderText"));
		wlib.waitElementToBeClickable(driver, ele2);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String act_msg = cip.getContactinfo(driver, orgName);
	
	System.out.println(act_msg);
	
		//Thread.sleep(2000);
	SoftAssert sa=new SoftAssert();
	sa.assertTrue(act_msg.contains(orgName));
	sa.assertAll();
//		if(act_msg.equals(orgName))
//			System.out.println("contact is successfully created");
//		else
//			System.out.println("contact is not created");
//

	}
}
