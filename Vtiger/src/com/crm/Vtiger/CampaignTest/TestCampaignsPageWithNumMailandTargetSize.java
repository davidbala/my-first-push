package com.crm.Vtiger.CampaignTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.pages.CampaignInformationPage;
import com.Vtiger.pages.CampaignsPage;
import com.Vtiger.pages.CreateNewCampaignsPage;
import com.Vtiger.pages.HomePage;

public class TestCampaignsPageWithNumMailandTargetSize extends BaseTest
{
	@Test(groups="Regression Testing")
	public void CampaignsPage() throws IOException, InterruptedException
	{

		HomePage hp = new HomePage(driver);
		CampaignsPage cp = hp.moveToCampaigns();
		CreateNewCampaignsPage cncp = cp.clickOnAddNewCampaignBtn();
		FileLib flib = new FileLib();
		String actualCname =flib.read_XL_Data(XL_PATH, "campaigns", 1, 0);
		System.out.println(actualCname);
		CampaignInformationPage cip = cncp.createNewCampaigns(actualCname,"50","123456789");
		String expectedCname=cip.verifyCname();
		Assert.assertEquals(actualCname, expectedCname);		
	}

}
