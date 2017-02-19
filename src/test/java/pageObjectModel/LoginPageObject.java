/**
 * 
 */
package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Charat Kakkar
 *
 */
public class LoginPageObject extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPageObject(WebDriver driver) {
		super.pageFactoryInit(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "forgotPassword")
	WebElement forgotPasswordLink;

	@FindBy(className = "error")
	List<WebElement> error;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement login;

	public void enterUsername(String user) {
		username.clear();
		username.sendKeys(user);
	}

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void clickLogin() {
		login.click();
	}

	public void forgotPasswordLinkClick() {
		forgotPasswordLink.click();
	}

	public String getErrorMessage() {
		String errorMessage = "";
		if (error.size() > 0) {
			for (WebElement err : error) {
				errorMessage = err.getAttribute("innerHTML");
			}
		}
		return errorMessage;
	}
}
