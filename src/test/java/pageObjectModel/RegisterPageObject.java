package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObject extends BaseClass {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userName")
	WebElement userName;

	@FindBy(id = "emailId")
	WebElement emailId;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm")
	WebElement confirmPassword;

	@FindBy(id = "unitNumberB")
	WebElement unitNumberB;

	@FindBy(id = "streetNumberB")
	WebElement streetNumberB;

	@FindBy(id = "provinceB")
	WebElement provinceB;

	@FindBy(id = "countryB")
	WebElement countryB;

	@FindBy(id = "zipCodeB")
	WebElement zipCodeB;

	@FindBy(id = "answerIsYes")
	WebElement answerIsYes;

	@FindBy(id = "cityB")
	WebElement cityB;

	@FindBy(id = "cityS")
	WebElement cityS;

	@FindBy(id = "answerIsNo")
	WebElement answerIsNo;

	@FindBy(id = "unitNumberS")
	WebElement unitNumberS;

	@FindBy(id = "streetNumberS")
	WebElement streetNumberS;

	@FindBy(id = "provinceS")
	WebElement provinceS;

	@FindBy(id = "countryS")
	WebElement countryS;

	@FindBy(id = "zipCodeS")
	WebElement zipCodeS;

	@FindBy(name = "go")
	WebElement signUp;

	@FindBy(className = "error")
	WebElement message;
	
	@FindBy(id="securityPhrase")
	WebElement securityPhrase;

	public String getMessage() {
		return message.getAttribute("innerHTML");
	}

	public void signUp() {
		signUp.click();
	}

	public void streetNumberBilling(String sNumBill) {
		streetNumberB.clear();
		streetNumberB.sendKeys(sNumBill);
	}

	public void unitNumberBilling(String uNumBill) {
		unitNumberB.clear();
		unitNumberB.sendKeys(uNumBill);
	}

	public void cityB(String city) {
		cityB.clear();
		cityB.sendKeys(city);
	}

	public void cityS(String city) {
		cityS.clear();
		cityS.sendKeys(city);
	}

	public void userName(String user) {
		userName.clear();
		userName.sendKeys(user);
	}

	public void zipCodeShipping(String zipCodeShipping) {
		zipCodeB.clear();
		zipCodeB.sendKeys(zipCodeShipping);
	}

	public void countryShipping(String cShipping) {
		countryB.clear();
		countryB.sendKeys(cShipping);
	}

	public void provinceShipping(String pShipping) {
		provinceB.clear();
		provinceB.sendKeys(pShipping);
	}

	public void answerIsNoButton() {
		answerIsNo.click();
	}

	public void streetNumberShipping(String sNumBill) {
		streetNumberB.clear();
		streetNumberB.sendKeys(sNumBill);
	}

	public void unitNumberShipping(String uNumBill) {
		unitNumberB.clear();
		unitNumberB.sendKeys(uNumBill);
	}

	public void answerIsYesButton() {
		answerIsYes.click();
	}

	public void countryBilling(String cBilling) {
		countryB.clear();
		countryB.sendKeys(cBilling);
	}

	public void zipCodeBilling(String zipCodeBilling) {
		zipCodeB.clear();
		zipCodeB.sendKeys(zipCodeBilling);
	}

	public void provinceBilling(String pBilling) {
		provinceB.clear();
		provinceB.sendKeys(pBilling);
	}

	public void emailId(String email) {
		emailId.clear();
		emailId.sendKeys(email);
	}

	public void password(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void confirmPassword(String cPass) {
		confirmPassword.clear();
		confirmPassword.sendKeys(cPass);
	}
	
	public void securityPhrase(String sPhrase){
		securityPhrase.clear();
		securityPhrase.sendKeys(sPhrase);
	}

}
