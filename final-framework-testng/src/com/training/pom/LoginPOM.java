package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userAdmin; 
	
	@FindBy(id="input-password")
	private WebElement passwordAdmin; 
	
	@FindBy(xpath="//*[@id='content']/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement login;
	
	
	
	
	public void sendUserName(String userAdmin) {
		this.userAdmin.clear();
		this.userAdmin.sendKeys(userAdmin);
	}
	
	public void sendPassword(String passwordAdmin) {
		this.passwordAdmin.clear(); 
		this.passwordAdmin.sendKeys(passwordAdmin); 
	}
	
	public void clickLoginBtn() {
		this.login.click(); 
	}
	
	
		
}
