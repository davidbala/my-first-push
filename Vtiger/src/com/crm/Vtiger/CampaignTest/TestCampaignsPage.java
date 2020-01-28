package com.crm.Vtiger.CampaignTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.generic.WebDriverUtils;
import com.Vtiger.pages.CampaignInformationPage;
import com.Vtiger.pages.CampaignsPage;
import com.Vtiger.pages.CreateNewCampaignsPage;
import com.Vtiger.pages.CreateNewCampaignsPage;
import com.Vtiger.pages.HomePage;

public class TestCampaignsPage extends BaseTest {
	
	@Test(groups="Smoke Testing")
	public void CampaignsPage() throws IOException, InterruptedException
	{

		HomePage hp = new HomePage(driver);
		CampaignsPage cp = hp.moveToCampaigns();
		CreateNewCampaignsPage cncp = cp.clickOnAddNewCampaignBtn();
		WebDriverUtils wdu = new WebDriverUtils();
		FileLib flib = new FileLib();
		String actualCname =flib.read_XL_Data(XL_PATH, "campaigns", 1, 0)+wdu.getRandomNum();
		System.out.println(actualCname);
		CampaignInformationPage cip = cncp.createNewCampaigns(actualCname);
		String expectedCname=cip.verifyCname();
		Assert.assertEquals(actualCname, expectedCname);		
	}
}
