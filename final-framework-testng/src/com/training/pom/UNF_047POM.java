package com.training.pom;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UNF_047POM {
	
	private WebDriver driver;
	static String orderStatusExp = "Pending" ; //learnt to use static

	public UNF_047POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//TC UNF_047 elements
	@FindBy(xpath="//*[@id='sale']/a/i")
	private WebElement cart; 
	
	@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
	private WebElement orders; 
	
	@FindBy(xpath="//*[@id='input-order-id']")
	private WebElement orderID;
	
	@FindBy(xpath="//*[@id='input-order-status']")
	private WebElement orderStatus;
	
	@FindBy(xpath="//*[@id='input-date-added']")
	private WebElement dateAdded;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/div[2]/div[1]/div/div[3]/div[1]/div/span/button/i")
	private WebElement dateAddedCalender;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/table/thead/tr[1]/th[2]")
	private WebElement dateAddedPicker;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/table/tbody/tr/td/span[9]//ancestor::table/thead/tr/th[2]")
	private WebElement dateAddedYearPicker;
	
	@FindBy(xpath="/html/body/div[2]/div/div[3]/table/tbody/tr/td/span[11]//preceding-sibling::span[1]") //html/body/div[2]/div/div[2]/table/tbody/tr/td/span[9]//preceding-sibling::span[7]  , /html/body/div[2]/div/div[3]/table/tbody/tr/td/span[10]
	private WebElement dateAddedYear;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/table/tbody/tr/td/span[9]//preceding-sibling::span[7]")
	private WebElement dateAddedMonth;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/table/tbody/tr[1]/td[1]//parent::tr//following-sibling::tr[3]/td") ///html/body/div[2]/div/div[1]/table/tbody/tr[1]/td[1]//parent::tr//following-sibling::tr[3]//td[2],  /html/body/div[2]/div/div[1]/table/tbody/tr[4]/td[1]
	private WebElement dateAddedDate;
	
	@FindBy(xpath="//*[@id='input-total']")
	private WebElement total;
	
	@FindBy(xpath="//*[@id='input-customer']")
	private WebElement customer;
	
	@FindBy(xpath="//*[@id='input-date-modified']")
	private WebElement dateModified;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[1]/div/span/button//ancestor::span//parent::div//parent::div//parent::div/div[2]/div/span/button/i") 
	private WebElement dateModifiedCalender;
	
/*	@FindBy(xpath="//*[@id='content']/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[2]/div/span/button/i") 
	private WebElement dateModifiedCalender;//xpath not working*/ 
	
	@FindBy(xpath="/html/body/div[3]/div/div[1]/table/thead/tr[1]/th[2]")
	private WebElement dateModifiedPicker;
	
	@FindBy(xpath="/html/body/div[3]/div/div[2]/table/tbody/tr/td/span[9]//ancestor::table/thead/tr/th[2]")
	private WebElement dateModifiedYearPicker;	
	
	
	@FindBy(xpath="/html/body/div[3]/div/div[3]/table/tbody/tr/td/span[11]//preceding-sibling::span[1]")
	private WebElement dateModifiedYear;
	
	@FindBy(xpath="/html/body/div[3]/div/div[2]/table/tbody/tr/td/span[9]//preceding-sibling::span[7]")
	private WebElement dateModifiedMonth;
	
	@FindBy(xpath="/html/body/div[3]/div/div[1]/table/tbody/tr[1]/td[1]//parent::tr//following-sibling::tr[3]/td")
	private WebElement dateModifiedDate;	
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr/td")
	private WebElement noResultsFound;
	
		
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr/td[2]")
	private WebElement tableOrderID;
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[4]")
	private WebElement tableOrderStatus;
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[3]")
	private WebElement tableCustomer;
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr/td[5]")
	private WebElement tableTotal;
							
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[2]/td")
	private WebElement tableDataByDateAdded;
	
	
	
	//TC UNF_047 methods
			public void clickOrders() throws InterruptedException{
				Actions act = new Actions(driver);
				Action mouseover = act.moveToElement(cart).build();
				mouseover.perform();
				Thread.sleep(3000);
				this.orders.click();
				
			}
			

			//-------------Methods for selecting Filters----------------
			
			public void clearFilters( String orderStatusExp ){
				this.orderID.clear();
				Select sel = new Select(orderStatus);
				sel.selectByVisibleText(orderStatusExp); //choose blank status
				this.dateAdded.clear();
				this.customer.clear();
				this.total.clear();
				this.dateModified.clear();
			}
			
			
			public void enterOrderID(String orderIDExp){
				this.orderID.clear();
				this.orderID.sendKeys(orderIDExp);
			}
			
			public void selectOrderStatus(String orderStatusExp){
				Select sel = new Select(orderStatus);
				sel.selectByVisibleText(orderStatusExp);
			}
			
			
			public void selectDateAdded() throws InterruptedException{
				this.dateAddedCalender.click();
				Thread.sleep(2000);
				this.dateAddedPicker.click();
				Thread.sleep(2000);
				this.dateAddedYearPicker.click();
				Thread.sleep(2000);
				this.dateAddedYear.click();
				Thread.sleep(2000);
				this.dateAddedMonth.click();
				Thread.sleep(2000);
				this.dateAddedDate.click();
				Thread.sleep(2000);
				
			}	
			
			public void selectDateModified() throws InterruptedException{
				this.dateModifiedCalender.click();
				Thread.sleep(2000);
				this.dateModifiedPicker.click();
				Thread.sleep(2000);
				this.dateModifiedYearPicker.click();
				Thread.sleep(2000);
				this.dateModifiedYear.click();
				Thread.sleep(2000);
				this.dateModifiedMonth.click();
				Thread.sleep(2000);
				this.dateModifiedDate.click();
				Thread.sleep(2000);
				
			}	
			
			public void enterCustomer(String customerExp){
				this.customer.clear();
				this.customer.sendKeys(customerExp);
			}
			
			public void enterTotal(String totalExp){
				this.total.clear();
				this.total.sendKeys(totalExp);
			}

			public void clickFilterBtn(){
				this.filterBtn.click();
			}
			
			//--------------Methods for Verifying output as per filter given---------------

			
			public void verifyFilterByOrderID(String orderIDExp) {
				String orderIDAct = this.tableOrderID.getText(); 
				Assert.assertEquals(orderIDExp, orderIDAct);
				System.out.println("1. Order with 'Order ID' is displayed");
				
			}
			
			public void verifyFilterbyOrderStatus(){				
				String orderStatusAct = this.tableOrderStatus.getText();
				Assert.assertEquals(orderStatusAct, orderStatusExp);
				System.out.println("2. Orders with 'Order Status'- Pending are displayed");
			}	
			
			public void verifyFilterbyDateAdded(){				
				if(noResultsFound.isDisplayed())
					System.out.println("3. Orders with 'Date Added' are filtered but no records found");
				else
				System.out.println("3. Orders filtered by 'Date Added' are displayed");
			}	
			
			public void verifyFilterbyCustomer(String customerExp){		
				String customrAct = this.tableCustomer.getText();
				Assert.assertEquals(customrAct, customerExp);
				System.out.println("4. Orders filtered by 'Customer' are displayed ");
			}	
			
			public void verifyFilterbyTotal(String totalExp) throws InterruptedException{	
				String tt = this.tableTotal.getText();
				if(tt.contains(totalExp)) //learnt String class methods
					System.out.println("5. Orders filtered by 'Total' are displayed ");
					else
						System.out.println("Filter by 'Total' Failed");
				Thread.sleep(3000);
				}
			
			public void verifyFilterbyDateModified(){				
				if(noResultsFound.isDisplayed())
					System.out.println("3. Orders with 'Date Added' are filtered but no records found");
				else
				System.out.println("6. Orders filtered by 'Date Modified' are displayed");
			}
				

			

			
			
			
			

}
