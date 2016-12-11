package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddKlipPageClass {

	WebDriver driver;
	WebDriverWait wait;

	public AddKlipPageClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 3);

	}

	@FindBy(xpath = "//button[@class='rounded-button primary' and contains (.,'Finished')]")
	WebElement finished;

	@FindBy(xpath = "//div[@class='template-list gap-east-20']//div[@class='template-item'][1]//h1[1]")
	WebElement firstKlipOption;

	@FindBy(xpath = "//button[contains(@class,'rounded-button secondary') and contains(.,'Connect Later')]")
	WebElement connectLater;

	@FindBy(xpath = "//*[div[@class='template-flow-success']]")
	WebElement confirmation;

	@FindBy(name = "ds.weather.location")
	WebElement location;

	@FindBy(id = "add-klip-gallery")
	WebElement klipGallery;

	@FindBy(id = "template-step-continue")
	WebElement addKlip;

	public void finishedButton() {
		finished.click();
	}

	public String getFirstKlipOptionText() {
		String text = firstKlipOption.getAttribute("innerHTML");
		return text;
	}

	public void connectLaterButton() {
		connectLater.click();
	}

	public boolean confirmationMessage() {
		boolean is_successful = false;
		WebElement oConfirmation = wait.until(ExpectedConditions.visibilityOf(confirmation));
		if (oConfirmation.isDisplayed() && oConfirmation.getAttribute("innerHTML").contains("success")) {
			is_successful = true;
		}
		return is_successful;
	}

	public void locationTextBox(String city, String country) {
		location.clear();
		location.sendKeys(city, ",", country);
	}

	public void addKlipButton() {
		WebElement OaddKlip = wait.until(ExpectedConditions.visibilityOf(addKlip));
		OaddKlip.click();
	}

	public void klipGalleryTab() {
		WebElement KlipG = wait.until(ExpectedConditions.visibilityOf(klipGallery));
		KlipG.click();
	}

}
