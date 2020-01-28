package com.Vtiger.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Vtiger.pages.HomePage;
import com.Vtiger.pages.LoginPage;

/**
 * 
 * @author David Bala
 *
 */

public class BaseTest implements IAutoConstant{
	
	
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	
	public WebDriver driver;
	@BeforeClass(groups= {"Smoke Testing","Regression Testing"})
	@Parameters("browser")
	public void OpenApplication(String browser)  throws IOException
	{
		//String BROWSERNAME =FileLib.getCommonDatafromProperties("browser");  
		String BROWSER = browser;
		System.out.println("-----Launch Browser------");
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	public int Passcount = 0 ,Failcount = 0;
	/*@AfterClass
	public void CloseApplication()
	{
		String tcName = res.getName();
		int status = res.getStatus();
		if(status == 1)
		{
			Passcount++;
			System.out.println("Passcount : " +  Passcount);
		}
		else
		{
			Failcount++;
			System.out.println("FailCount : " + Failcount);
			String proof = PHOTO_PATH+tcName+".png";
			WebDriverUtils.takeScreenShot(driver,proof);
		}
		//Close the Browser
		driver.close();
	}
	*/
	@BeforeMethod(groups= {"Smoke Testing","Regression Testing"})
	public void configBM( ) throws IOException 
	{
		String URL = FileLib.getCommonDatafromProperties("url");
		driver.get(URL);
		String UN = FileLib.getCommonDatafromProperties("username");
		String PWD = FileLib.getCommonDatafromProperties("password");
		System.out.println("Login with Credntials...");
		System.out.println(UN);
		System.out.println(PWD);
		LoginPage lp = new LoginPage(driver);
		WebDriverUtils.waitForElementToLoad(driver);
		lp.enterUserName(UN);
		lp.enterPassWord(PWD);
		lp.clickOnLoginBtn();
		System.out.println("Logged In...");
		
	}
	
	@AfterMethod(groups= {"Smoke Testing","Regression Testing"})
	public void configAM() throws InterruptedException
	{
		System.out.println("LogOut");
		HomePage hp = new HomePage(driver);
		hp.logOut();
	}
	
	@AfterClass(groups= {"Smoke Testing","Regression Testing"})
	public void configAC()
	{
		System.out.println("Close Browser...");
		driver.close();
	}
}
