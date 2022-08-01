package com.pract.auto.PageObjects;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class ProductCategoryObject {
	
	private static final Logger logger = LogManager.getLogger(ProductCategoryObject.class);

	
	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	
	//*******************************************************************************************************//

//	Locators
	private By prod = By.xpath("//div[@id ='block_top_menu']/ul/li/a");
	
	public ProductCategoryObject(WebDriver driver, Scenario scn) {
		this.driver = driver;
		this.scn = scn;
		this.wait = wait;
	
	}	
	
	//*******************************************************************************************************//

	public void  prodcat() {
		
	 List<WebElement> ListProdsCat =  driver.findElements(prod);
	
//  	  for(int i=0;i<ListProdsCat.size();i++)
//  	  {
////  		  Assert.assertEquals(product_category, ListProdsCat);
//  	  
//  	  }
//  	  }
	
	}	
//*******************************************************************************************************//

	public void prodcateg(List<String> product_category) {
		 List<WebElement> ListProds =  driver.findElements(prod);
		 
		 
		for (int i=0; i<ListProds.size();i++)
		{
			for(int j=0;j<product_category.size();j++)
			{
						
			if(ListProds.get(i).getText().equals(product_category.get(j).toString()))

			
			{
				Assert.assertTrue(true);				
			}
			else
			{
				Assert.assertFalse(false);
				
	}}}}
			
	
//*******************************************************************************************************//

	public void count (int int1)
	{
		 List<WebElement> ProdCount =  driver.findElements(prod);
		 
		 int no = ProdCount.size();
		 Assert.assertEquals(int1, no);
		 scn.log("Number of products is" + int1);
 		  scn.log("Number of product category searched: " + no);
 		  
 		 logger.info("Number of products is" + int1); 
 		 logger.info("Number of product category searched: " + no);
	}
}
