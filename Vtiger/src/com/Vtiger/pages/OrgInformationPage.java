package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInformationPage {

	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgInfoNameField;
	
	public WebDriver driver;
	public OrgInformationPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String orgName()
	{
		return orgInfoNameField.getText();
		
	}
}
