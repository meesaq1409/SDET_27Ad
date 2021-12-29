package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericutility.WebdriverUtility;

public class OrganizationInfoPage extends WebdriverUtility {

	
	@FindBy(className="dvHeaderText")
	private WebElement organizationHeadertxt;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryTxt;
	
	@FindBy(id="mouseArea_Type")
	private WebElement accounttypeTxt;
	
	@FindBy(className="dvHeaderText")
	private WebElement organizationTxtWait;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslnk;
	

	

	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logout;
	
	
	
	
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrganizationHeadertxt() {
		return organizationHeadertxt;
	}
	public WebElement getIndustryTxt() {
		return industryTxt;
	}


	public WebElement getAccounttypeTxt() {
		return accounttypeTxt;
	}
	
	public WebElement getOrganizationHeaderTxt() {
		return organizationTxtWait;
	}
	
	
	

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	
	public WebElement getLogout() {
		return logout;
	}


	public String getOrganizationinfo()
	{
		return organizationHeadertxt.getText();
		
	}
	
	public WebElement getContactslnk() {
		return contactslnk;
	}


	public void getOrganizationtxtwait(WebDriver driver)
	{
		waitElementToBeClickable(driver, organizationTxtWait);
	}
	public String IndustryinfoTxt()
	{
		return industryTxt.getText();
	}
	 
	public void getCreateContacts()
	{
		contactslnk.click();
	}
	
	public String AccounttypeinfoTxt()
	{
		return accounttypeTxt.getText();
	}
	
	public void logout(WebDriver driver)
	{
		mouseOverOnElement(driver, administratorImg);
		logout.click();
		
	}
	

}
