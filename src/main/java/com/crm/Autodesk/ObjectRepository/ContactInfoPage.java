package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericutility.WebdriverUtility;

public class ContactInfoPage extends WebdriverUtility {

	
	
	@FindBy(className="dvHeaderText")
	private WebElement contactHeadersstxt;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logout;
	
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getContactHeadertxt() {
		return contactHeadersstxt;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	
	public WebElement getLogout() {
		return logout;
	}

	
	public String getContactinfo()
	{
		return (contactHeadersstxt.getText());
	}
	public void logout(WebDriver driver)
	{
		mouseOverOnElement(driver, administratorImg);
		logout.click();
		
	}
	public String getContactinfo(WebDriver driver,String orgName)
	{
		
		return driver.findElement(By.linkText(orgName)).getText();

	
	
	}
	
}
