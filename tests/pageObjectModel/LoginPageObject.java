/**
 * 
 */
package pageObjectModel;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Charat Kakkar
 *
 */
public class LoginPageObject {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement username;

	public void enterUsername(String user) {
		username.clear();
		username.sendKeys(user);
	}

	@FindBy(name = "password")
	WebElement password;

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	WebElement login;

	public void clickLogin() {
		login.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@class='error']")
	WebElement error;

	public String errorMessage() {
		String msg = "";
		try {
			msg = error.getAttribute("innerHTML");
			return msg;
		} catch (NoSuchElementException e) {
			return msg;
		}
	}
}
