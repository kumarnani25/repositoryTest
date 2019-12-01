package Testscripts;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;

public class invokebrowser {
	public WebDriver driver;
	public ExtentTest logger;
	public ExtentReports rep;
	public ExtentHtmlReporter ht;
	
	
	
	
	
	
	
	
	@BeforeSuite
	public void html()
	{
		
		 ht=new ExtentHtmlReporter(".\\Reports\\appbuilder.html");
     	 rep=new ExtentReports();
	    rep.attachReporter(ht);
	
	}
	
	
	
	
	
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium java workspace\\practiseproject\\src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		logger=rep.createTest("Name");
		driver.get("https://google.com");
		logger.log(Status.PASS, "Page is invoked");
	}
	
	
	
	@AfterMethod
	public void test321(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, result.getThrowable());
			logger.fail("fialed", MediaEntityBuilder.createScreenCaptureFromPath("").build());
		}
	}
	
	
	
	@AfterTest
	public void test1()
	{
	driver.close();	
	}
	
	@AfterSuite
	public void test321()
	{
		rep.flush();
	}

}
