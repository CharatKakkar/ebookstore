package intermediateClasses;


import utilities.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import PageObjects.AddKlipPageClass;
import PageObjects.HomePageClass;
import PageObjects.LoginPageClass;
import utilities.Helper;

public class IntermediateAddKlips {
	private WebDriver driver;

	private LoginPageClass loginObject;

	private HomePageClass homeObject;
	
	private AddKlipPageClass addKlipObject;

	private boolean error = false;

	private String errstr = "";
		
	Helper helperObj;

	
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver",Constants.webDriverLocation);
		driver = new ChromeDriver();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		helperObj= Helper.createUser();
		loginObject = new LoginPageClass(driver);
		homeObject = new HomePageClass(driver);
		addKlipObject= new AddKlipPageClass(driver);

	}
	
	public void login(){

		loginObject.enterUsername(helperObj.getUsername() + "@klipfolio.com");
		loginObject.enterPassword("password");
		loginObject.login();
	}
	
	public void createNewDashBoard() {
		System.out.println("createNewDashBoard is being executed");

		if (homeObject.findNoDashBoardMsg()) {
			homeObject.AddDashBoardButton();
			homeObject.addBlankDashBoardButton();
		}
	}

	public void klipToBeAdded(String klipName) {
		System.out.println("addingKlip is being executed");
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			homeObject.addAKlipButton();
			
			addKlipObject.klipGalleryTab();
			homeObject.getKlip(klipName);
			homeObject.dashboardButton();		
	}

	public void klipWithLocation(String city, String country){
		System.out.println("klipWithLocation is being executed");
		addKlipObject.locationTextBox(city, country);
	}
	

	public void addKlip(){
		System.out.println("addKlip is being executed");
		addKlipObject.addKlipButton();
	}
	
	public void confirmKlipAddition(){
		System.out.println("confirmKlipAddition is being executed");
		
		if (addKlipObject.confirmationMessage()) {
			addKlipObject.finishedButton();
		} else {
			error = true;
			errstr = "There was an issue in adding the Klip";
		}
		Assert.assertTrue(errstr, !error);
	}
	
	public void connectLaterButton(){
		addKlipObject.connectLaterButton();
	}
	
	public void klipFolioIcon(){
		homeObject.klipfolioIcon();
	}
	public void tearDown() {
		Helper.deleteUser(helperObj.getUserId());
		driver.quit();
	}

}
