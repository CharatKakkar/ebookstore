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
public class HeaderPageObject extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public HeaderPageObject(WebDriver driver) {
		super.pageFactoryInit(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(id = "ebookstore")
	WebElement ebookstoreLogo;

	@FindBy(id = "home")
	WebElement homeButton;

	@FindBy(id = "cart")
	WebElement cartButton;

	@FindBy(id = "products")
	WebElement productsButton;

	public void ebookstoreLogoClick() {
		ebookstoreLogo.click();

	}

	public void homeButtonClick() {
		homeButton.click();

	}

	public void cartButtonClick() {
		cartButton.click();

	}

	public void productsButtonClick() {
		productsButton.click();

	}

}
