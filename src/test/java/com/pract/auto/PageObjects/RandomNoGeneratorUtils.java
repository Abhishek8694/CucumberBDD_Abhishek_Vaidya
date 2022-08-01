package com.pract.auto.PageObjects;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class RandomNoGeneratorUtils {
	
	private static final Logger logger = LogManager.getLogger(FooterSectionObjects.class);

	WebDriver driver;
	Scenario scn;
	WebDriver wait;
	
//	constructor
	public RandomNoGeneratorUtils(WebDriver driver, Scenario scn ) {
		this.driver = driver;
		this.scn = scn;
		this.wait = wait;
		
	}
	
		public static String randomStringGenerator () {
			Random random = new Random();
			String randomName = "";
			
			for (int i=0; i<10; i++)
			{
				char characterRandom = (char)(random.nextInt(26)+97);
				if(random.nextBoolean())
				{
					characterRandom = Character.toUpperCase(characterRandom);
					randomName = randomName + characterRandom;
				}
			}
				
			randomName =randomName+"@gmail.com";
			
			return randomName;
		}

}
