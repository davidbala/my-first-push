package com.Vtiger.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author David Bala
 *
 */

public class WebDriverUtils extends BaseTest {

	
	public static String getRandomNum()
	{
		Random rn = new Random();
		int number = rn.nextInt(10000);
		String org_name = "ty_"+number;
		return org_name;
	}
	
	public static void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void waitForElementToClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitAndClick(WebDriver driver ,WebElement element) throws InterruptedException
	{
		int count = 0;
		while (count <=20)
		{
			try {
				element.click();
				break;
			}
			
			catch(Throwable t)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	public static void select(WebElement element, String option)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(option);
	}
	
	public static void select(WebElement element, int optionIndex)
	{
		Select sel = new Select(element);
		sel.selectByIndex(optionIndex);
	}

	public static void moveMouseOnElement(WebElement element , WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();	
	}
	public static void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public static void RejectAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static String parentWin_id ;
	static String childWin_id ;
	
	public static void switchToChildWindow(WebDriver driver)
	{
		Set<String> chwnd = driver.getWindowHandles();
		Iterator<String> i = chwnd.iterator();
		parentWin_id=i.next();
		childWin_id= i.next();
		driver.switchTo().window(childWin_id);
	}
	
	public static void switchToParentWindow(WebDriver driver)
	{
		driver.switchTo().window(parentWin_id);
	}
	
	public static void takeScreenShot(WebDriver driver,String path) {
	try
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File des = new File(PHOTO_PATH);
	FileUtils.copyFile(src, des);
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	}
	
	
	

}

