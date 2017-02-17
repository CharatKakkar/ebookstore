package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.TestHelper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModel.HomePageObject;
import pageObjectModel.LoginPageObject;
import pageObjectModel.ProductsPageObject;

public class TestLogin {

	private WebDriver driver;

	private Boolean error = Boolean.FALSE;

	private String errstr = "";

	private LoginPageObject loginPageObject;
	private ProductsPageObject productsPageObject;
	private HomePageObject homePageObject;

	@Before
	public void setUp() {
		driver = TestHelper.getSetUp().getDriver();
		loginPageObject = new LoginPageObject(driver);
		productsPageObject = new ProductsPageObject(driver);
		homePageObject = new HomePageObject(driver);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				driver.quit();
			}
		});
		
	}

	@Given("^Login URL$")
	public void loginURL() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// driver.findElement(By.linkText("Login")).click();
		homePageObject.loginLink();
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

	@Then("^the login credentials should be valid$")
	public void the_login_credentials_should_be_validated() throws Throwable {
		if (loginPageObject.getErrorMessage().contains("Invalid Credentials")) {
			error = true;
			errstr = "Invalid credentials have been passed";
		}
		Assert.assertTrue(errstr, !error);
	}

	@Then("^Products tab should be clicked$")
	public void products_tab_should_be_clicked() throws Throwable {
		homePageObject.productPageClick();
		productsPageObject.selectProductTableDropdown("25");
		productsPageObject.productTable();
	}

	@Then("^Logout should be clicked$")
	public void logout_should_be_clicked() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Logout")).click();

	}

	@Then("^invalid credentials message should be passed$")
	public void invalid_credentials_message_should_be_passed() throws Throwable {
		if (loginPageObject.getErrorMessage() == "") {
			error = Boolean.TRUE;
			errstr = "Invalid Credentials were accepted";
		}
		Assert.assertTrue(errstr, !error);
	}

}
