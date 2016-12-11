package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions ;
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 3);

	}

	@FindBy(id="web-logo-light")
	WebElement klipFolioIcon;
	
	public void klipFolioIcon(){
		klipFolioIcon.click();
	}
	@FindBy(xpath = "//p[@class='strong']")
	WebElement NoDashBoardMsg;

	public boolean findNoDashBoardMsg() {
		boolean found = false;
		try {
			if (NoDashBoardMsg.isDisplayed() && NoDashBoardMsg.getAttribute("innerHTML").contains("You don't have any dashboards")) {
				found = true;
			}
		} catch (NoSuchElementException e) {
		}
		return found;
	}

	@FindBy(xpath = "//*[@id='msg-no_tabs']//button[contains(.,'Add a Dashboard')]")
	WebElement AddDashBoard;

	public void AddDashBoardButton() {
		WebElement OAddDashBoard = wait.until(ExpectedConditions.visibilityOf(AddDashBoard));
		OAddDashBoard.click();
	}

	@FindBy(id = "b-add_blank_tab")
	WebElement addBlankDashBoard;

	public void addBlankDashBoardButton() {
		WebElement OaddBlankDashBoardd = wait.until(ExpectedConditions.visibilityOf(addBlankDashBoard));
		OaddBlankDashBoardd.click();
	}

	@FindBy(id = "tb-tab-add_klip")
	WebElement addToKlip;

	public void addAKlipButton() {
		WebElement OaddToKlip = wait.until(ExpectedConditions.visibilityOf(addToKlip));
		OaddToKlip.click();
	}

	@FindBy(id = "add-klip-gallery")
	WebElement klipGallery;

	public void klipGalleryTab() {
		WebElement KlipG = wait.until(ExpectedConditions.visibilityOf(klipGallery));
		KlipG.click();
	}

	@FindBy(id = "tb-tab-layout")
	WebElement layoutButton;

	public void layout() {
		layoutButton.click();
	}

	@FindBy(xpath="//*[@id='template-gallery-list']")
	WebElement klipList;

	public void getKlip(String value) {
		String path = "//*[@id='template-gallery-list']//span[.='" + value + "']";
		klipList.findElement(By.xpath(path)).click();
	}
		

	@FindBy(xpath = "//div[@class='template-item'][1]//div[contains (@class,'use-template-button')]")
	WebElement dashboard;

	public void dashboardButton() {
		WebElement odashBoard= wait.until(ExpectedConditions.visibilityOf(dashboard));
		odashBoard.click();
	}

	@FindBy(name = "ds.weather.location")
	WebElement location;

	public void locationTextBox(String city, String country) {
		try {
			location.clear();
			location.sendKeys(city, ",", country);
		} catch (NoSuchElementException e) {
		}
	}

	@FindBy(id = "template-step-continue")
	WebElement addKlip;

	public void addKlipButton() {
		WebElement OaddKlip= wait.until(ExpectedConditions.visibilityOf(addKlip));
		OaddKlip.click();
	}

	@FindBy(xpath = "//*[div[@class='template-flow-success']]")
	WebElement confirmation;

	public boolean confirmationMessage() {
		boolean is_successful = false;
		WebElement oConfirmation = wait.until(ExpectedConditions.visibilityOf(confirmation));
		if (oConfirmation.isDisplayed() && oConfirmation.getAttribute("innerHTML").contains("success")) {
			is_successful = true;
		}
		return is_successful;
	}

	@FindBy(xpath = "//button[@class='rounded-button primary' and contains (.,'Finished')]")
	WebElement finished;

	public void finishedButton() {
		finished.click();
	}

	@FindBy(xpath = "//div[@class='template-list gap-east-20']//div[@class='template-item'][1]//h1[1]")
	WebElement firstKlipOption;

	public String getFirstKlipOptionText() {
		String text = firstKlipOption.getAttribute("innerHTML");
		return text;
	}
	
	@FindBy(xpath="//button[contains(@class,'rounded-button secondary') and contains(.,'Connect Later')]")
	WebElement connectLater;

	public void connectLaterButton(){
		connectLater.click();
	}
}
