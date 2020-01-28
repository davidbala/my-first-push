package com.crm.Vtiger.OrganizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.pages.CreateNewOrganizationPage;
import com.Vtiger.pages.HomePage;
import com.Vtiger.pages.OrgInformationPage;
import com.Vtiger.pages.OrganizationPage;

public class TestOrganizationPageWithPhoneNumber extends BaseTest 
{
	@Test(groups="Regression Testing")
	public void TestOrgPageWithPhnNo() throws InterruptedException
	{
	HomePage hp = new HomePage(driver);
	OrganizationPage op = hp.organizationsBtn();
	CreateNewOrganizationPage cnop = op.clickOnCreateOrgBtn();
	FileLib flib = new FileLib();
	String actualData =flib.read_XL_Data(XL_PATH,"organization" , 1, 1);
	String phn = flib.read_XL_Data(XL_PATH, "organization", 1, 2);
	System.out.println(actualData);
	OrgInformationPage oip=cnop.createNewOrganization(actualData,phn);
	String expectedData=oip.orgName();
	Assert.assertEquals(actualData,expectedData);
}
}
