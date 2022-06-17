package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchResult;
	
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup()
	{
		launchBrowser();
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void productAvalabiltyTest() throws Exception
	{
		indexPage=new IndexPage();
		searchResult=indexPage.searchProduct("shirt");
		boolean res=searchResult.isProductAvailable();
		Assert.assertTrue(res);
		searchResult.clickOnProduct();
	}
}
