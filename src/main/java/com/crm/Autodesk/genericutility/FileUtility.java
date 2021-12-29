package com.crm.Autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author meesaq khan
 *
 */
public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return properties file
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		
		return value;
		
	}
}
