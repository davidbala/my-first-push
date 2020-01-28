package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtils;

public class CreateNewOrganizationPage {
	
	@FindBy(linkText="Organizations")
	private WebElement orgBTN;
	
	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement createOrg;

	@FindBy(name="accountname")
	private WebElement orgName;
		 
	@FindBy(id="phone")
	private WebElement phoneNum;
	
	@FindBy(id="email1")
	private WebElement emailId;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement selectMember;
	
	@FindBy(id="search_txt")
	private WebElement searchFor;
	
	@FindBy(name="search_field")
	private WebElement selectDropdownList;
	
	@FindBy(xpath="(//table[@class='small'])[3]/tbody/tr[2]/td[1]/a")
	private WebElement clickOnMemeber;
	
	@FindBy(xpath = "//input[@value = '  Save  ']")
	private WebElement saveBtn;
 	
	
	public WebElement getOrgBTN() {
		return orgBTN;
	}

	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getSelectMember() {
		return selectMember;
	}

	public WebElement getSearchFor() {
		return searchFor;
	}

	public WebElement getSelectDropdownList() {
		return selectDropdownList;
	}

	public WebElement getClickOnMemeber() {
		return clickOnMemeber;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}


	public WebDriver driver;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{	this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnOrganizationsModule()
	{
		orgBTN.click();
	}
	
	public void clickOnCreateOrganizationBtn()
	{
		createOrg.click();
	}
	
	public OrgInformationPage createNewOrganization(String name) throws InterruptedException
	{
		orgName.sendKeys(name);
		saveBtn.click();
		return new OrgInformationPage(driver);
	}
	
	//user entering only name,phn,mailid
	public  OrgInformationPage createNewOrganization(String name,String phn,String mail)
	{
		orgName.sendKeys(name);
		phoneNum.sendKeys(phn);
		emailId.sendKeys(mail);		
		return new OrgInformationPage(driver);
	}
	
	//user entering only name and phone no
	public  OrgInformationPage createNewOrganization(String name,String phn)
	{
		orgName.sendKeys(name);
		phoneNum.sendKeys(phn);
		return new OrgInformationPage(driver);
	}
	
	//user entering name,phn,mail and adding a member
	public OrgInformationPage createNewOrganization(String name,String phn,String mail,String addMem)
	{
		orgName.sendKeys(name);
		phoneNum.sendKeys(phn);
		emailId.sendKeys(mail);
		selectMember.click();
		WebDriverUtils.switchToChildWindow(driver);
		OrganizationsWindow ow = new OrganizationsWindow(driver);
		ow.AddMember(addMem);
		WebDriverUtils.switchToParentWindow(driver);
		saveBtn.click();
		return new OrgInformationPage(driver);
	}
	
	
	
	
	
}
	
	



