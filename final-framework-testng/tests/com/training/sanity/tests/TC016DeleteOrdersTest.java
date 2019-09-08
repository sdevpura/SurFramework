package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.UNF_016POM;

public class TC016DeleteOrdersTest extends LoginTests{
	
	//private LoginTests loginTests;
	private UNF_016POM UNF016POMDriver;
	//private WebDriver driver;
	

	@Test(priority=2)
	public void DeleteOrdersTest() throws InterruptedException{
		
		
		UNF016POMDriver = new UNF_016POM(driver);
				//1. Click on Orders icon 
		UNF016POMDriver.clickcartIcon();
				//2. Click on Orders link
		UNF016POMDriver.clickOrders();
				//3. Click on Check box of the order to delete	
		UNF016POMDriver.getOrderID("355");
		
		UNF016POMDriver.clickCheckBox();
				Thread.sleep(3000);
				//4. Click on Delete Icon
		UNF016POMDriver.clickDeleteBtn();
				//5. click on Ok button of Alert	
		UNF016POMDriver.handleAlert();		
		driver.navigate().refresh();
		Thread.sleep(3000);
		UNF016POMDriver.VerifyOrderDeleted("355");
		screenShot.captureScreenShot("Deleted Orders");
		logger.log(LogStatus.PASS, "Second @Test Method: Order Deleted successfully");
		}

		
	}



