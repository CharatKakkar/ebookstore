package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver= driver;
			PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH ,using="//*[@id='navbar']/ul[1]/li[1]/a")
	WebElement homeButton;
	
	public void homeButtonClick(){
		homeButton.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='navbar']/ul[1]/li[2]/a")
	WebElement productPage;
	
	public void productPageClick(){
		productPage.click();
	}
	
	
}
