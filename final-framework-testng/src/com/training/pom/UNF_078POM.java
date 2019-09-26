package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UNF_078POM {
	private WebDriver driver; 
	
	public UNF_078POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
		//TC UNF_078 elements
		@FindBy(id="input-username")
		private WebElement userAdmin; 

		@FindBy(id="input-password")
		private WebElement passwordAdmin; 

		@FindBy(xpath="//*[@id='content']/div/div/div/div/div[2]/form/div[3]/button")
		private WebElement login;
		
		@FindBy(xpath="//*[@id='catalog']/a/i")
		private WebElement catalog; 
		
		@FindBy(xpath="//*[@id='catalog']/ul/li[1]/a")
		private WebElement categories; 
		
		@FindBy(xpath="//*[@id='content']/div[1]/div/div/a[1]/i")
		private WebElement addNewCat;
		
		@FindBy(xpath="//*[@id='content']/div[2]/div/div[1]/h3")
		private WebElement addCatText;
		
		@FindBy(css="input#input-name1")  //using CSSSelector locator
		private WebElement categoryNameTextBox;
		
		@FindBy(xpath="//*[@id='language1']/div[2]/div/div/div[3]/div[2]/p")
		private WebElement categoryDesc;
		
		@FindBy(xpath="//*[@id='input-meta-title1']")
		private WebElement metaTagTextBox;
		
		@FindBy(xpath="//*[@id='input-meta-description1']")
		private WebElement metaTagDesc;
		
		@FindBy(xpath="//a[text()='Data']")
		private WebElement dataTab;
		
		@FindBy(xpath="//a[text()='Design']")
		private WebElement designTab;
		
		@FindBy(xpath="//*[@id='tab-data']/div[3]/div/div/div/label/input")  
		private WebElement defaultCheckBox;
		
		@FindBy(xpath="//*[@id='tab-design']/div/table/tbody/tr/td[2]/select/option[1]")
		private WebElement layoutList;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement saveCategoryBtn;
		
		@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
		private WebElement categoryAddAlert;
		
		@FindBy(xpath="//*[@id='catalog']/ul/li[2]/a")
		private WebElement productIcon;
		
		@FindBy(xpath="//*[@id='content']/div[1]/div/div/a")
		private WebElement addNewProductIcon;
		
		@FindBy(xpath="//*[@id='input-name1']")
		private WebElement productnNameTextBox;	
		
		@FindBy(xpath="//*[@id='input-model']")
		private WebElement modelName;
		
		@FindBy(xpath="//*[@id='form-product']/ul/li[3]/a")
		private WebElement linksTab;
		
		@FindBy(xpath="//*[@id='input-category']")
		private WebElement categoryList;

		@FindBy(xpath="//*[@id='tab-links']/div[2]/div/ul/li[1]/a")
		private WebElement catSelect;

		@FindBy(xpath="//*[@id='form-product']/ul/li[4]/a")
		private WebElement attributeTab;
		
		@FindBy(xpath="//*[@id='form-product']/ul/li[5]/a")
		private WebElement optionTab;
		
		@FindBy(xpath="//*[@id='form-product']/ul/li[6]/a")
		private WebElement recurringTab;
		
		@FindBy(xpath="//*[@id='form-product']/ul/li[7]/a")
		private WebElement discountTab;
		
		@FindBy(xpath="//*[@id='form-product']/ul/li[8]/a")
		private WebElement specialTab;
		
		@FindBy(xpath="//*[@id='form-product']/ul/li[9]/a")
		private WebElement ImageTab;
		
		@FindBy(xpath="//*[@id='form-product']/ul/li[10]/a")
		private WebElement rewardPointsTab;
		
		@FindBy(xpath="//*[@id='content']/div[1]/div/div/button/i")
		private WebElement saveProductBtn;
		
		@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
		private WebElement productAddAlert;
		
		
		//TC UNF_078 methods
		
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
		
		
		
		
		public void clickCategories() throws InterruptedException{
			String titleCatExp = "Categories";
			Actions act = new Actions(driver);
			Action mouseover = act.moveToElement(catalog).build();
			mouseover.perform();
			Thread.sleep(3000);
			this.categories.click();
			String titleCatAct = driver.getTitle();
			Assert.assertEquals(titleCatAct, titleCatExp);
			System.out.println(titleCatAct+" Page is displayed successfully");		
			
		}
		
		public void AddNewCategories(String catName, String catMetaTag, String categoryDesc, String metaTagDesc) throws InterruptedException{
			String textAddCatExp = "Add Category";
			this.addNewCat.click();
			String textAddCatAct = this.addCatText.getText();
			Assert.assertEquals(textAddCatAct, textAddCatExp);
			System.out.println(textAddCatAct+" is displayed successfully");	
			this.categoryNameTextBox.sendKeys(catName);
			this.categoryDesc.sendKeys(categoryDesc);
			this.metaTagTextBox.sendKeys(catMetaTag);
			this.metaTagDesc.sendKeys(metaTagDesc);
			this.dataTab.click();
			Thread.sleep(3000);
			
			//Checking default values are selected
			if(this.defaultCheckBox.isSelected())
				System.out.println("Default values in Data Tab is selected");
			else
				System.out.println("Default values in Data is not selected");
			this.designTab.click();
			Thread.sleep(3000);
			this.saveCategoryBtn.click();	
			Thread.sleep(4000);
			
			//checking category added successfully
			String alertTextAct = this.categoryAddAlert.getText();
			String alertTextExp = "Success";
			if(alertTextAct.contains(alertTextExp))
				System.out.println("Category added successfully");
			else
				System.out.println("Category not added");	
			
		}
		
		public void clickProduct() throws InterruptedException{
			String titleProExp = "Products";
			Actions act = new Actions(driver);
			Action mouseover = act.moveToElement(catalog).build();
			mouseover.perform();
			Thread.sleep(3000);
			this.productIcon.click();
			String titleProAct = driver.getTitle();
			Assert.assertEquals(titleProAct, titleProExp);
			System.out.println(titleProAct+" Page is displayed successfully");		
			
		}
		
		public void AddNewProducts(String productName, String productMetaTag, String catList) throws InterruptedException{
			this.addNewProductIcon.click();
			this.productnNameTextBox.sendKeys(productName);
			this.categoryDesc.sendKeys("Uniform for Sports");
			this.metaTagTextBox.sendKeys(productMetaTag);
			this.metaTagDesc.sendKeys("Uniform for Sports");
			this.dataTab.click();
			Thread.sleep(3000);
			this.modelName.sendKeys("SPU-03");
			this.linksTab.click();
			this.categoryList.sendKeys(catList);
			Thread.sleep(3000);
			this.catSelect.click();
			Thread.sleep(3000);			
			this.attributeTab.click();
			Thread.sleep(2000);
			this.optionTab.click();
			Thread.sleep(2000);
			this.recurringTab.click();
			Thread.sleep(2000);
			this.discountTab.click();
			Thread.sleep(2000);
			this.specialTab.click();
			Thread.sleep(2000);
			this.ImageTab.click();
			Thread.sleep(2000);
			this.rewardPointsTab.click();
			Thread.sleep(2000);
			this.designTab.click();
			Thread.sleep(2000);
			this.saveProductBtn.click();
			
			Thread.sleep(3000);
			this.saveProductBtn.click();
		
		}
		
		
		

		


		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		

		
		
}
