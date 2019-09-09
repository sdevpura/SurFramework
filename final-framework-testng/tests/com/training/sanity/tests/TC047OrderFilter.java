package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.UNF_047POM;

public class TC047OrderFilter extends LoginTests {
	private UNF_047POM UNF047POMDriver;
	
	@Test(priority=2)
	public void TC047OrderFilterTest() throws InterruptedException{
		UNF047POMDriver = new UNF_047POM(driver);
		//Filter By Order ID
		UNF047POMDriver.clickOrders();
		UNF047POMDriver.enterOrderID("355");
		UNF047POMDriver.clickFilterBtn();
		UNF047POMDriver.verifyFilterByOrderID("355");
		screenShot.captureScreenShot("Order ID verified");
		logger.log(LogStatus.PASS, "Order filtered by 'orderid'");
		UNF047POMDriver.clearFilters("");
		
		//Filter by Order Status
		UNF047POMDriver.selectOrderStatus("Pending");
		UNF047POMDriver.clickFilterBtn();
		UNF047POMDriver.verifyFilterbyOrderStatus();
		screenShot.captureScreenShot("Order Status verified");
		logger.log(LogStatus.PASS, "Order filtered by 'order Status'");
		UNF047POMDriver.clearFilters("");
		
		//Filter by Date Added
		UNF047POMDriver.selectDateAdded(); //Add date as 2018-02-18
		UNF047POMDriver.clickFilterBtn();
		UNF047POMDriver.verifyFilterbyDateAdded();
		screenShot.captureScreenShot("Date Added verified");
		logger.log(LogStatus.PASS, "Order filtered by 'Date Added' filter");
		UNF047POMDriver.clearFilters("");
		
		//Filter by Customer Name
		UNF047POMDriver.enterCustomer("Neha B"); 
		UNF047POMDriver.clickFilterBtn();
		UNF047POMDriver.verifyFilterbyCustomer("Neha B");
		screenShot.captureScreenShot("Customer verified");
		logger.log(LogStatus.PASS, "Order filtered by 'Customer' filter");
		UNF047POMDriver.clearFilters("");
		
		//Filter by Total
		UNF047POMDriver.enterTotal("600");
		UNF047POMDriver.clickFilterBtn();
		UNF047POMDriver.verifyFilterbyTotal("600");
		screenShot.captureScreenShot("Customer verified");
		logger.log(LogStatus.PASS, "Order filtered by 'Total' filter");
		UNF047POMDriver.clearFilters("");
		
		//Filter by Date Modified
		UNF047POMDriver.selectDateModified();; //Add date as 2018-02-18
		UNF047POMDriver.clickFilterBtn();
		UNF047POMDriver.verifyFilterbyDateModified();
		screenShot.captureScreenShot("Date Modified verified");
		logger.log(LogStatus.PASS, "Order filtered by 'Date Modified' filter");
		UNF047POMDriver.clearFilters("");
		
		
		
	}
			
}
