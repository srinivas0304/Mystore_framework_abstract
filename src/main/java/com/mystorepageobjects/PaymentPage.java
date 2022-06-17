package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass
{
	Action action=new Action();
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement payByBankWire;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	WebElement payByCheck;
	
	@FindBy(xpath="//a[@class='home']")
	WebElement scroll;
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPayment() throws Exception
	{
		Thread.sleep(2000);
		action.scrollByVisibilityOfElement(driver, scroll);
		//Action.click(driver, payByBankWire,"//a[contains(text(),'Pay by bank wire')]");
		payByBankWire.click();
		return new OrderSummaryPage();
	}
}
