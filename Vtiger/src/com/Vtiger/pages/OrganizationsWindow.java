package com.Vtiger.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtils;

public class OrganizationsWindow {
	
	@FindBy(id="search_txt")
	private WebElement searchForField;
	
	@FindBy(name="search_field")
	private WebElement selectDropListMenu;
	
	@FindBy(xpath="(//table[@class='small'])[3]/tbody/tr[2]/td[1]/a")
	private WebElement clickOnMember;
		
	public WebDriver driver;
	public OrganizationsWindow(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchForField() {
		return searchForField;
	}
	public WebElement getSelectDropListMenu() {
		return selectDropListMenu;
	}
	public WebElement getClickOnMember() {
		return clickOnMember;
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	public void AddMember(String dValue)
	{
		WebDriverUtils.select(selectDropListMenu,"Organization Name" );
		searchForField.sendKeys(dValue,Keys.ENTER);
		clickOnMember.click();		
		WebDriverUtils.acceptAlert(driver);
	}
	
	

	
}
