@ui @healthcheck
Feature: E-commerce project website health check

#######################################################################################################

		 Background: Navigation to the URL
     Given navigate to the home application URL
    
    
@1_RedirectionTest
		Scenario: Landing Page URL Redirection Test 
		
		When  Open Landing Page
		Then it will be redirected as "http:automationpractice.com/index.php"

#######################################################################################################

@2_LandingTitleTest
		 Scenario: Landing Page Title Check
		 
		When landing page is displayed                                                                                                 
		Then Title Should be "My Store"

#######################################################################################################

@3_ProductCategory_validationTest
			Scenario: Product Category Validation

		  When User Search for product category 
		  Then category should be displayed on the landing page is
  
  		|product_category|
	  	| WOMEN 				 | 		 
	    | DRESSES 		   |
	    | T-SHIRTS		   |
    
      And size of product category is 3
   
#######################################################################################################   
    
@4_LandingLogo
		 Scenario: Check the logo on the Landing Page
		 
		When navigation to base_URL
		Then the logo on the landing page should be displayed

#######################################################################################################

@5_ValidateLogoHeight_Landing 
		Scenario: Check the Logo Height on the Landing Page
		
		When logo is displayed on the landing page
		Then the logo height should be 99

#######################################################################################################

@6_Validate_LogoWidth_Landing 
		Scenario: Check the Logo width on the Landing Page
		
		When logo is displayed on landing page
		Then the logo width should be 350

#######################################################################################################

@7_SignIn_Page_Title_Validation
			Scenario: Check the Title of Sign In Page
			
			When User clicks on the Sign In button
			Then next page title should be "Login - My Store"

#######################################################################################################
    
@8_productSearchBox_andValidation
			Scenario: Check the search box and Product list 
			
			When Search box is displayed on the landing page
			And User search for the product "Dress" in the given search box
			
			Then counts the number of product in the list contain the keyword "Dress" in it

#######################################################################################################
    
@9_ValidateTwitter
			Scenario: Twitter Account Validation 
			
			When User clicks on the Twitter link social media handle
			
			Then Twitter Account should be opened 
			And Twitter Account name should be "Selenium Framework"
			
#######################################################################################################

@10_Newsletter_Subscription
			Scenario: Newsletter Subscription Validation
			
			When User enters his/her Email-ID in newsletter subscription text box 
			
			Then message text should be displayed for the successful email subscription
    
####################################################################################################### 
