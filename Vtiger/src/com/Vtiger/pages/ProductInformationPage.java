package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage 
{
	public WebDriver driver;
	
	public ProductInformationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Product Name")
	private WebElement verifyProductName;
	
	public String verifyPName()
	{
		return verifyProductName.getText();
	}	

}
