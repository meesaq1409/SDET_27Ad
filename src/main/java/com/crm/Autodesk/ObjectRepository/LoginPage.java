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
public class LoginPage {

	//step 1: create separaate class
	
	
	//step2:identify all the webelements
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordedt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//step 3: initialization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//step 4: Bussiness library
	public void getLoginInfo(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordedt.sendKeys(password);
		loginbtn.click();
	}
	
	
	
}
