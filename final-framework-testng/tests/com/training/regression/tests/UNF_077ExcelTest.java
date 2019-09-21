package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.UNF_077POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_077ExcelTest {
	public WebDriver driver;
	private String baseUrl;
	private UNF_077POM UNF_077POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		UNF_077POM = new UNF_077POM(driver);
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void UNF077ExcelTest(String userName, String password, String productName, String quantity) throws InterruptedException {
		UNF_077POM.sendUserName(userName);
		UNF_077POM.sendPassword(password);
		UNF_077POM.clickLoginBtn();
		UNF_077POM.findAndSelectOrdersLink("Orders");
		UNF_077POM.editOrder();
		//UNF_076POM.addIP(); //Kindly Add IP. Not handled in code
		UNF_077POM.refresh();
		UNF_077POM.ScrollPage();
		UNF_077POM.clickContinue();
		UNF_077POM.removeProduct();
		UNF_077POM.enterProduct(productName);
		UNF_077POM.enterQuantity(quantity);
		UNF_077POM.addProduct();
		UNF_077POM.clickContinueCart();
		UNF_077POM.ScrollPage();
		UNF_077POM.clickContinuePayment();
		UNF_077POM.ScrollPage();
		UNF_077POM.clickContinueShipping();
		UNF_077POM.ScrollPage();
		UNF_077POM.selectShippingAdd();
		UNF_077POM.ScrollPage();
		UNF_077POM.save(); 		
		
		screenShot.captureScreenShot(userName);
	}

}