package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.utility.TestHelper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModel.BaseClass;
import pageObjectModel.HeaderPageObject;
import pageObjectModel.HomePageObject;
import pageObjectModel.LoginPageObject;
import pageObjectModel.ProductsPageObject;
import pageObjectModel.RegisterPageObject;

public class TestRegisteration extends BaseClass{

	private WebDriver driver;
	private Boolean error = Boolean.FALSE;
	private String errstr = "";
	private LoginPageObject loginPageObject;
	private ProductsPageObject productsPageObject;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	private HeaderPageObject headerPageObject;

	@Before
	public void setUp() {
		driver = TestHelper.getSetUp().getDriver();
		loginPageObject = new LoginPageObject(driver);
		homePageObject = new HomePageObject(driver);
		registerPageObject = new RegisterPageObject(driver);
		headerPageObject = new HeaderPageObject(driver);
		super.shutdownHook(driver);

	}

	@Given("^Registeration URl$")
	public void registeration_URl() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		homePageObject.registerButton();
		Thread.sleep(2500);
	}
	
	@Given("^User Details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_Details(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		registerPageObject.userName(arg1);
		registerPageObject.password(arg2);
		registerPageObject.confirmPassword(arg2);
		registerPageObject.emailId(arg3);
		registerPageObject.securityPhrase(arg4);
		registerPageObject.unitNumberBilling(arg5);
		registerPageObject.streetNumberBilling(arg6);
		registerPageObject.cityB(arg7);
		registerPageObject.provinceBilling(arg8);
		registerPageObject.countryBilling(arg9);
		registerPageObject.zipCodeBilling(arg10);
		Thread.sleep(2500);
	}



	@Given("^user Response on Shipping/Billing Address$")
	public void user_Response_on_Shipping_Billing_Address() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		registerPageObject.answerIsNoButton();
		Thread.sleep(2500);
	}

	@When("^I click on Go Button$")
	public void i_click_on_Go_Button() throws InterruptedException  {
		registerPageObject.signUp();
		Thread.sleep(2500);
	}

	@Then("^should get the successful message$")
	public void should_get_the_successful_message() throws InterruptedException {

			if (!registerPageObject.getMessage().contains("successful")) {
				errstr = "Registeration was unsuccessful";
				error = Boolean.TRUE;
			}
			Assert.assertTrue(errstr, !error);
			Thread.sleep(2500);
	}

	@Then("^should be able to login with the credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void should_be_able_to_login_with_the_credentials(String arg1, String arg2) throws InterruptedException {
		loginPageObject.enterUsername(arg1);
		loginPageObject.enterPassword(arg2);
		loginPageObject.clickLogin();
		headerPageObject.logoutButtonClick();
		Thread.sleep(2500);

	}
		
}
