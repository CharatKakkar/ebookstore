package com.Test.Runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = "stepDefinition", tags = { "@ForgotPasswordTest" })
public class LoginTestRunnerClass {

}
