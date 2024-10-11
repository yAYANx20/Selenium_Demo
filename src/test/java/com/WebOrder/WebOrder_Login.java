package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class WebOrder_Login {
	WebDriver driver;
	@Test(priority=1)
	public void login() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(2000);
		String actvalue = driver.findElement(By.tagName("h2")).getText();
		String expvalue = "List of All Orders";
		Assert.assertEquals(actvalue, expvalue);
		
		String ExpTitle = "Web Orders";
		String ActTitle	= driver.getTitle();
		Assert.assertEquals(ExpTitle, ActTitle);
		driver.findElement(By.linkText("Logout")).isDisplayed();
	}
	
	@Test(priority=2)
	public void logout() throws InterruptedException{
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.name("ctl00$MainContent$login_button")).isDisplayed();
	}
	
	@AfterTest
	public void closebrowser() {
		driver.quit();
	}
	
}
