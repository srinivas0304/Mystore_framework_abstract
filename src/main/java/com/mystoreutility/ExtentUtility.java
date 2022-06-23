package com.mystoreutility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.captureScreenshot.Screenshot;
import com.mystore.base.BaseClass;

public class ExtentUtility extends BaseClass
{
	public static ExtentReports extent;
	public static ExtentTest test;
	//public static WebDriver driver;
	
	public static void extentUtility()
	{
		extent=new ExtentReports();
		File path=new File("Mystoretestcasefail.html");
		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./SparkReports/Mystoretestcasefail.html");
		extent.attachReporter(sparkReport);
	}
	public static void flushMethod()
	{
		extent.flush();
	}
}
