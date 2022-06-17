package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class HomePageTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
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
	public void wishListTest() throws Throwable
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean res=homePage.validateMyWishList();
//		Assert.assertTrue(res);	
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryTest() throws Throwable
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean res=homePage.validateOrderHistory();
//		Assert.assertTrue(res);
	}
	
}
