package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtils;
/**
 * 
 * @author David Bala
 *
 */

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{	this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="query_string")
	private WebElement searchbar;
	
	@FindBy(xpath ="//img//[@sr='themes/softed/images/Home.PNG']")
	private WebElement homeBtn;
	
	@FindBy(linkText="Calendar")
	private WebElement calenderModuleBtn;
	
	@FindBy(linkText="Leads")
	private WebElement leadsModuleBtn;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsModuleBtn;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsModuleBtn;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesModuleBtn;
	
	@FindBy(linkText="Products")
	private WebElement productsModuleBtn;
	
	@FindBy(linkText="Documents")
	private WebElement documentsModuleBtn;
	
	@FindBy(linkText="Email")
	private WebElement emailModuleBtn;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsModuleBtn;
	
	@FindBy(linkText="Dashboard")
	private WebElement dashboardModuleBtn;
	
	@FindBy(linkText ="More")
	private WebElement moreBtn;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement settingsImg;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement helpImg;
		
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	public void homeBtn()
	{
		homeBtn.click();
	}
	
	public void orgModule()
	{
		organizationsModuleBtn.click();
	}
	
	public void calenderBtn()
	{
		calenderModuleBtn.click();
	}
	
	public void leadsBtn()
	{
		leadsModuleBtn.click();
	}
	
	public OrganizationPage organizationsBtn()
	{
		organizationsModuleBtn.click();
		return new OrganizationPage(driver);
	}
	
	public void contactsBtn()
	{
		contactsModuleBtn.click();
	}
	
	public void opportunitiesBtn()
	{
		opportunitiesModuleBtn.click();
	}
	
	public ProductsPage productsBtn()
	{
		productsModuleBtn.click();
		return new ProductsPage(driver);
	}
	
	public void documentsBtn()
	{
		documentsModuleBtn.click();
	}
	
	public void emailBtn()
	{
		emailModuleBtn.click();
	}
	
	public void troubleTicketsBtn()
	{
		troubleTicketsModuleBtn.click();
	}
	
	public void dashboardBtn()
	{
		dashboardModuleBtn.click();
	}
	
	public void adminImg()
	{
		signoutlink.click();
	}
	//getter method
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchbar() {
		return searchbar;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getCalenderModuleBtn() {
		return calenderModuleBtn;
	}

	public WebElement getLeadsModuleBtn() {
		return leadsModuleBtn;
	}

	public WebElement getOrganizationsModuleBtn() {
		return organizationsModuleBtn;
	}

	public WebElement getContactsModuleBtn() {
		return contactsModuleBtn;
	}

	public WebElement getOpportunitiesModuleBtn() {
		return opportunitiesModuleBtn;
	}

	public WebElement getProductsModuleBtn() {
		return productsModuleBtn;
	}

	public WebElement getDocumentsModuleBtn() {
		return documentsModuleBtn;
	}

	public WebElement getEmailModuleBtn() {
		return emailModuleBtn;
	}

	public WebElement getTroubleTicketsModuleBtn() {
		return troubleTicketsModuleBtn;
	}

	public WebElement getDashboardModuleBtn() {
		return dashboardModuleBtn;
	}	

	public void searchBox()
	{
		searchbar.click();
	}
	
	public CampaignsPage moveToCampaigns() throws InterruptedException
	{
		WebDriverUtils.moveMouseOnElement(moreBtn, driver);
		campaignsLink.click();
		return new CampaignsPage(driver);
	}
	
	
	
	
	public void logOut() throws InterruptedException
	{
		WebDriverUtils.waitAndClick(driver, adminImg);
		WebDriverUtils.moveMouseOnElement(adminImg,driver);
		signoutlink.click();
	}
	

}
