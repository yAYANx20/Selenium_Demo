package com.assaignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment5 extends TestData {
	WebDriver driver;

	@Test(dataProvider = "Hover_Content")
	public void main(String HC, String value) throws InterruptedException {

		WebElement MyAccount = driver.findElement(By.xpath("(//a[normalize-space()='Computers'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(MyAccount).perform();
		driver.findElement(By.linkText(HC)).click();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='price actual-price' and text()='" + value
				+ "']/ancestor::div[@class='add-info']//input[@class='button-2 product-box-add-to-cart-button']"))
				.click();
		Thread.sleep(5000);

		if (HC == "Desktops") {

			driver.findElement(By.name("product_attribute_74_5_26")).click();

			driver.findElement(By.xpath("(//input[@id='add-to-cart-button-74'])[1]")).click();

		}
		Thread.sleep(5000);
		driver.findElement(By.className("cart-label")).click();
		Thread.sleep(4000);

	}

	@Test(priority = 1)
	public void CartTotal() throws InterruptedException {
		String Act_Val = driver.findElement(By.cssSelector("span[class='product-price order-total'] strong")).getText();
		String Exp_Val = "6390.00";
		Assert.assertEquals(Act_Val, Exp_Val);
	}

	@AfterTest
	public void close() {

		driver.quit();
	}

	@BeforeTest
	public void launch() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.className("email")).sendKeys("darshithtn@gmail.com");
		driver.findElement(By.className("password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		Thread.sleep(4000);

	}

}
