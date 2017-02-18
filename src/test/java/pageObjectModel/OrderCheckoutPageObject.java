/**
 * 
 */
package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author charat
 *
 */
public class OrderCheckoutPageObject extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	Select dropdown;

	public OrderCheckoutPageObject(WebDriver driver) {
		super.pageFactoryInit(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(id = "editDetails")
	WebElement editButton;

	@FindBy(id = "ccnumber")
	WebElement ccNumber;
	
	
	@FindBy(id = "ccv")
	WebElement cvcNumber;

	@FindBy(id = "Next")
	WebElement nextButton;

	@FindBy(id = "submit")
	WebElement submitButton;
	
	@FindBy(id = "exp_month")
	WebElement expMonth;
	
	@FindBy(name = "exp_year")
	WebElement expYear;
	

	public void editDetailsClick() {
		editButton.click();
	}

	public void nextDetailsClick() {
		nextButton.click();
	}

	public void submitClick() {
		submitButton.click();
	}

	public void fillCreditCardInfo() {
		ccNumber.clear();
		ccNumber.sendKeys("1234567891234567");
		cvcNumber.sendKeys("234");
		dropdown = new Select(expMonth);
		dropdown.selectByValue("8");		
		dropdown = new Select(expYear);
		dropdown.selectByValue("2019");	

	}

}
