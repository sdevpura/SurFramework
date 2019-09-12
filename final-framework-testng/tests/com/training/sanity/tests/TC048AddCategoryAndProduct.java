package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.UNF_048POM;

public class TC048AddCategoryAndProduct extends LoginTests {
	
	private UNF_048POM UNF048POMDriver;
	
	@Test(priority=2)
	public void TC048AddCategoryAndProductTest() throws InterruptedException{
		UNF048POMDriver = new UNF_048POM(driver);	
		
		//To add Category
		UNF048POMDriver.clickCategories();
		UNF048POMDriver.AddNewCategories();
		screenShot.captureScreenShot("AddCategory");
		logger.log(LogStatus.PASS, "Category added successfully");
		
		//To Add Product
		UNF048POMDriver.clickProduct();
		UNF048POMDriver.AddNewProducts();
		logger.log(LogStatus.PASS, "Product added successfully");
		}
	
}
