package com.WebOrder;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	static WebDriver driver;

	public static WebDriver crossBrowserTesting(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			// WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static String getScreenshotfailure(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshot_Failure/" + screenshotName + dateName
				+ ".png";
		// String destination = System.getProperty("user.dir") +
		// "/Screenshot_Failure/"+screenshotName+dateName+".mov";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String getScreenshotSuccess(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshot_Success/" + screenshotName + dateName
				+ ".png";
		// String destination = System.getProperty("user.dir") +
		// "/Screenshot_Failure/"+screenshotName+dateName+".mov";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	static // Method to create report.
	ExtentSparkReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void CreateExtentReport(String ReportName, String Browser) {
		System.out.println("Top of Method");
		// htmlreporter = new
		// ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/"+ReportName);
		htmlreporter = new ExtentSparkReporter("./ExtentReport/" + ReportName);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);

		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", Browser);

		htmlreporter.config().setDocumentTitle("Regression Test");
		htmlreporter.config().setReportName(ReportName);
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		System.out.println("Last of Method");
	}
}
