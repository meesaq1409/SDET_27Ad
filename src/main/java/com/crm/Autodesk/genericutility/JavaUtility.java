package com.crm.Autodesk.genericutility;


import java.util.Date;
import java.util.Random;

/**
 * 
 * @author meesaq khan
 *
 */
public class JavaUtility {
	
	/**
	 * 
	 * @return
	 */
public int getRandomNum() {
	Random rn=new Random();
	int ran = rn.nextInt(1000);
	
	return ran;
}	
	/**
	 * 
	 * @return
	 */
public String getSystemDateAndTime()

	{
		
		Date date = new Date();
		
		return date.toString();
	}

	public String getSystemDateAndTimeFormat()
	{
		Date date =new Date();
		String day = date.toString();
	String yyyy = day.split(" ")[5];
	String dd = day.split(" ")[2];
	int mm = date.getMonth()+1;
	String finalformat = yyyy+"-"+mm+"-"+dd;
		
		return finalformat;
		
	}
	
}
