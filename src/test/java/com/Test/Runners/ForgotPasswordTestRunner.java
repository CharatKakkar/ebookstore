/**
 * 
 */
package com.Test.Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

/**
 * @author charat
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = "stepDefinition", tags = { "@ForgotPasswordTest" })
public class ForgotPasswordTestRunner {


}
