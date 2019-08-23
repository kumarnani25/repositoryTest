package Testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class orangehrm {
	
	public WebDriver driver;
	
	@Test
	public void test2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium java workspace\\practiseproject\\src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.close();
		
		
		
	}

}
