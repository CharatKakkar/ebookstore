

/**
 * 
 */
package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.utility.TestHelper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import pageObjectModel.ForgotPasswordPageObject;
import pageObjectModel.LoginPageObject;

/**
 * @author charat
 *
 */
public class ForgotPasswordTest {

	private WebDriver driver;

	private LoginPageObject loginPageObject;
	private ForgotPasswordPageObject forgotPasswordPageObject;

	@Before
	public void setUp() {
		driver = TestHelper.getSetUp().getDriver();
		loginPageObject = new LoginPageObject(driver);
		forgotPasswordPageObject = new ForgotPasswordPageObject(driver);

		// super.shutdownHook(driver);
	}

	// @Given("^Login URL$")
	// public void login_URL() {
	// homePageObject.loginLink();
	// }

	@Then("^Click on Forgot Password$")
	public void click_on_Forgot_Password() throws InterruptedException {
		loginPageObject.forgotPasswordLinkClick();
		Thread.sleep(2500);
	}

	@Then("^Fill in the details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_in_the_details(String arg1, String arg2, String arg3, String arg4) throws InterruptedException {

	
		forgotPasswordPageObject.enterUsername(arg1);
		forgotPasswordPageObject.enterPassword(arg3);
		forgotPasswordPageObject.enterCpassword(arg3);
		forgotPasswordPageObject.enterSPhrase(arg2);
		forgotPasswordPageObject.enterEmail(arg4);
		Thread.sleep(2500);
	}

	@Then("^Click Reset Password button$")
	public void click_Reset_Password_button() throws InterruptedException {
		forgotPasswordPageObject.resetPasswordButtonClick();
		Thread.sleep(2500);
	}

	@Then("^Verify that Success message is received$")
	public void verify_that_Success_message_is_received() throws InterruptedException {
		System.out.println("message is " + loginPageObject.getMessage());
		if ( !loginPageObject.getMessage().contains("has been reset successfully")){
			Assert.assertFalse("Password reset functionality failed", true);
			
		}
		Thread.sleep(2500);
	}

	@Then("^Login with new credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_with_new_credentials(String arg1, String arg2) throws InterruptedException {
		loginPageObject.enterUsername(arg1);
		loginPageObject.enterPassword(arg2);
		loginPageObject.clickLogin();
		Thread.sleep(2500);

	}
}
