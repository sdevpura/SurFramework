package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_077POM {
	private WebDriver driver; 
	
	
	public UNF_077POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
		//TC UNF_077 elements
	
		@FindBy(id="input-username")
		private WebElement userAdmin; 
	
		@FindBy(id="input-password")
		private WebElement passwordAdmin; 
	
		@FindBy(xpath="//*[@id='content']/div/div/div/div/div[2]/form/div[3]/button")
		private WebElement login;
		
		@FindBy(xpath="//*[@id='sale']/a/i")
		private WebElement cartIcon; 
		
		@FindBy(tagName="a")  
		private WebElement links;
		
		@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
		private WebElement orders; 
		
		@FindBy(xpath="//*[@id='input-order-id']")
		private WebElement orderIDTextBox;
		
		@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[8]/a[2]")
		private WebElement editBtn;
		
		@FindBy(xpath="//*[@id='button-ip-add']")
		private WebElement addIPBtn;
		
		@FindBy(xpath="//*[@id='button-customer']")
		private WebElement continueBtn;
		
		@FindBy(xpath="//*[@id='button-cart']")
		private WebElement continueBtnCart;
		
		@FindBy(xpath="//*[@id='button-payment-address']")
		private WebElement continueBtnPayment;
		
		@FindBy(xpath="//*[@id='button-shipping-address']")
		private WebElement continueBtnShipping;
		
		
		@FindBy(xpath="//*[@id='cart']/tr/td[6]/button")
		private WebElement RemoveBtn;		
		
		@FindBy(xpath="//*[@id='input-product']")
		private WebElement chooseProductTextBox;
		
		
		@FindBy(xpath="//*[@id='tab-product']/fieldset/div[1]/div/ul/li[1]/a")
		private WebElement chooseList;
		
		
		@FindBy(xpath="//*[@id='input-quantity']")
		private WebElement quantityTextBox;
		
		@FindBy(xpath="//*[@id='button-product-add']")
		private WebElement addProductBtn;
		
		@FindBy(xpath="//*[@id='button-save']")
		private WebElement saveBtn;
		
		@FindBy(xpath="//*[@id='input-shipping-method']")
		private WebElement shipping;
		
		@FindBy(xpath="//*[@id='button-shipping-method']")
		private WebElement applyShippingMethod;
		
		@FindBy(xpath="//*[@id='button-payment-method']")
		private WebElement applyPaymentMethod;
		
		
		@FindBy(xpath="//*[@id='input-payment-method']")
		private WebElement payment;
		
		@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
		private WebElement messageSuccess;			
		
	

		
		
		//UNF_076 Methods
		
		public void sendUserName(String userAdmin) {
			this.userAdmin.clear();
			this.userAdmin.sendKeys(userAdmin);
		}
		
		public void sendPassword(String passwordAdmin) {
			this.passwordAdmin.clear(); 
			this.passwordAdmin.sendKeys(passwordAdmin); 
		}
		
		public void clickLoginBtn() throws InterruptedException {
			this.login.click(); 
			Thread.sleep(5000);
		}		
		
		
		
		public void refresh(){
			driver.navigate().refresh();
			}	
		
		//Find and Click orders link using List and extended for loop		
		public void findAndSelectOrdersLink(String linkTextExp) throws InterruptedException{
			
			Actions act = new Actions(driver);
			Action mouseover = act.moveToElement(cartIcon).build();
			mouseover.perform();
						
			List<WebElement> linkList = driver.findElements(By.tagName("a"));
			String[] linkTextAct = new String[linkList.size()];
				
			int i=0;			
			for(WebElement e:linkList){
				linkTextAct[i] = e.getText();				
					
				if(linkTextAct[i].equals("Orders")){
					this.orders.click();
					System.out.println("Orders link identified");
					break;
					}	

			}	
			
		}
		
		public void ScrollPage() throws InterruptedException{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,600)");
			Thread.sleep(3000);
		}
		
		public void editOrder() throws InterruptedException{
			this.editBtn.click();
			Thread.sleep(3000);
		}
		
		public void addIP(){
			if(this.addIPBtn.isDisplayed())
			this.addIPBtn.click();			
			else
				System.out.println("No need to add IP");
		}
		
		public void clickContinue(){
			this.continueBtn.click();
		}
		
		public void clickContinueCart(){
			this.continueBtnCart.click();
		}
		
		public void clickContinuePayment(){
			this.continueBtnPayment.click();
		}
		
		public void clickContinueShipping(){
			this.continueBtnShipping.click();
		}
		
		public void removeProduct() throws InterruptedException{
			Thread.sleep(3000);
			this.RemoveBtn.click();
			Thread.sleep(3000);
		}
		
		
		public void enterProduct(String productName) throws InterruptedException{
			this.chooseProductTextBox.sendKeys(productName);
			Thread.sleep(3000);
			this.chooseList.click();
				}
		
		public void enterQuantity(String quantity) throws InterruptedException{
			//String quan = Integer.toString(quantity);
			this.quantityTextBox.clear();
			this.quantityTextBox.sendKeys(quantity);		
			
				}
		
		public void addProduct(){
			this.addProductBtn.click();
		}
		
		public void selectShippingAdd() throws InterruptedException{
			Select sel = new Select(shipping);
			sel.selectByIndex(1);
			Thread.sleep(3000);
			this.applyShippingMethod.click();
		}
		
		public void selectPaymentMethod() throws InterruptedException{
			Select sel = new Select(payment);
			sel.selectByIndex(1);			
			Thread.sleep(3000);
		}
		
		public void save() throws InterruptedException{
			this.saveBtn.click();			
			Thread.sleep(3000);
			
			String alertTextAct = this.messageSuccess.getText();
			String alertTextExp = "Success";
			if(alertTextAct.contains(alertTextExp))
				System.out.println("Product Added successfully");
			else
				System.out.println("Product not added");	
			
		}
		
		
				
		
		
		

		
		
		
		

		
		
}
