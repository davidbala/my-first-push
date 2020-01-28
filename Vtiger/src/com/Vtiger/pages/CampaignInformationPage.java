package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	public WebDriver driver;
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement verifyCampaignName;
	
	public CampaignInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCname()
	{
		return verifyCampaignName.getText();
	}
	
	

}
