package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userName")
	WebElement userName;

	public void userName(String user) {
		userName.clear();
		userName.sendKeys(user);
	}

	@FindBy(id = "emailId")
	WebElement emailId;

	public void emailId(String email) {
		emailId.clear();
		emailId.sendKeys(email);
	}

	@FindBy(id = "password")
	WebElement password;

	public void password(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	@FindBy(id = "confirm")
	WebElement confirmPassword;

	public void confirmPassword(String cPass) {
		confirmPassword.clear();
		confirmPassword.sendKeys(cPass);
	}

	@FindBy(id = "unitNumberB")
	WebElement unitNumberB;

	public void unitNumberBilling(String uNumBill) {
		unitNumberB.clear();
		unitNumberB.sendKeys(uNumBill);
	}

	@FindBy(id = "streetNumberB")
	WebElement streetNumberB;

	public void streetNumberBilling(String sNumBill) {
		streetNumberB.clear();
		streetNumberB.sendKeys(sNumBill);
	}

	@FindBy(id = "provinceB")
	WebElement provinceB;

	public void provinceBilling(String pBilling) {
		provinceB.clear();
		provinceB.sendKeys(pBilling);
	}

	@FindBy(id = "countryB")
	WebElement countryB;

	public void countryBilling(String cBilling) {
		countryB.clear();
		countryB.sendKeys(cBilling);
	}

	@FindBy(id = "zipCodeB")
	WebElement zipCodeB;

	public void zipCodeBilling(String zipCodeBilling) {
		zipCodeB.clear();
		zipCodeB.sendKeys(zipCodeBilling);
	}

	@FindBy(id = "answerIsYes")
	WebElement answerIsYes;

	public void answerIsYesButton(String anIsYes) {
		answerIsYes.clear();
		answerIsYes.sendKeys(anIsYes);
	}

	@FindBy(id = "answerIsNo")
	WebElement answerIsNo;

	public void answerIsNoButton(String anIsNo) {
		answerIsNo.clear();
		answerIsNo.sendKeys(anIsNo);
	}

	@FindBy(id = "unitNumberS")
	WebElement unitNumberS;

	public void unitNumberShipping(String uNumBill) {
		unitNumberB.clear();
		unitNumberB.sendKeys(uNumBill);
	}

	@FindBy(id = "streetNumberS")
	WebElement streetNumberS;

	public void streetNumberShipping(String sNumBill) {
		streetNumberB.clear();
		streetNumberB.sendKeys(sNumBill);
	}

	@FindBy(id = "provinceS")
	WebElement provinceS;

	public void provinceShipping(String pShipping) {
		provinceB.clear();
		provinceB.sendKeys(pShipping);
	}

	@FindBy(id = "countryS")
	WebElement countryS;

	public void countryShipping(String cShipping) {
		countryB.clear();
		countryB.sendKeys(cShipping);
	}

	@FindBy(id = "zipCodeS")
	WebElement zipCodeS;

	public void zipCodeShipping(String zipCodeShipping) {
		zipCodeB.clear();
		zipCodeB.sendKeys(zipCodeShipping);
	}

	@FindBy(name = "go")
	WebElement signUp;

	public void signUp() {
		signUp.click();
	}

}
