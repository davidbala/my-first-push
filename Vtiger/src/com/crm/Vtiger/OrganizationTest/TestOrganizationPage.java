package com.crm.Vtiger.OrganizationTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.generic.WebDriverUtils;
import com.Vtiger.pages.CreateNewOrganizationPage;
import com.Vtiger.pages.CreateOrganizationPage;
import com.Vtiger.pages.HomePage;
import com.Vtiger.pages.OrgInformationPage;
import com.Vtiger.pages.OrganizationPage;

public class TestOrganizationPage extends BaseTest {
	
	@Test(groups="Smoke Testing")
	public void CreateOrganization() throws IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		OrganizationPage op = hp.organizationsBtn();
		CreateNewOrganizationPage cnop = op.clickOnCreateOrgBtn();
		WebDriverUtils wdu=new WebDriverUtils();
		FileLib flib = new FileLib();
		String actualData =flib.read_XL_Data(XL_PATH,"organization" , 1, 1)+wdu.getRandomNum();
		System.out.println(actualData);
		OrgInformationPage oip=cnop.createNewOrganization(actualData);
		String expectedData=oip.orgName();
		Assert.assertEquals(actualData,expectedData);
		
	}

}
