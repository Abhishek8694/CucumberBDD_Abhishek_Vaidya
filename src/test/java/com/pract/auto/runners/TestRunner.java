package com.pract.auto.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
	features = "classpath:features",
	glue = "com.pract.auto.stepdefs",
	tags = "",
	plugin = { "pretty",
			"html:target/html/htmlreport.html",
			"json:target/json/jsonreport.json"
			},
	monochrome = true,
	publish = true,
	dryRun = false
		)
public class TestRunner { 

}
