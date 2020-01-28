package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Search.gif']")
	private WebElement searchOrgBtn;
	
	@FindBy(xpath = "//input[@type='text'])")
	private WebElement searchForTxtBox;
	
	@FindBy(id = "bas_searchfield")
	private WebElement dropDownListBox;
	
	public WebDriver driver; 
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CreateNewOrganizationPage clickOnCreateOrgBtn()
	{
		createOrgBtn.click();
		return new CreateNewOrganizationPage(driver);
		
	}
	
	
	

}
