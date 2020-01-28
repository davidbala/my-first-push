package com.crm.Vtiger.OrganizationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.generic.WebDriverUtils;
import com.Vtiger.pages.CreateNewOrganizationPage;
import com.Vtiger.pages.HomePage;
import com.Vtiger.pages.OrgInformationPage;
import com.Vtiger.pages.OrganizationPage;
import com.Vtiger.pages.OrganizationsWindow;
/**
 * 
 * @author David Bala
 *
 */
public class TestCreateNewOrganizationPageWithMember extends BaseTest{

	@Test(groups="Regression Testing")
	public void createNewOrganization() throws IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		OrganizationPage op = hp.organizationsBtn();
		CreateNewOrganizationPage cnop = op.clickOnCreateOrgBtn();
		FileLib flib = new FileLib();
		String actualData =flib.read_XL_Data(XL_PATH,"organization" , 1, 1);
		System.out.println(actualData);
		OrgInformationPage oip=cnop.createNewOrganization(actualData);
		WebDriverUtils.waitAndClick(driver, hp.getOrganizationsModuleBtn() );
		CreateNewOrganizationPage cnop1 = op.clickOnCreateOrgBtn();
		String name=WebDriverUtils.getRandomNum();
		String mailId = name+"@gmail.com";
		String ph = "123456789";
		String mem = actualData;
		cnop1.createNewOrganization(name, ph, mailId,mem);
		System.out.println(mem);
	}
}
