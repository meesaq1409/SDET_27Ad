package com.crm.Autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author meesaq khan
 *
 */
public class ExcelUtility {
/**
 * 
 * @param Sheetname
 * @param row
 * @param column
 * @return the  data from excel sheet
 * @throws Throwable 
 */


public String getDataFromExcelSheet(String Sheetname,int row,int column) throws Throwable
{
	FileInputStream fis =new FileInputStream("./data/dataindusrty.xlsx");
	Workbook wb=WorkbookFactory.create(fis); 
	String data = wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
	wb.close();
	return data;
	
}
}
