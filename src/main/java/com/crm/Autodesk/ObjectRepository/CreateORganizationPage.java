package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericutility.WebdriverUtility;

public class CreateORganizationPage {

	
	//step1:
	
	
	//step 2:identify
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement accountDropdown;
	
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement savebtn;

	public CreateORganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getAccountDropdown() {
		return accountDropdown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	public void createorg(String orgname,String industry,String accounttype) {
		organizationNameEdt.sendKeys(orgname);
		industryDropDown.sendKeys(industry);
		
		accountDropdown.sendKeys(accounttype);
		savebtn.click();
		
	}
	
	public void createorg(String orgname)
	
	{
		organizationNameEdt.sendKeys(orgname);
		savebtn.click();
	}
	
}
