package com.pract.auto.core;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;

public class WebDriverFactory
{
	
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	private static WebDriver driver = null;
	
	public static WebDriver webDriverforBrowser (String browser) throws Exception {
		switch(browser.toLowerCase())
		{
		case "chrome": 
		driver = new ChromeDriver();
		logger.info("Chrome browser invoked");
		break;
		
		case "firefox":
			driver = new FirefoxDriver();
			logger.info("Firefox browser invoked");
			break;
		case "headless":
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);
            logger.info("Headless Chrome Browser invoked");
            break;
        default:
            logger.fatal("No such browser is implemented.Browser name sent: " + browser);
            throw new Exception("No such browser is implemented.Browser name sent: " + browser);
    }
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
        logger.info("Driver maximized and implicit time out set to 20 seconds");
        return driver;
	}
	
	 public static void navigateToTheURL(String url)
	 {
		    driver.get(url);
	        logger.info("Browser is navigated to the URL:" + url);
	    }

	    public static void quitDriver(){
	        driver.quit();
	        logger.info("Driver closed");
	    }
	    
	    public static void SwitchtoTab() {
	    	
	    Set<String> handles = driver.getWindowHandles(); 
	   
	    Iterator<String> it = handles.iterator(); 
	    String original = it.next();
	    String TweetWeb = it.next();
	    
	    driver.switchTo().window(TweetWeb); // switch to product Descp
}
	    public static String setBrowser(){
	        String browserByDefault = "chrome"; 
	        String browserSentFromComnd = System.getProperty("browser");

	        if (browserSentFromComnd==null){
	            return browserByDefault;
	        }else{
	            return browserSentFromComnd;
	        }
	    } 
	}