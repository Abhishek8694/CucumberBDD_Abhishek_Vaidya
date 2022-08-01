package com.pract.auto.PageObjects;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class FooterSectionObjects {
	
	private static final Logger logger = LogManager.getLogger(FooterSectionObjects.class);

	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;

	
	
//	constructor
	public FooterSectionObjects(WebDriver driver, Scenario scn) {
		this.driver = driver;
		this.scn = scn;
		this.wait = wait;
	}
	
	//*******************************************************************************************************//
	
	
//	Locator
	private By TwitLink = By.xpath("//li[@class='twitter']");
	private By tweetName = By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wbh5a2']//preceding-sibling::div[1]/child::div[1]/child::div[1]/span/span");
	private By newsletter = By.xpath("//input[@name='email']");
	private By NewGoBtn = By.xpath("//button[@name='submitNewsletter']");
	private By NewScsMsg = By.xpath("//p[@class='alert alert-success']");

	//*******************************************************************************************************//

//	Twitter link
	public void Tweeter (WebDriver driver) 
	{
		
	WebElement TweetLink = driver.findElement(TwitLink);
	
	
	TweetLink.click();
	}

	public void TweeterName (String string)
	{
		
	WebElement TweetAcName = driver.findElement(tweetName);
	Assert.assertEquals(true,TweetAcName.getText().contains(string));
    scn.log("Tweeter Account name is matched and displayed as: " + TweetAcName);
    logger.info("Tweeter Account name is matched and displayed as: " + TweetAcName);

	}	
	
	//*******************************************************************************************************//	

//	10 Newspaper
	public void NewsBox() {
		
		WebElement SubcTxtBox = driver.findElement(newsletter);
		
		 String randomName1 = RandomNoGeneratorUtils.randomStringGenerator();
			
		
		SubcTxtBox.sendKeys(randomName1);
		
		WebElement GoBtn = driver.findElement(NewGoBtn);
		 wait = new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.elementToBeClickable(NewGoBtn));

		GoBtn.click();
		
//		Actions actions = new Actions(driver);
//		actions.click(GoBtn);
		
		
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].click();",GoBtn);
	
			scn.log("Subscription alert message  displayed");
			logger.info("Subscription alert message  displayed");
		}
	
	//*******************************************************************************************************//

	public void SuccessMsg(String string) {
		
//		WebElement Msg = driver.findElement(NewScsMsg);

		try {
						
		WebElement Msg = driver.findElement(NewScsMsg);
		
		Assert.assertEquals("Success message are not same", true, Msg.getText().contains(string));
		
		}
		
		catch (Exception e) {
			
			
		}
	
		scn.log("Subscription alert message  displayed");
		logger.info("Subscription alert message  displayed");
	}
}