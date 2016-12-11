package com.example.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;

public class TestClassNg {
	private WebDriver driver;

	private LoginPageObject loginObject;

	private HomePageObject homeObject;

	private String baseUrl;

	private boolean error = false;

	private String errstr = "";
		
	Helper obj;

	
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "/I:/project/Selenium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://app.klipfolio.com/login";
		driver.get(baseUrl);
		obj= Helper.getInfo();
		loginObject = new LoginPageObject(driver);
		homeObject = new HomePageObject(driver);

	}
	
	public void login(){

		loginObject.enterUsername(  obj.getUsername() + "@klipfolio.com");
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

	public void klipToBeAdded(String klipName) throws InterruptedException {
		System.out.println("addingKlip is being executed");
		Thread.sleep(500);
		homeObject.addAKlipButton();
		homeObject.klipGalleryTab();
		homeObject.getKlip(klipName);
		homeObject.dashboardButton();
		
	}

	public void klipWithLocation(String city, String country){
		System.out.println("klipWithLocation is being executed");
		homeObject.locationTextBox(city, country);
	}
	

	public void addKlip(){
		System.out.println("addKlip is being executed");
		homeObject.addKlipButton();
	}
	
	
	public void confirmKlipAddition(){
		System.out.println("confirmKlipAddition is being executed");
		
		if (homeObject.confirmationMessage()) {
			homeObject.finishedButton();
		} else {
			error = true;
			errstr = "There was an issue in adding the Klip";
		}
		Assert.assertTrue(errstr, !error);
	}
	
	public void connectLaterButton(){
		homeObject.connectLaterButton();
	}
	
	public void klipFolioIcon(){
		homeObject.klipFolioIcon();
	}
	public void tearDown() {
		Helper.deleteUser(obj.getUserId());
		driver.quit();
	}

}
