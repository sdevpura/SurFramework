package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.UNF_024POM;

public class TC024ShippingDetailsFilter extends LoginTests {
	
	private UNF_024POM UNF024POMDriver;
	
	@Test(priority=2)	
	public void ShippingDetailsFilterTest() throws InterruptedException{
		UNF024POMDriver = new UNF_024POM(driver);		
		UNF024POMDriver.ClickReports();
		UNF024POMDriver.ClickSales();
		UNF024POMDriver.GetSalesOptions("Orders", "Tax", "Shipping", "Returns", "Coupons");
		UNF024POMDriver.ClickShipping("Shipping Report");
		UNF024POMDriver.SelectOption();
		UNF024POMDriver.clickFilterBtn();
		UNF024POMDriver.ScrollPage();
		UNF024POMDriver.verifyRecords("Showing 61 to 73 of 73 (4 Pages)");
		screenShot.captureScreenShot("ShippingDetailsFilter");
		logger.log(LogStatus.PASS, "Second @Test Method: Product Return List with order details matching filter criteria is displayed");
		
	}
	
	

}
