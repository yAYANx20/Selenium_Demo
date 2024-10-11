package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebOrder_Login_DataDrivenTest_using_Excel extends WebOrder_TestData{
	WebDriver driver;

	@Test(dataProvider="LoginExcelData",priority=1)
	public void login(String uname,String pass) {
		driver.findElement(By.name("ctl00$MainContent$username")).clear();
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(uname);
		driver.findElement(By.name("ctl00$MainContent$password")).clear();
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(pass);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterTest
	public void closebrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@BeforeTest
	public void login1() {
		driver = new FirefoxDriver();
		driver.get(
				"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
		driver.manage().window().maximize();
	}
}
