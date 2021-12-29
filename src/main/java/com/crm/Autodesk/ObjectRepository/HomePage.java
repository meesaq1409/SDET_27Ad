package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericutility.WebdriverUtility;

/**
 * 
 * @author meesaq khan
 *
 */
public class HomePage extends WebdriverUtility {

	
	//step:1 create separate class
	
	//step 2 :identify all webelement and declare
	@FindBy(linkText="Organizations")
	private WebElement organizationlnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslnk;
	
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//steps 3:utilixzation by providing getters
	public WebElement getOrganizationlnk() {
		return organizationlnk;
		
	}

	public WebElement getContactslnk() {
		return contactslnk;
	}


	
	public void getcreateOrganization()
	{
		organizationlnk.click();
	}
	public void getCreateContacts()
	{
		contactslnk.click();
	}
	
	
	
}
