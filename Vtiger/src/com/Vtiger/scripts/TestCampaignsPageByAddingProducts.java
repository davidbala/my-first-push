package com.Vtiger.scripts;

import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.generic.WebDriverUtils;
import com.Vtiger.pages.CampaignInformationPage;
import com.Vtiger.pages.CampaignsPage;
import com.Vtiger.pages.CreateNewCampaignsPage;
import com.Vtiger.pages.CreateNewProductPage;
import com.Vtiger.pages.HomePage;
import com.Vtiger.pages.ProductInformationPage;
import com.Vtiger.pages.ProductsPage;

/**
 * 
 * @author David Bala
 *
 */
public class TestCampaignsPageByAddingProducts extends BaseTest 
{
	@Test
	public void TestCampaignWithProduct() throws InterruptedException 
	{
		HomePage hp = new HomePage(driver);
		ProductsPage pp = hp.productsBtn();
		CreateNewProductPage cnpp = pp.createNewProduct();	
		WebDriverUtils wbu = new WebDriverUtils();
		FileLib flib = new FileLib();
		String actualPname = flib.read_XL_Data(XL_PATH,"products", 2, 0)+wbu.getRandomNum();
		System.out.println(actualPname);
		ProductInformationPage pip = cnpp.addNewProducts(actualPname);
		CampaignsPage cp = hp.moveToCampaigns();
		CreateNewCampaignsPage cncp = cp.clickOnAddNewCampaignBtn();
		String actualCname =flib.read_XL_Data(XL_PATH, "campaigns", 1, 0);
		System.out.println(actualCname);
		CampaignInformationPage cip = cncp.createNewCampaigns(actualCname, actualPname);
		
			
	}

}
