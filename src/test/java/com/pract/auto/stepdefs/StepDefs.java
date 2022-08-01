	package com.pract.auto.stepdefs;
	
	import java.awt.Desktop.Action;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.junit.Ignore;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	import com.pract.auto.PageObjects.CommonPageObjects;
	import com.pract.auto.PageObjects.FooterSectionObjects;
import com.pract.auto.PageObjects.ProductCategoryObject;
	import com.pract.auto.PageObjects.SearchProdPagObjects;
	import com.pract.auto.PageObjects.SignInPageObject;
import com.pract.auto.PageObjects.RandomNoGeneratorUtils;
import com.pract.auto.core.WebDriverFactory;
	
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import junit.framework.Assert;
	
	public class StepDefs {
	
		
		private static final Logger logger = LogManager.getLogger(StepDefs.class);
	
		WebDriver driver;
		String url = "http://automationpractice.com/";
	    int implicit_wait_timeout_in_sec = 20;
	    Scenario scn;
	    WebDriverWait wait; 
	    JavascriptExecutor js;
	    
	    CommonPageObjects commonPageObjects;
	    FooterSectionObjects footerSectionObjects;
	    ProductCategoryObject productCategoryObject;
	    SearchProdPagObjects searchProdPagObjects;
	    SignInPageObject signInPageObject;
	    RandomNoGeneratorUtils randomNoGeneratorUtils;
	    
	    
	    
	//*******************************************************************************************************//
	    
	    @Before
	    public void setUp(Scenario scn) throws Exception{
	        this.scn = scn; 
	        String browserName = com.pract.auto.core.WebDriverFactory.setBrowser();
	        driver = com.pract.auto.core.WebDriverFactory.webDriverforBrowser(browserName);
	        scn.log("Browser invoked.");
	        logger.info("Browser invoked.");
	        
	//*******************************************************************************************************//   
	
	
	        commonPageObjects = new CommonPageObjects(driver, scn);
	        footerSectionObjects = new FooterSectionObjects(driver, scn);
	        productCategoryObject = new ProductCategoryObject(driver, scn);
	        searchProdPagObjects = new SearchProdPagObjects(driver, scn);
	        signInPageObject = new SignInPageObject(driver, scn);
	        randomNoGeneratorUtils = new RandomNoGeneratorUtils(driver, scn);
	       }
	    
	//****************************************Screenshot*****************************************************
	    @After(order=1)
	    public void cleanUp(){
	        com.pract.auto.core.WebDriverFactory.quitDriver();
	    }
		
	//****************************************Screenshot*****************************************************
	
	    @After(order=2)
	    public void takeScreenShot(Scenario s)
	    {
	        if (s.isFailed()) {
	            TakesScreenshot scrnShot = (TakesScreenshot)driver;
	            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
	            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
	        }
	        else{
	            scn.log("Test case: is passed, no screen shot captured");
	        }
	    }
	
	  //****************************************Screenshot*****************************************************
	
	    
	    @Given("navigate to the home application URL")
	    public void navigate_to_the_home_application_url() {
	 
	    	WebDriverFactory.navigateToTheURL(url);
	    }
	    
	    
	 //****************************************Scenario 1****************************************************//
	
	//    1st case:Redirection Test
	    
	    @When("Open Landing Page")
	    public void open_landing_page() {
//	    	commonPageObjects.NavigationURL();
	    	
	    scn.log("Entered the Website" + url);
	    logger.info("Entered the Website" + url);
	    }

	    @Then("it will be redirected as {string}")
	    public void it_will_be_redirected_as(String string) {
	        commonPageObjects.RedirectURL(string);
	    }
	    
	    
	// ****************************************Scenario 2*****************************************************//
	   
	//   2nd case: Landing page Title Test
     
	    @When("landing page is displayed")
	    public void landing_page_is_displayed() {
//	    	driver.get(base_url);
	    }

	    @Then("Title Should be {string}")
	    public void title_should_be(String string) {
	     
	    	commonPageObjects.MyStore(string);
	    	scn.log("The Title of landing page is :" + driver.getTitle() );
	    	logger.info("The Title of landing page is :" + driver.getTitle() );
	    }
	
	    
	 // ****************************************Scenario 3*****************************************************//
	
	// 3rd case: Product Category Validation
	    
	    @When("User Search for product category")
	    public void user_search_for_product_category() {
	//    	productCategoryObject.prodcat();
	    }
	
	
	    @Then("category should be displayed on the landing page is")
	    public void category_should_be_displayed_on_the_landing_page_is(List<String> product_category) {
	    	
	    	productCategoryObject.prodcateg(product_category);
	    	
	    }
	    
	    @Then("size of product category is {int}")
	    public void size_of_product_category_is(Integer int1) {
	     
	    	productCategoryObject.count(int1); 
	    }
	
	
	 // ****************************************Scenario 4*****************************************************//
	
	// 4th case: Check the logo's on the Landing Page
		
	    @When("navigation to base_URL")
	    
		public void navigation_to_url() {
	//	driver.get(base_url);
		
		}
		
		@Then("the logo on the landing page should be displayed")
		public void the_logo_on_the_landing_page_should_be_displayed()
		{
			commonPageObjects.logoDisp();
			scn.log("Logo is displayed on the landing page");
		}
		
		
	// ****************************************Scenario 5*****************************************************//
		    
	// 5th case: Check the logo's height on the Landing Page
		
	@When("logo is displayed on the landing page")
	public void logo_is_displayed_on_the_landing_page() {
		
		scn.log("Logo is available on the landing page");
	
	}
	@Then("the logo height should be {string}")
	public void the_logo_height_should_be(String string)
	{
		commonPageObjects.logoHeight(string);
		scn.log("Logo height is" + string);
		logger.info("Logo height is" + string);
		}
	    
	//****************************************Scenario 6*****************************************************//
	
	//6th case:  Check the logo's width on the Landing Page
	
	@When("logo is displayed on landing page")
	public void logo_is_displayed_on_landing_page() {
		
		scn.log("Logo is available on the landing page");
	}
	
	@Then("the logo width should be {string}")
	public void the_logo_width_should_be(String string) 
	{
		commonPageObjects.logoWidth(string);
		
		scn.log("Logo width is" + string);
		logger.info("Logo width is" + string);

	
	}
	
	//****************************************Scenario 7*****************************************************//
	
	//	7th case: Check the Title of Sign In Page 
	
		@When("User clicks on the Sign In button")
		public void user_clicks_on_the_Sign_In_button() {
		
			signInPageObject.SignIn();
				}
	
		@Then("next page title should be {string}")
		public void next_page_title_should_be(String string) 
		{
			signInPageObject.SignInTitle(string);
	
		}
	
	//****************************************Scenario 8*****************************************************//
	
	
	//8 case:Check the search box and Product list 
	
	@When("Search box is displayed on the landing page")
	public void search_box_is_displayed_on_the_landing_page()
	{
		searchProdPagObjects.SearchB();
		
	}
	
	@When("User search for the product {string} in the given search box")
	public void user_search_for_the_product_in_the_given_search_box(String string)
	{
		searchProdPagObjects.searchProd(string);
	   
	}
	
	@Then("counts the number of product in the list contain the keyword {string} in it")
	public void counts_the_number_of_product_in_the_list_contain_the_keyword_in_it(String string)
	{
		searchProdPagObjects.NoPro(string);
	}
	
	
	//****************************************Scenario 9*****************************************************//
	
	//9 case: Twitter Account Validation 
	
	@When("User clicks on the Twitter link social media handle")
	public void user_clicks_on_the_twitter_link_social_media_handle() 
	{
		footerSectionObjects.Tweeter(driver);
	}
	
	@Then("Twitter Account should be opened")
	public void twitter_account_should_be_opened() {
		
		WebDriverFactory.SwitchtoTab();
		
	    scn.log("Switched to the new window/tab");
		 
	  }
	
	@Then("Twitter Account name should be {string}")
	public void twitter_account_name_should_be(String string)
	{
		footerSectionObjects.TweeterName(string);
	    scn.log("Tweeter Account name is matched and displayed as: " + string);
	
	}
	
	
	//****************************************Scenario 10*****************************************************//
	
	    //10th case: Newsletter Subscription Validation

	@When("User enters his\\/her Email-ID in newsletter subscription text box")
	public void user_enters_his_her_email_id_in_newsletter_subscription_text_box() {
	   
		footerSectionObjects.NewsBox();
	}


	@Then("message text should be displayed for the successful email subscription as {string}")
	public void message_text_should_be_displayed_for_the_successful_email_subscription_as(String string) {
	   
		footerSectionObjects.SuccessMsg(string);
	}

	}
	
	