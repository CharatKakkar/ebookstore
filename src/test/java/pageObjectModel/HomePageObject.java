package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public HomePageObject(WebDriver driver) {
		super.pageFactoryInit(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//*[@id='navbar']/ul[1]/li[1]/a")
	WebElement homeButton;

	@FindBy(xpath = "//*[@id='navbar']/ul[1]/li[2]/a")
	WebElement productPage;

	@FindBy(linkText = "Login")
	WebElement loginLink;

	@FindBy(id = "register")
	WebElement registerationButton;

	public void loginLink() {
		loginLink.click();
	}

	public void registerButton() {
		registerationButton.click();
	}

	public void productPageClick() {
		productPage.click();
	}

	public void homeButtonClick() {
		homeButton.click();
	}

}
