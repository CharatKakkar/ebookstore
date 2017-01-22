package stepDefinition;

import org.junit.AfterClass;
import org.junit.runners.model.RunnerBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.test.RunnerClass;
import com.example.test.LoginTestRunnerClass;
import com.utility.TestHelper;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModel.HomePageObject;
import pageObjectModel.LoginPageObject;
import pageObjectModel.ProductsPageObject;
import pageObjectModel.RegisterPageObject;

public class TestRegisteration {

	private WebDriver driver;

	private LoginPageObject loginPageObject;
	private ProductsPageObject productsPageObject;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;

	@Before
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver",
		// "F:/Project/Selenium/chromedriver/chromedriver.exe");
		// driver = new ChromeDriver();
		driver=TestHelper.getSetUp().getDriver();
		//driver = TestHelper.getFetchBrowser().getDriver();
		//driver= RunnerClass.setUp();
		loginPageObject = new LoginPageObject(driver);
		productsPageObject = new ProductsPageObject(driver);
		homePageObject = new HomePageObject(driver);
		registerPageObject = new RegisterPageObject(driver);
		// baseUrl = "http://localhost:8080//";
		// driver.get(baseUrl + "/ebookstore/");
		// System.out.println("Setup of Registeration is now being executed");

	}

	@Given("^Registeration URl$")
	public void registeration_URl() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		System.out.println("IN Registration :(");
		driver.findElement(By.id("register")).click();
		// homePageObject.registerButton();
	}

	@Given("^User Details\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_Details(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7,
			String arg8, String arg9, String arg10) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		registerPageObject.streetNumberBilling(arg2);
		registerPageObject.unitNumberBilling(arg1);
	}

	@When("^I click on Go Button$")
	public void i_click_on_Go_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}

	@Then("^should get the successful message$")
	public void should_get_the_successful_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}

	@Then("^should be able to login with the credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void should_be_able_to_login_with_the_credentials(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}


	@AfterClass
	public static void tearDown() {
		System.out.println("Tear down of REgisteration  Class is now being executed");
		TestHelper.tearDown();

	}

}
