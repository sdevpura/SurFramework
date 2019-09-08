package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.UNF_018POM;

public class TC018ReturnProductFilter extends LoginTests{
	

	private UNF_018POM UNF018POMDriver;

	

	@Test(priority=2)
	public void ReturnProductFilterTest() throws InterruptedException{
		
		
		UNF018POMDriver = new UNF_018POM(driver);
				//1. Click on cart icon 
		UNF018POMDriver.clickcartIcon();
				//2. Click on Product Returns link
		UNF018POMDriver.clickReturn();
				//3. Enter ReturnID
		UNF018POMDriver.enterReturnID("235");
				//3. Click Filter button
		UNF018POMDriver.clickFilterBtn();
				//4. Check Return ID filtered
		UNF018POMDriver.checkReturnID("235");
				//5. Enter return id and Customer name
		UNF018POMDriver.enterReturnID("235");
		Thread.sleep(3000);
		UNF018POMDriver.EnterCustomerName("Sonam Dutta");
		Thread.sleep(3000);
				//6. Click Filter button
		UNF018POMDriver.clickFilterBtn();
				//7. Verify product record matches filter criteria
		UNF018POMDriver.checkProduct("235", "Sonam Dutta");
		screenShot.captureScreenShot("FilteredProducts");
		logger.log(LogStatus.PASS, "Second @Test Method: Product Return List with order details matching filter criteria is displayed");

		}

}
