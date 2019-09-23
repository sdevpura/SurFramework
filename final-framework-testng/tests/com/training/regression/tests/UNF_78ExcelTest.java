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
import com.training.pom.UNF_078POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_78ExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private UNF_078POM UNF_078POM;
	private static Properties properties;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		UNF_078POM  = new UNF_078POM (driver);
		baseUrl = properties.getProperty("baseURL");

		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test(dataProvider = "UNF078excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void UNF078ExcelTest(String userName, String password, String catName, String catMetaTag, String productName, String productMetaTag, String catList) throws InterruptedException{
		UNF_078POM.sendUserName(userName);
		UNF_078POM.sendPassword(password);
		UNF_078POM.clickLoginBtn();
		
		//To add Category
		UNF_078POM.clickCategories();
		UNF_078POM.AddNewCategories(catName, catMetaTag);

		
		//To Add Product
		UNF_078POM.clickProduct();
		UNF_078POM.AddNewProducts(productName, productMetaTag, catList);
	
		}
	
}
