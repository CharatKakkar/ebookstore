package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='navbar']/ul[1]/li[1]/a")
	WebElement homeButton;

	@FindBy(xpath = "//*[@id='navbar']/ul[1]/li[2]/a")
	WebElement productPage;

	@FindBy(linkText = "Login")
	WebElement loginLink;

	@FindBy(id = "register")
	WebElement registerationButton;

	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
