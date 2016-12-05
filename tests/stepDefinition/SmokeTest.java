package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModel.HomePageObject;
import pageObjectModel.LoginPageObject;
import pageObjectModel.ProductsPageObject;

public class SmokeTest {

	private WebDriver driver;

	private String baseUrl;

	private boolean error = false;

	private String errstr = "";

	private LoginPageObject loginPageObject;
	private ProductsPageObject productsPageObject;
	private HomePageObject homePageObject;

	@Given("^Login URL$")
	public void login_URL() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver", "/I:/Project/Selenium/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();
		loginPageObject = new LoginPageObject(driver);
		productsPageObject = new ProductsPageObject(driver);
		baseUrl = "http://localhost:8080/";
		driver.get(baseUrl + "/ebookstore/");
		driver.findElement(By.linkText("Login")).click();

	}

	@Given("^Login Credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_Credentials_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPageObject.enterUsername(arg1);
		loginPageObject.enterPassword(arg2);
	}

	@When("^I click Login Button$")
	public void i_click_Login_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPageObject.clickLogin();
	}

	@Then("^the login credentials will be validated$")
	public void the_login_credentials_will_be_validated() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^Products tab should be clicked$")
	public void products_tab_should_be_clicked() throws Throwable {
		homePageObject.productPageClick();
		productsPageObject.productTable();
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
				errstr += "Message is not correct, it is "
						+ driver.findElement(By.className("error")).getAttribute("innerHTML");
			}

		}
		driver.quit();
		Assert.assertTrue(errstr, error);

	}

}
