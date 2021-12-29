package com.crm.Autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * 
 * @author meesaq khan
 *
 */
public class WebdriverUtility {

	/**
	 * 
	 * @param driver
	 */
	public void getPageForToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
	}
	/**
	 * 
	 * @param driver
	 */
	public void getPageForToLoadJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	
	public void waitElementToBeClickable(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	/**
	 * 
	 * @param driver
	 * @param ele
	 * @param pollingtime
	 * @throws InterruptedException
	 */
	public void waitElementWithCustomTimeout(WebDriver driver,WebElement ele ,int pollingtime) throws InterruptedException {
		
		FluentWait fwait=new FluentWait(driver);
		fwait .pollingEvery(pollingtime,TimeUnit.SECONDS);
		
		fwait.wait(20);
		fwait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToPopupAndcancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String currentwindow = driver.getTitle();
			
			if(currentwindow.equals(partialWindowTitle)){
				break;
			}
					
		}
		
}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void switchToFrame(WebDriver driver,String id_name)
	{
		driver.switchTo().frame(id_name);
	}
	/**
	public void select(WebElement ele,int index)
	{
		Select s =new Select(ele);
		s.selectByIndex(index);
	}
	/**
	 * 
	 * @param ele
	 * @param text
	 */
	public void select(WebElement ele,String text)
	{
		Select s =new Select(ele);
		s.selectByVisibleText(text);
	
	}
	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement ele )
	
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param ele
	 */
public void rightClick(WebDriver driver,WebElement ele )
	
	{
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
/**
 * 
 * @param driver
 * @param javaScript
 */

public void executeJavaScript(WebDriver driver,String javaScript)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeAsyncScript(javaScript, null);
}
/**
 * 
 * @param driver
 * @param screenshotName
 * @throws Throwable 
 */
public void takeScreenShot(WebDriver driver,String screenshotName) throws Throwable {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest= new File("./screenshot/"+screenshotName+".PNG") ;
	Files.copy(src, dest);
}

public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
}

