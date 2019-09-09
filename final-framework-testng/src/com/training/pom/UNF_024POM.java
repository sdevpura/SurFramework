package com.training.pom;

//import java.awt.List;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import java.util.*;

public class UNF_024POM {
	
	private WebDriver driver;

	public UNF_024POM(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//TC UNF_024 elements
	@FindBy(xpath="//*[@id='reports']/a/i")
	private WebElement Reports;
	
	@FindBy(xpath="//*[@id='reports']/ul/li/a")
	private WebElement Sales;
	
	@FindBy(xpath="//*[@id='reports']/ul/li/ul/li/a//parent::li")
	private WebElement Orders;
	
	@FindBy(xpath="//*[@id='reports']/ul/li/ul/li/a//parent::li//following-sibling::li[1]/a")
	private WebElement Tax;
	
	@FindBy(xpath="//*[@id='reports']/ul/li/ul/li/a//parent::li//following-sibling::li[2]/a")
	private WebElement Shipping;
	
	@FindBy(xpath="//*[@id='reports']/ul/li/ul/li/a//parent::li//following-sibling::li[3]/a")
	private WebElement Returns;
	
	@FindBy(xpath="//*[@id='reports']/ul/li/ul/li/a//parent::li//following-sibling::li[4]/a")
	private WebElement Coupons;
	
	@FindBy(linkText="No results!")
	private WebElement NoResultsFound;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/div[2]/div[2]/table/tbody/tr[18]")
	private WebElement TableData;
	
	@FindBy(id="input-group")
	private WebElement GroupBy;
	
	
	
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	@FindBy(tagName="a")
	private WebElement Tagname;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/div[2]/div[3]/div[1]/ul/li[4]/a")
	private WebElement page4;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/div[2]/div[3]/div[1]/ul/li[6]/a")
	private WebElement lastPage;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/div[2]/div[3]/div[2]")
	private WebElement pageText;
	
	
	//TC UNF_024 Methods
	
	public void ClickReports(){
		this.Reports.click();
	}
	
	public void ClickSales(){
		this.Sales.click();
	}
	
	public void GetSalesOptions(String OrdersTextExp, String  TaxTextExp, String ShippingTextExp, String ReturnsTextExp, String  CouponsTextExp){
		String OrdersTextAct = this.Orders.getText();
		String TaxTextAct = this.Tax.getText();
		String ShippingTextAct = this.Shipping.getText();
		String ReturnsTextAct = this.Returns.getText();
		String CouponsTextAct = this.Coupons.getText();
		Assert.assertEquals(OrdersTextAct, OrdersTextExp);
		System.out.println("Orders menu present under Sales menu");
		Assert.assertEquals(TaxTextAct, TaxTextExp);
		System.out.println("Tax menu present under Sales menu");
		Assert.assertEquals(ShippingTextAct, ShippingTextExp);
		System.out.println("Shipping menu present under Sales menu");
		Assert.assertEquals(ReturnsTextAct, ReturnsTextExp);
		System.out.println("Returns menu present under Sales menu");
		Assert.assertEquals(CouponsTextAct, CouponsTextExp);
		System.out.println("Coupons menu present under Sales menu");
	}
	
	public void ClickShipping(String ShippingTitleExp) throws InterruptedException{
		this.Shipping.click();
		Thread.sleep(3000);
		String ShippingTitleAct = this.driver.getTitle();
		Assert.assertEquals(ShippingTitleAct, ShippingTitleExp);
		
		if(TableData.isDisplayed())
			System.out.println("Shipping details for total number of orders detail is displayed");
		else
			System.out.println("No Records found");
		}
	
	public void SelectOption(){
/*		String[] values = new String[]{ "Years","Months","Weeks","Days" };
		List ListOptionExp = (List) Arrays.asList(values); */
 	
		Select sel = new Select(GroupBy);
		List<WebElement> options =  sel.getOptions();		
		System.out.println("Size is: "+options.size());
		for(int i=0;i<options.size();i++){
			System.out.println("Options are: "+options.get(i).getText());
		}
					
		sel.selectByVisibleText("Weeks");
		
/*		if(ListOptionExp.equals(options))
			
			System.out.println("options are correctly matched");*/
		/*String WeekTextAct = this.GroupBy.getText();
		Assert.assertEquals(WeekTextAct, WeekTextExp);		*/	
	}
	
	
	public void clickFilterBtn(){
		this.filterBtn.click();
	}
	
	public void ScrollPage() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
	}
	
	public void verifyRecords(String pageTextExp) throws InterruptedException{
		this.lastPage.click();
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		String pageTextAct = this.pageText.getText();
		Assert.assertEquals(pageTextAct, pageTextExp);
		System.out.println("Total number of Shipping details for orders made in a week are displayed");
		
	}
	
}
	
		
	
	
	
	


