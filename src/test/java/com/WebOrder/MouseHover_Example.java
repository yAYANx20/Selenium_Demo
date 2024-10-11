package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover_Example {
	@Test
	public void MouseHoverYatra() throws InterruptedException
	{
		//WebDriverManager.chromedriver().setup();
		// create Edge instance and maximize it
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get( "https://www.yatra.com/");
		Thread.sleep(3000);
        
		WebElement MyAccount = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		Actions action = new Actions(driver);
        action.moveToElement(MyAccount).perform();
        //driver.findElementById("signInBtn").click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='signInBtn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='login-continue-btn']")).isDisplayed();

	}

}
