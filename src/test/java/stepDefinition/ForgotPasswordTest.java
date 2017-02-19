/**
 * 
 */
package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utility.TestHelper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjectModel.CartPageObject;
import pageObjectModel.ForgotPasswordPageObject;
import pageObjectModel.HeaderPageObject;
import pageObjectModel.HomePageObject;
import pageObjectModel.LoginPageObject;
import pageObjectModel.OrderCheckoutPageObject;
import pageObjectModel.ProductsPageObject;

/**
 * @author charat
 *
 */
public class ForgotPasswordTest {

	private WebDriver driver;

	private LoginPageObject loginPageObject;
	private ProductsPageObject productsPageObject;
	private HomePageObject homePageObject;
	private HeaderPageObject headerPageObject;
	private CartPageObject cartPageObject;
	private OrderCheckoutPageObject orderCheckoutPageObject;
	private ForgotPasswordPageObject forgotPasswordPageObject;

	@Before
	public void setUp() {
		driver = TestHelper.getSetUp().getDriver();
		loginPageObject = new LoginPageObject(driver);
		productsPageObject = new ProductsPageObject(driver);
		homePageObject = new HomePageObject(driver);
		headerPageObject = new HeaderPageObject(driver);
		cartPageObject = new CartPageObject(driver);
		orderCheckoutPageObject = new OrderCheckoutPageObject(driver);
		forgotPasswordPageObject = new ForgotPasswordPageObject(driver);

		// super.shutdownHook(driver);
	}

	// @Given("^Login URL$")
	// public void login_URL() {
	// homePageObject.loginLink();
	// }

	@Then("^Click on Forgot Password$")
	public void click_on_Forgot_Password() {
		loginPageObject.forgotPasswordLinkClick();
	}

	@Then("^Fill in the details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_in_the_details(String arg1, String arg2, String arg3, String arg4) {

	
		forgotPasswordPageObject.enterUsername(arg1);
		forgotPasswordPageObject.enterPassword(arg3);
		forgotPasswordPageObject.enterCpassword(arg3);
		forgotPasswordPageObject.enterSPhrase(arg2);
		forgotPasswordPageObject.enterEmail(arg4);
	}

	@Then("^Click Reset Password button$")
	public void click_Reset_Password_button() {
		forgotPasswordPageObject.resetPasswordButtonClick();
	}

	@Then("^Verify that Success message is received$")
	public void verify_that_Success_message_is_received() {
		System.out.println("message is " + loginPageObject.getMessage());
		if ( !loginPageObject.getMessage().contains("has been reset successfully")){
			Assert.assertFalse(true, "Password reset functionality failed");;
		}
	}

	@Then("^Login with new credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_with_new_credentials(String arg1, String arg2) {
		loginPageObject.enterUsername(arg1);
		loginPageObject.enterPassword(arg2);
		loginPageObject.clickLogin();

	}
}
