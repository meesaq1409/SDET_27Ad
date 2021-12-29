package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Autodesk.ObjectRepository.CreateORganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationPage;
import com.crm.Autodesk.genericutility.BaseClass;
@Listeners(com.crm.Autodesk.genericutility.ListenerImplementation.class)
public class CreateOrgTestNg extends BaseClass{

	@Test(groups={"smoke","regression"})
	public void CreateOrgTest() throws Throwable{
		//click on organization button
		HomePage hp=new HomePage(driver);
		hp.getcreateOrganization();
		
		//click on create org button
		OrganizationPage op=new OrganizationPage(driver);
		op.clickonCreateOrg();
		
		//create org
		int ran=jlib.getRandomNum();
		CreateORganizationPage cop=new CreateORganizationPage(driver);
		String orgName = elib.getDataFromExcelSheet("Sheet1", 1, 2)+ran;
		cop.createorg(orgName);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		Assert.fail();
		String Act_msg = oip.getOrganizationinfo();
		SoftAssert sa =new SoftAssert();
		sa.assertTrue(Act_msg.contains(orgName));
		sa.assertAll();
//		if(Act_msg.contains(orgName))
//		{
//			System.out.println("test case pass==>organization cfreated successfully");
//		}
//		else
//			System.out.println("test case failed==>organization not created");
		
	}
	
}
