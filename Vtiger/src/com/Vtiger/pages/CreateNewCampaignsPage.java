package com.Vtiger.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtils;

public class CreateNewCampaignsPage {
	
	public WebDriver driver;
	@FindBy(xpath ="//img[@title='Create Campaign...']")
	private WebElement AddnewCampaign;
	
	@FindBy(name="campaignname")
	private WebElement cName;
	
	@FindBy(xpath = "//input[@value='U']")
	private WebElement groupRadioBtn;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement userRadioBtn;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement selectProduct;
	
	@FindBy(id="search_txt")
	private WebElement searchFor;
	
	@FindBy(name="search_field")
	private WebElement selectDropdownList;
	
	@FindBy(xpath="(//table[@class='small'])[3]/tbody/tr[2]/td[1]/a")
	private WebElement clickOnProduct;
	
	@FindBy(id="targetsize")
	private WebElement targetSizeTxtBox;
	
	@FindBy(xpath = "//input[@value = '  Save  ']")
	private WebElement saveBtn;
	
	public CreateNewCampaignsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void addCampaign(String cN)
	{
		cName.sendKeys(cN);;
	}
	
	public void clickOnGroupRadioBtn()
	{
		groupRadioBtn.click();
	}
	public void clickOnRadioBtn()
	{
		groupRadioBtn.click();
	}
	
	public void clickOnAddProduct() 
	{
		selectProduct.click();
	}
	
	public void searchMemeber(String mem)
	{
		searchFor.sendKeys(mem,Keys.ENTER);
	}
	
	public void clickSelectList(String name)
	{
		WebDriverUtils.select(selectDropdownList, name);
	}
	
	public void selectProduct()
	{
		clickOnProduct.click();
	}
	
	@FindBy(id="numsent")
	private WebElement numMailsent;
	
	public void enterTargetSize(String targetSize)
	{
		targetSizeTxtBox.sendKeys(targetSize);
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn.click();
	}
	//getter methods
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getAddnewCampaign() {
		return AddnewCampaign;
	}
	public WebElement getcName() {
		return cName;
	}
	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}
	public WebElement getUserRadioBtn() {
		return userRadioBtn;
	}
	public WebElement getSelectProduct() {
		return selectProduct;
	}
	public WebElement getSearchFor() {
		return searchFor;
	}
	public WebElement getSelectDropdownList() {
		return selectDropdownList;
	}
	public WebElement getClickOnProduct() {
		return clickOnProduct;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public CampaignInformationPage createNewCampaigns(String name)
	{
		cName.sendKeys(name);
		groupRadioBtn.click();
		clickOnSaveBtn();
		return new CampaignInformationPage(driver);
	}
	public CampaignInformationPage createNewCampaigns(String name,String addProduct)
	{
		cName.sendKeys(name);
		groupRadioBtn.click();
		clickOnAddProduct();
		WebDriverUtils.switchToChildWindow(driver);
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnSelectMenu();
		pp.searchFor(addProduct);
		pp.clickOnProductName();
		WebDriverUtils.switchToParentWindow(driver);
		clickOnSaveBtn();
		return new CampaignInformationPage(driver);
				
	}
	public CampaignInformationPage createNewCampaigns(String name,String numMailSent,String ts)
	{
		cName.sendKeys(name);
		groupRadioBtn.click();
		targetSizeTxtBox.sendKeys(ts);
		numMailsent.sendKeys(numMailSent);
		clickOnSaveBtn();
		return new CampaignInformationPage(driver);
	}
	
}
