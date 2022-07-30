package com.pract.auto.PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class SignInPageObject {
	
	private static final Logger logger = LogManager.getLogger(SignInPageObject.class); 

	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	JavascriptExecutor js;
	
//	locator
	private By Sign = By.xpath("//a[@class='login']");
	
	
//	constructor
	public SignInPageObject(WebDriver driver, Scenario scn ) {
		this.driver = driver;
		this.scn = scn;
		this.wait = wait;
	}

//*******************************************************************************************************//

	public void SignIn () {
		
		WebElement SignInBtn = driver.findElement(Sign);
		
		 wait = new WebDriverWait(driver,20);
			scn.log("reached signin btn");
			logger.info("reached signin btn");
		
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].click();",SignInBtn);
				
				
				wait.until(ExpectedConditions.titleContains("Login - My Store"));

	}
	
//*******************************************************************************************************//
	
	public void SignInTitle(String string) {
		
		wait.until(ExpectedConditions.titleContains(string));
		
		String acttitle = driver.getTitle();
		
		Assert.assertEquals(true,acttitle.contains(string));
		
		scn.log("completed signin btn");
		logger.info("completed signin btn");
	}
}
//*******************************************************************************************************//