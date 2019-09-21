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
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.UNF_076POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_076DBTest {
	private WebDriver driver;
	private String baseUrl;
	private UNF_076POM UNF_076POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		UNF_076POM = new UNF_076POM(driver);
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password, String productName, int quantity) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		
		
		UNF_076POM.sendUserName(userName);		
		UNF_076POM.sendPassword(password);
		UNF_076POM.clickLoginBtn();
		UNF_076POM.findAndSelectOrdersLink("Orders");
		UNF_076POM.editOrder();
		//UNF_076POM.addIP();
		UNF_076POM.refresh();
		UNF_076POM.ScrollPage();
		UNF_076POM.clickContinue();
		UNF_076POM.removeProduct();
		UNF_076POM.enterProduct(productName);
		UNF_076POM.enterQuantity(quantity);
		UNF_076POM.addProduct();
		UNF_076POM.clickContinueCart();
		UNF_076POM.ScrollPage();
		UNF_076POM.clickContinuePayment();
		UNF_076POM.ScrollPage();
		UNF_076POM.clickContinueShipping();
		UNF_076POM.ScrollPage();
		UNF_076POM.selectShippingAdd();
		UNF_076POM.ScrollPage();
		UNF_076POM.save(); 		
		
		screenShot.captureScreenShot(userName);

	}

}