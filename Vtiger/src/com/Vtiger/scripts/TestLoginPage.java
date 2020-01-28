package com.Vtiger.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.generic.WebDriverUtils;
import com.Vtiger.pages.LoginPage;

public class TestLoginPage extends BaseTest
{
	@Test
	public void validLoginPage() throws IOException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(FileLib.getCommonDatafromProperties("UN"));
		lp.enterPassWord(FileLib.getCommonDatafromProperties("PWD"));
		lp.clickOnLoginBtn();
	}

}
