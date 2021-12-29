package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AddProject {
public static void main(String[] args) throws SQLException {
	String expectedresult="meesaq nabi";
//	WebDriver driver=new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.get("http://localhost:8084/");
//	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
//	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
//	driver.findElement(By.xpath("//button[text()=\"Sign in\"]")).click();
//	driver.findElement(By.linkText("Projects")).click();
//	driver.findElement(By.xpath("//span[text()=\"Create Project\"]")).click();
//	driver.findElement(By.name("projectName")).sendKeys("testyantra7");
//	driver.findElement(By.name("createdBy")).sendKeys("Adarsh Sir");
//	WebElement status = driver.findElement(By.xpath("(//select[@name=\"status\"])[2]"));
//	
//	Select s=new Select(status);
//	s.selectByValue("On Going");
//	driver.findElement(By.xpath("//input[@type=\"submit\"]")).submit();
//	
//	driver.quit();
//	
	
	Connection connection=null;
	try {
	Driver driverdb = new Driver();
	
	
	DriverManager.registerDriver(driverdb);
	
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	Statement statement = connection.createStatement();
	
	ResultSet querry = statement.executeQuery("select* from project");
	
	while(querry.next())
		
	{
		System.out.println(querry.getString(1)+"\t"+querry.getString(2)+"\t"+querry.getString(3)+"\t"+querry.getString(4)+"\t"+querry.getString(5)+"\t");
		if(querry.getString(2).equals(expectedresult))
			System.out.println("test case passed==>  Adarsh sir present");
	}}
	finally {
	
	connection.close();
	}

}

}
