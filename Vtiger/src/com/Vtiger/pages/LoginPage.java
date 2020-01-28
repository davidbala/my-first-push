package com.Vtiger.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author David Bala
 *
 */
public class LoginPage {
	
 
	@FindBy(name="user_name")
	private WebElement unTB;
 
	@FindBy(name ="user_password")
	private WebElement pwTB;
	
	@FindBy(id ="submitButton")
	private WebElement loginBtn;
	/**
	 * 
	 * @param driver
	 */

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void enterPassWord(String pwd)
	{
		pwTB.sendKeys(pwd,Keys.ENTER);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
	
}

