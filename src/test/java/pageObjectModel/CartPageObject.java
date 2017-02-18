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
public class CartPageObject extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public CartPageObject(WebDriver driver) {
		super.pageFactoryInit(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(id = "checkOut")
	WebElement checkoutButton;

	public void checkoutButtonClick() {
		checkoutButton.click();
	}
}
