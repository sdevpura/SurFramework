package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class UNF_046POM {
	private WebDriver driver; 
	
	public UNF_046POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
		//TC UNF_046 elements
		
		@FindBy(xpath="//*[@id='sale']/a/i")
		private WebElement cartIcon; 
		
		@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
		private WebElement orders; 
		
		@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[8]/a[2]")
		private WebElement editBtn;
		
		


	//TC UNF_046 methods
		
		
		public void clickcartIcon() {
			this.cartIcon.click(); 
		}
		
		public void clickOrders() {
			this.orders.click(); 
		}
		
		
}
