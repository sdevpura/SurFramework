package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.UNF_046POM;

public class TC046EditOrder extends LoginTests {
	
	private UNF_046POM UNF046POMDriver;
	
	@Test(priority=2)
	public void TC046EditOrderTest() throws InterruptedException{
		UNF046POMDriver = new UNF_046POM(driver);
		
		
		UNF046POMDriver.findAndSelectOrdersLink("Orders");
		UNF046POMDriver.editOrder();
		//UNF046POMDriver.addIP();
		UNF046POMDriver.refresh();
		UNF046POMDriver.ScrollPage();
		UNF046POMDriver.clickContinue();
		UNF046POMDriver.removeProduct();
		UNF046POMDriver.enterProduct();
		UNF046POMDriver.enterQuantity();
		UNF046POMDriver.addProduct();
		UNF046POMDriver.clickContinueCart();
		UNF046POMDriver.ScrollPage();
		UNF046POMDriver.clickContinuePayment();
		UNF046POMDriver.ScrollPage();
		UNF046POMDriver.clickContinueShipping();
		UNF046POMDriver.ScrollPage();
		UNF046POMDriver.selectShippingAdd();
		UNF046POMDriver.ScrollPage();
		UNF046POMDriver.save(); 
		
		

		}
	
}
