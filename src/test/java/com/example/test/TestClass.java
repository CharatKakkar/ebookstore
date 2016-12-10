package com.example.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;

public class TestClass {

	private WebDriver driver;

	private LoginPageObject loginObject;

	private HomePageObject homeObject;

	private String baseUrl;

	private boolean error = false;

	private String errstr = "";
		
	Helper obj;
	
	

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/I:/project/Selenium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://app.klipfolio.com/login";
		driver.get(baseUrl);
		loginObject = new LoginPageObject(driver);
		homeObject = new HomePageObject(driver);
		obj= Helper.getInfo();
		System.out.println("User Id" + obj.getUserId());
		System.out.println("user Name " +obj.getUsername());
	}

	@Test
	public void testMethod1() throws InterruptedException {

		loginObject.enterUsername( obj.getUsername() + "@klipfolio.com");
		loginObject.enterPassword("password");
		loginObject.login();
		if (homeObject.findNoDashBoardMsg()) {
			homeObject.AddDashBoardButton();
			homeObject.addBlankDashBoardButton();
		}
		homeObject.addToKlipButton();
		homeObject.klipGalleryTab();
		homeObject.getKlip("Weather");
		homeObject.dashboardButton();
		homeObject.locationTextBox("Toronto", "Canada");
		homeObject.addKlipButton();
		if (homeObject.confirmationMessage()) {
			homeObject.finishedButton();
		} else {
			error = true;
			errstr = "There was an issue in adding the Klip";
		}
		Assert.assertTrue(errstr, !error);
	}

	@After
	public void tearDown() {
		Helper.deleteUser(obj.getUserId());
		driver.quit();
	}

}
