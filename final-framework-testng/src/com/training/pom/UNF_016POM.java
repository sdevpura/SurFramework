package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class UNF_016POM {
	private WebDriver driver; 
	
	public UNF_016POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
		//TC UNF_016 elements
/*		@FindBy(id="input-username")
		private WebElement userAdmin; 
		
		@FindBy(id="input-password")
		private WebElement passwordAdmin; 
		
		@FindBy(xpath="//*[@id='content']/div/div/div/div/div[2]/form/div[3]/button")
		private WebElement login;*/
		
		@FindBy(xpath="//*[@id='sale']/a/i")
		private WebElement cartIcon; 
		
		@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
		private WebElement orders; 
		
		@FindBy(xpath="//tbody/tr/td/input")
		private WebElement checkBox; 
		
		@FindBy(xpath="//tbody/tr/td[8]/button")
		private WebElement deleteBtn;
		
		@FindBy(xpath="//tbody/tr/td[2]")
		private WebElement orderNum;
		
		
		@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[2]")
		private WebElement deletedOrder;
		


	//TC UNF_016 methods
		
/*		public void sendUserAdmin(String userAdmin) {
			this.userAdmin.clear();
			this.userAdmin.sendKeys(userAdmin);
		}
		
		public void sendPasswordAdmin(String passwordAdmin) {
			this.passwordAdmin.clear(); 
			this.passwordAdmin.sendKeys(passwordAdmin); 
		}
		
		public void clickLogin() {
			this.login.click(); 
		}*/
		
		public void clickcartIcon() {
			this.cartIcon.click(); 
		}
		
		public void clickOrders() {
			this.orders.click(); 
		}
		
		public void getOrderID(String orderIDExp) {
			String orderIDAct = this.orderNum.getText(); 
			Assert.assertEquals(orderIDExp, orderIDAct);
			
			
		}
		
		public void clickCheckBox() {
			this.checkBox.click(); 
		}
		
		public void clickDeleteBtn() {
			this.deleteBtn.click(); 
		}
		public void handleAlert() throws InterruptedException{
			Alert alertWarn = driver.switchTo().alert();
			String alertWarnText = alertWarn.getText();
			System.out.println(alertWarnText);
	 		
	 		Thread.sleep(10000);
	 		alertWarn.accept();
			System.out.println("Warning Alert accepted");
			
			//Success alert check if found or not
			try{
				Alert alertSuccess = driver.switchTo().alert();
				System.out.println(alertSuccess);
			}catch(NoAlertPresentException a ){
				System.out.println("No Success Alert is present");
			}
		}
		
		public void VerifyOrderDeleted(String orderIDExp) {
			String disOrder = this.orderNum.getText();
					
			if(disOrder.equals(orderIDExp))
				System.out.println("Test Fail because order id is still displayed");
			else
				System.out.println("Test Successful as deleted order id is not found");		
			
				
		}

}
