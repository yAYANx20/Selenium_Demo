package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class CrossBrowser_Example_Using_BaseClass {
	WebDriver driver;

	@Test()
	public void login_to_app() {
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).clear();
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).clear();
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$login_button']")).click();
		driver.findElement(By.linkText("Logout")).click();

	}

//	@BeforeTest
//	@Parameters({"browser"})
//	public void pre_condition(String browser) throws Exception 
//	{
//		driver = BaseClass.crossBrowserTesting(browser);
//		 driver.manage().window().maximize();
//		 driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
//	}

	@BeforeTest
	@Parameters({ "browser", "url" })
	public void pre_condition(String browser, String url) throws Exception {
		driver = BaseClass.crossBrowserTesting(browser);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterTest
	public void post_condition() {

		driver.quit();
	}
}
