package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {

	  private WebDriver driver;

	  private String baseUrl;
	  
	  private boolean error=false;
	  
	  private String errstr = "";
	  

@Given("^Login URL$")
public void login_URL() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 
    System.setProperty("webdriver.chrome.driver", "/I:/Project/Selenium/chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://localhost:8080/";
    driver.get(baseUrl + "/ebookstore/");
    driver.findElement(By.linkText("Login")).click();

}

@Given("^Login Credentials \"([^\"]*)\" and \"([^\"]*)\"$")
public void login_Credentials_and(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions

    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys(arg1);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(arg2);
   

}

@When("^I click Login Button$")
public void i_click_Login_Button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.name("go")).click();


}

@Then("^the login credentials will be validated$")
public void the_login_credentials_will_be_validated() throws Throwable {
    // Write code here that turns the phrase above into concrete actions



}

@Then("^Products tab should be clicked$")
public void products_tab_should_be_clicked() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.linkText("Products")).click();
    driver.findElement(By.cssSelector("img[alt=\"image\"]")).click();
    driver.findElement(By.linkText("Back")).click();
}

@Then("^Logout should be clicked$")
public void logout_should_be_clicked() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
    driver.findElement(By.linkText("Logout")).click();

    driver.quit();

	  
}

@Then("^invalid credentials message should be passed$")
	public void invalid_credentials_message_should_be_passed() throws Throwable {
		if (driver.findElements(By.className("error")) != null) {
			if (!driver.findElement(By.className("error")).getAttribute("innerHTML").contains("Invalid Credentials")) {
				error = false;
				errstr+="Message is not correct, it is " + driver.findElement(By.className("error")).getAttribute("innerHTML");
			}

		}
		driver.quit();
		Assert.assertTrue(errstr,error);
    
}


}
