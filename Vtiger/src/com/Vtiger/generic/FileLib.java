package com.Vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib implements IAutoConstant
{
	//Fetch data from Excel workbook
	public static String read_XL_Data(String path ,String sheet, int rn , int cn)
	{
		
		String data = "";
		try 
		{
		Workbook wb = WorkbookFactory.create(new FileInputStream(XL_PATH));
		data = wb.getSheet(sheet).getRow(rn).getCell(cn).toString();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return data;
	}
	
	//fetch data from Property file from dataResource folder
	
	public static String getCommonDatafromProperties(String key) throws IOException
	{
		FileInputStream fisObj = new FileInputStream("./dataResource/commonData.properties");
		Properties pObj = new Properties();
				   pObj.load(fisObj);
		String value =pObj.getProperty(key);
		return value;
	}
	

}
