package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {

	WebDriver driver;

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "f-username")
	WebElement username;

	public void enterUsername(String name) {
		username.clear();
		username.sendKeys(name);
	}

	@FindBy(id = "f-password")
	WebElement password;

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	@FindBy(id = "login")
	WebElement loginButton;

	public void login() {
		loginButton.click();
	}

}
