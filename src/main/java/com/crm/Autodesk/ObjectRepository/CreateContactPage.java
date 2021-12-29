package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericutility.WebdriverUtility;

public class CreateContactPage extends WebdriverUtility {

	@FindBy(name="lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement orgNameLookUpImg;
	
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement orgListBtn;
	
	
	
	@FindBy(xpath="(//input[@name=\"button\"])[1]")
	private WebElement saveBtnOrg;
	
	@FindBy(id = "search_txt")
	private WebElement searchtb;
	@FindBy(name="search")
	private WebElement searchButton;
	
	
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	public WebElement getContactNameEdt() {
		return ContactNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}
	
	

	public WebElement getOrgListBtn() {
		return orgListBtn;
	}
	
	public WebElement getSearchtb() {
		return searchtb;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getSaveBtnOrg() {
		return saveBtnOrg;
	}
	
	public void createCont(String lastname) {
		ContactNameEdt.sendKeys(lastname);
		
		savebtn.click();		
	}
	public void createContAndorg(String lastname) {
		ContactNameEdt.sendKeys(lastname);
		orgListBtn.click();
	}
	public void switchWin(WebDriver driver,String partialWin,String orgName)
	{
		switchToWindow(driver,partialWin );
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
		
	}
	public void saveorg()
	{
		saveBtnOrg.click();
		
	}
		
	
	
}
