package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass {

	WebDriver driver;
	WebDriverWait wait;

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);

	}

	@FindBy(id = "web-logo-light")
	WebElement klipfolioIcon;

	@FindBy(xpath = "//p[@class='strong']")
	WebElement NoDashBoardMsg;

	@FindBy(xpath = "//*[@id='msg-no_tabs']//button[contains(.,'Add a Dashboard')]")
	WebElement AddDashBoard;

	@FindBy(id = "b-add_blank_tab")
	WebElement addBlankDashBoard;

	@FindBy(id = "tb-tab-add_klip")
	WebElement addKlip;

	@FindBy(xpath = "//*[@id='template-gallery-list']")
	WebElement klipList;

	@FindBy(xpath = "//div[@class='template-item'][1]//div[contains (@class,'use-template-button')]")
	WebElement dashboard;

	public void klipfolioIcon() {
		klipfolioIcon.click();
	}

	public boolean findNoDashBoardMsg() {
		boolean found = false;
		if (NoDashBoardMsg.isDisplayed()
				&& NoDashBoardMsg.getAttribute("innerHTML").contains("You don't have any dashboards")) {
			found = true;
		}
		return found;
	}

	public void AddDashBoardButton() {
		WebElement OAddDashBoard = wait.until(ExpectedConditions.visibilityOf(AddDashBoard));
		OAddDashBoard.click();
	}

	public void addBlankDashBoardButton() {
		WebElement OaddBlankDashBoardd = wait.until(ExpectedConditions.visibilityOf(addBlankDashBoard));
		OaddBlankDashBoardd.click();
	}

	public void addAKlipButton() {
		WebElement OaddKlip = wait.until(ExpectedConditions.visibilityOf(addKlip));
		OaddKlip.click();
	}

	public void getKlip(String value) {
		String path = "//*[@id='template-gallery-list']//span[.='" + value + "']";
		WebElement oKlipList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		oKlipList.click();
	}

	public void dashboardButton() {
		WebElement odashBoard = wait.until(ExpectedConditions.visibilityOf(dashboard));
		odashBoard.click();
	}

}
