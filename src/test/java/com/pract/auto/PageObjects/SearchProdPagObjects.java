package com.pract.auto.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class SearchProdPagObjects {
	
	private static final Logger logger = LogManager.getLogger(SearchProdPagObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
//*******************************************************************************************************//

//	locator
	private By SBox  = By.xpath("//input[@id='search_query_top']");
	private By BtnGo = By.xpath("//button[@class='btn btn-default button-search']");
	private By ListDress = By.xpath("//div[@class='ac_results']/ul/li");
	
//	constructor
	public SearchProdPagObjects(WebDriver driver, Scenario scn ) {
		this.driver = driver;
		this.scn = scn;
		this.wait = wait;
		
	}
//*******************************************************************************************************//

	public void SearchB()
	{
		WebElement sbox = driver.findElement(SBox);
		Assert.assertEquals("Search box is not available", true,sbox.isDisplayed());
		scn.log("Search Box is Displayed and validate Successfully");
		logger.info("Search Box is Displayed and validate Successfully");
}

//*******************************************************************************************************//

	public void searchProd(String string) 
	{
		WebElement sbox = driver.findElement(SBox);
		sbox.sendKeys(string);
		
		List<WebElement> dressList = driver.findElements(ListDress); 
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElements(dressList));
	}
	
//*******************************************************************************************************//

	public void NoPro(String string) 
	{
		List<WebElement> dressList = driver.findElements(ListDress); 
		int number = 0;
		
		for  (int i =0; i<dressList.size(); i++)
		{
			if (dressList.get(i).getText().contains(string))
			{
//				Assert.assertEquals(true, dressList.get(i).getText().contains(string));
				number++;
			}
		}
		scn.log("Actual product list count is = "+number);
		logger.info("Actual product list count is = "+number);		
	}
}