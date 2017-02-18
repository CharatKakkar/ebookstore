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
public class OrderCheckoutPageObject extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public OrderCheckoutPageObject(WebDriver driver) {
		super.pageFactoryInit(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(id = "editDetails")
	WebElement editButton;

	public void editDetailsClick() {
		editButton.click();
	}

	@FindBy(id = "Next")
	WebElement nextButton;

	public void nextDetailsClick() {
		nextButton.click();
	}

	@FindBy(id = "submit")
	WebElement submitButton;

	public void submitClick() {
		submitButton.click();
	}
}
