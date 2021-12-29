package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//step1:\create separate class
	
	
	//step 2: identify all elements and declare
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createOrgLookUpImg;
//step3: initiliaze element
	public OrganizationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//step4: utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
//step5:
	public void clickonCreateOrg()
	{
		createOrgLookUpImg.click();
		
	}
}
