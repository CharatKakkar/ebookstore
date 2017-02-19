/**
 * 
 */
package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author charat
 *
 */
public class ForgotPasswordPageObject extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public ForgotPasswordPageObject(WebDriver driver) {
		super.pageFactoryInit(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(id = "checkOut")
	WebElement checkoutButton;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "cPassword")
	WebElement cPassword;

	@FindBy(id = "secretPhrase")
	WebElement secretPhrase;

	@FindBy(id = "emailId")
	WebElement emailId;

	@FindBy(name = "go")
	WebElement resetPasswordButton;

	public void enterUsername(String user) {
		username.clear();
		username.sendKeys(user);
	}

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void enterCpassword(String pass) {
		cPassword.clear();
		cPassword.sendKeys(pass);
	}

	public void enterSPhrase(String phrase) {
		secretPhrase.clear();
		secretPhrase.sendKeys(phrase);
	}

	public void enterEmail(String emailIdval) {
		emailId.clear();
		emailId.sendKeys(emailIdval);
	}

	public void resetPasswordButtonClick() {
		resetPasswordButton.click();
	}
}
