package com.pract.auto.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pract.auto.core.WebDriverFactory;

import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class CommonPageObjects {

	private static final Logger logger = LogManager.getLogger(CommonPageObjects.class);
	
	WebDriver driver;
	Scenario scn;
	
	
//*******************************************************************************************************//

	int ActLogHt = 99;
	int ActLogWid = 350;
	public static final String ExpTitle = "My Store";
	String ExpUrl = "http://automationpractice.com/index.php";
	
//*******************************************************************************************************//

	
//	Locators
	
	private  By logoDisplay = By.xpath("//div[@id='header_logo']/a/img");

	
	
	
	public CommonPageObjects(WebDriver driver,Scenario scn) {
		this.driver = driver;
		this.scn = scn;
	}
	
//*******************************************************************************************************//
	
	public void NavigationURL(String url)
	{
		WebDriverFactory.navigateToTheURL(url);
		scn.log("Browser is navigated to the URL: ");
        logger.info("Browser is navigated to the URL: ");
	}

//*******************************************************************************************************//

	public void RedirectURL()
	{
		
	String ActUrl = driver.getCurrentUrl();
	Assert.assertEquals(ExpUrl, ActUrl);
	
	scn.log("Redirected Website Link is" + driver.getCurrentUrl());
	logger.info("Redirected Website Link is" + driver.getCurrentUrl());
	}
	
//*******************************************************************************************************//

	public void MyStore()
	{
		driver.getTitle();
    	String ActTitle = driver.getTitle();
    	Assert.assertEquals(ExpTitle, ActTitle);
	}
	
//*******************************************************************************************************//

	public void logoDisp()
	{
		WebElement logo = driver.findElement(logoDisplay);
//		boolean logoDisp = logo.isDisplayed();
		Assert.assertEquals(true, logo.isDisplayed());
		
		scn.log("Logo is displayed on the landing page successfully");
		logger.info("Logo is displayed on the landing page successfully");
	}
	
//*******************************************************************************************************//

	
	public void logoHeight() 
	{
		WebElement logo_1 = driver.findElement(logoDisplay);
		String i = logo_1.getAttribute("height");
		
		int expht = Integer.parseInt(i);
		int Actht =ActLogHt;
		
		Assert.assertEquals(expht, Actht);
		
		scn.log("Logo's height is validated successfully");
		logger.info("Logo's height is validated successfully");
	}
	
//*******************************************************************************************************//

	
	public void logoWidth()
	{
		WebElement logo_2 = driver.findElement(logoDisplay);
		String j = logo_2.getAttribute("width");
		
		int expwd = Integer.parseInt(j);
		int Actwd =ActLogWid;
		
		Assert.assertEquals(expwd, Actwd);
		
		scn.log("Logo's width is validated successfully");
		logger.info("Logo's width is validated successfully");
	}
	
}
