package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UNF_018POM {
private WebDriver driver; 
	
	public UNF_018POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
		//TC UNF_018 elements
	
		@FindBy(xpath="//*[@id='sale']/a/i")
		private WebElement cartIcon; 
		
		@FindBy(xpath="//*[@id='sale']/ul/li[3]/a")
		private WebElement returnLink; 

		@FindBy(id="input-return-id")
		private WebElement ReturnIDBox; 
		
		@FindBy(id="input-customer")
		private WebElement CustID; 
		
		@FindBy(id="button-filter")
		private WebElement filterBtn;
		
		@FindBy(id="input-model")
		private WebElement model;
		
		@FindBy(xpath="//table/tbody/tr/td[2]")
		private WebElement ReturnIDActual;
		
		
		@FindBy(xpath="//table/tbody/tr/td[4]")
		private WebElement CustomerIDActual;
	


	//TC UNF_018 methods
		
		public void clickcartIcon() {
			this.cartIcon.click();
		}
		
		
		public void clickReturn() {
			this.returnLink.click(); 
		}
		
		public void enterReturnID(String returnID){
			this.ReturnIDBox.clear();
			this.ReturnIDBox.sendKeys(returnID);
			}
		
		public void enterCustomerName(String customerID){
			this.CustID.clear();
			this.CustID.sendKeys(customerID);
			}
		
		
		
		public void EnterCustomerName(String customerID){
			String CIDAct = this.CustomerIDActual.getText();
			this.CustID.clear();
			this.CustID.sendKeys(CIDAct);			
			
			}
		
		public void clickFilterBtn(){
			this.filterBtn.click();
		}
		
		public void checkReturnID(String RIDExp){
			String RIDAct = this.ReturnIDActual.getText();
			
			Assert.assertEquals(RIDAct, RIDExp);
			System.out.println("correct Return ID filtered: Records Found");

			}
		
		public void checkProduct(String RIDExp, String CIDExp){
			String RIDAct = this.ReturnIDActual.getText();
			String CIDAct = this.CustomerIDActual.getText();
			
			
			if((RIDAct.equals(RIDExp))&&(CIDAct.equals(CIDExp)))
				System.out.println("Products Filtered Successfully with given filter criteria: Records Found");
				else
				System.out.println("incorrect data filtered");
			}

		}





