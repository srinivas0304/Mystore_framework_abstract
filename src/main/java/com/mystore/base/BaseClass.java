package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	Action action=new Action();
	public static Properties prop;
	public static WebDriver driver;	
	
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig()
	{
		
		try
		{
			prop=new Properties();
			//System.out.println("Super constructor invoked");
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\Config\\config.properties");
			prop.load(fs);
		}
		catch(FileNotFoundException a)
		{
			a.printStackTrace();
		}
		catch(IOException b)
		{
			b.printStackTrace();
		}
	}
	
	public  void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.imlicitWait(driver, 10);
		driver.get(prop.getProperty("url"));
	}
	
}
