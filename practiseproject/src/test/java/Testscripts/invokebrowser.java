package Testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class invokebrowser {
	
	public WebDriver driver;
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium java workspace\\practiseproject\\src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://google.com");
	}
	
	@AfterTest
	public void test1()
	{
	driver.close();	
	}

}
