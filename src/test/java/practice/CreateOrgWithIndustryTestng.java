package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Autodesk.ObjectRepository.CreateORganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationPage;
import com.crm.Autodesk.genericutility.BaseClass;

@Listeners(com.crm.Autodesk.genericutility.ListenerImplementation.class)
public class CreateOrgWithIndustryTestng extends BaseClass {
	
	@Test
	public void CreateOrgWithIndustryTest() throws Throwable
	{
		
		//click on organization page
		HomePage hp=new HomePage(driver);
		hp.getcreateOrganization();
		
		
		//click on create org button
		OrganizationPage op=new OrganizationPage(driver);
		op.clickonCreateOrg();
		//create org page with industry and type
		CreateORganizationPage cop=new CreateORganizationPage(driver);
		int random=jlib.getRandomNum();
		String orgName = elib.getDataFromExcelSheet("Sheet1", 1, 02)+random;
		String industry = elib.getDataFromExcelSheet("Sheet2", 1, 4);
		String type = elib.getDataFromExcelSheet("Sheet2", 1, 5);
		cop.createorg(orgName, industry, type);
		
		
		//validATION
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String Act_msgInd = oip.IndustryinfoTxt();
		String Act_msgType = oip.AccounttypeinfoTxt();
		Assert.fail();
		SoftAssert sa =new SoftAssert();
		
		sa.assertTrue(Act_msgInd.contains(industry));
		Reporter.log("indusrty created",true);
		
		sa.assertTrue(Act_msgType.contains(type));
		
//		if(Act_msgInd.equals(industry))
//		{
//			System.out.println("test passed==>industry created");
//		}
//		if(Act_msgType.equals(type))
//			System.out.println("test passed==> type created");
//		
//		else
//			System.out.println("test case failed");
		sa.assertAll();
}

}
