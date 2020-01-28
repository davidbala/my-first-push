package com.Vtiger.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.generic.BaseTest;
import com.Vtiger.generic.FileLib;
import com.Vtiger.pages.CreateNewProductPage;
import com.Vtiger.pages.HomePage;
import com.Vtiger.pages.ProductInformationPage;
import com.Vtiger.pages.ProductsPage;

public class TestProductsPage extends BaseTest {
	
	@Test
	public void TestProductPage() throws IOException, InterruptedException
	{
		
		HomePage hp = new HomePage(driver);
		ProductsPage pp = hp.productsBtn();
		CreateNewProductPage cnpp = pp.createNewProduct();	
		FileLib flib = new FileLib();
		String actualPname = flib.read_XL_Data(XL_PATH,"products", 2, 0);
		System.out.println(actualPname);
		ProductInformationPage pip = cnpp.addNewProducts(actualPname);
		String expectedPNmae = pip.verifyPName();
		Assert.assertEquals(actualPname, expectedPNmae);

	}

}
