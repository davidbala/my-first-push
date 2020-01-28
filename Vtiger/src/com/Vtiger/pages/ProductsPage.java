package com.Vtiger.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtils;

public class ProductsPage {
	
	public WebDriver driver;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@title = 'Create Product...' ]")
	private WebElement createNewProductIcon;
	
	@FindBy(name="search_field")
	private WebElement selectDropDownList;
	
	@FindBy(id="search_txt")
	private WebElement searchForTextBox;
	
	@FindBy(xpath="(//table[@class='small'])[3]/tbody/tr[2]/td[1]/a")
	private WebElement clickOnProduct;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void products()
	{
		productsLink.click();
	}
	
	public CreateNewProductPage createNewProduct()
	{
		createNewProductIcon.click();
		return new CreateNewProductPage(driver);
	}
	
	public void clickOnSelectMenu()
	{
		WebDriverUtils.select(selectDropDownList, "Product Name");
	}
	
	public void searchFor(String name)
	{
		searchForTextBox.sendKeys(name,Keys.ENTER);;
	}
	
	public void clickOnProductName()
	{
		clickOnProduct.click();
	}

	
}
