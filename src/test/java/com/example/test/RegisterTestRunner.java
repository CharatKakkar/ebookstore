package com.example.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.utility.TestHelper;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features" ,glue= "stepDefinition" , tags={"@Register"})
public class RegisterTestRunner {
//
//	@AfterClass
//	public static void tearDown() {	
//		TestHelper.tearDown();
//
//	}
//	
	
}
