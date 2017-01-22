package com.example.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.utility.TestHelper;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features" ,glue= "stepDefinition" , tags={"@Login"})
public class LoginTestRunnerClass {
	
	

//	private static  WebDriver driver;
//	//private static String baseUrl;
//	
//	
//	public static WebDriver setUp(){
//		driver= TestHelper.getSetUp().getDriver();		
//		return driver;
//	}

	@AfterClass
	public static void tearDown() {
	//	driver.quit();
		
		System.out.println("Tear down of Login Class is now being executed");
		TestHelper.tearDown();

	}
	
	

}
