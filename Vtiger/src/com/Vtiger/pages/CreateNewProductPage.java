package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	
	public WebDriver driver;
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@title = 'Create Product...' ]")
	private WebElement createNewProductIcon;
	
	@FindBy(name="productname")
	private WebElement pName;
	
	@FindBy(xpath = "//input[@value = '  Save  ']")
	private WebElement saveBtn;
	
	@FindBy(id="productsheet")
	private WebElement prodSheet;
	
	@FindBy(id="productcode")
	private WebElement prodCode;
	
	public  CreateNewProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getProductsMod()
	{
		return productsLink;
	}
	public void products()
	{
		productsLink.click();
	}

	public void addProduct(String pname)
	{
		pName.sendKeys(pname);
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn.click();
	}
	
//getter methods
	
	public WebElement getProductsLink() {
		return productsLink;
	}
	public WebElement getCreateNewProductIcon() {
		return createNewProductIcon;
	}
	public WebElement getpName() {
		return pName;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public ProductInformationPage addNewProducts(String pname)
	{
		pName.sendKeys(pname);
		clickOnSaveBtn();
		return new ProductInformationPage(driver);
	}
	
	public ProductInformationPage addNewProducts(String pname,String productCode)
	{
		pName.sendKeys(pname);
		prodCode.sendKeys(productCode);
		clickOnSaveBtn();
		return new ProductInformationPage(driver);
	}
	
	public ProductInformationPage addNewProducts(String pname,String productCode,String productSheet)
	{
		pName.sendKeys(pname);
		prodCode.sendKeys(productCode);
		prodSheet.sendKeys(productSheet);
		clickOnSaveBtn();
		return new ProductInformationPage(driver);
	}
	
}

