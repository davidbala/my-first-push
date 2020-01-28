package com.Vtiger.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.FileLib;
import com.Vtiger.generic.WebDriverUtils;

public class CreateOrganizationPage {
	WebDriver driver;
	@FindBy(linkText="Organizations")
	private WebElement orgBTN;
	
	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement createOrg;

	
	
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement org_nameField;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public WebElement getOrgModule()
	{
		return orgBTN;
	}
	
	public void clickOnOrganizationsModule()
	{
		orgBTN.click();
	}
	
	public CreateNewOrganizationPage clickOnCreateOrganizationBtn()
	{
		createOrg.click();
		return new CreateNewOrganizationPage(driver);
	}
	/*
	public void createNewOrganization(String name,String ph_Num,String id) throws IOException
	{	
		
		String orgname = WebDriverUtils.getRandomNum();
		
		
		orgName.sendKeys(orgname);
		phoneNum.sendKeys(ph_Num);
		emailId.sendKeys(id);
		selectMember.click();
		WebDriverUtils.switchToChildWindow(driver);
		
		clickSelectList("Organization Name");
		searchMemeber(FileLib.getCommonDatafromProperties("org_Name"));
		selectMemeber();
		
		WebDriverUtils.acceptAlert(driver);
		WebDriverUtils.switchToParentWindow(driver);
		WebDriverUtils.waitForElementToClick(driver, getSaveBtn());
		clickOnSaveBtn();
	}
	
	public void setPhoneNum(String ph_Num)
	{
		phoneNum.sendKeys(ph_Num);
	}
	
	public void setEmailId(String id)
	{
		emailId.sendKeys(id);
	}
	
	public void clickOnAddMember()
	{
		selectMember.click();
	}
	
	public void searchMemeber(String mem)
	{
		searchFor.sendKeys(mem,Keys.ENTER);
	}
	
	public void clickSelectList(String name)
	{
		
		WebDriverUtils.select(selectDropdownList,name );
	}
	
	public void selectMemeber()
	{
		clickOnMemeber.click();
	}
	public WebElement getOrg_nameField() {
		return org_nameField;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	public void clickOnSaveBtn()
	{
		saveBtn.click();
	}
	
	*/
	

}
