package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	public WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	protected ScreenShot screenShot;
	public ExtentReports extent;
	public ExtentTest logger;	
	
	@BeforeTest
	public void CaptureReports(){
			
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReports/UNF_024.html", true); //to set the output for reports
		extent.loadConfig(new File((System.getProperty("user.dir"))+"extent-config.xml"));
		logger = extent.startTest("CaptureReports");
		logger.log(LogStatus.PASS, "Before Test logger: Logger initialization");
	}

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger.log(LogStatus.PASS, "Before Class Logger: URL opened");
		
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger.log(LogStatus.PASS, "After Class logger: Driver Close");
	}
	
	@Test(priority=1)
	public void validLoginTest(){
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Login");		
		logger.log(LogStatus.PASS, "Login successful");

		
	}
	
	@AfterTest
	public void closeReports(){
		extent.endTest(logger);
		extent.flush();
		extent.close();
		logger.log(LogStatus.PASS, "AfterTest Logger: Close reports resources");
	}
}
