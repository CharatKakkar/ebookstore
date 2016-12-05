/**
 * 
 */
package pageObjectModel;

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

	@FindBy(name = "password")
	WebElement password;

	@FindBy(how=How.XPATH, using="//*[@type='submit']")
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

}
