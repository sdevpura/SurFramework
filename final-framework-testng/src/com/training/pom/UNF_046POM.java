package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class UNF_046POM {
	private WebDriver driver; 
	
	public UNF_046POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//DO NOT EVALUATE!!!!!! Scripting is in Progress.
	
	
		//TC UNF_046 elements
		
		@FindBy(xpath="//*[@id='catalog']/a/i")
		private WebElement catalog; 
		
		@FindBy(css="input#input-name1")  
		private WebElement categoryNameTextBox;

		
		
		//TC UNF_046 methods
		
				
		
		
		

		
		
		
		

		
		
}
