package com.example.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePageClass;
import PageObjects.LoginPageClass;
import utilities.Helper;

public class TestClassJunit {

	private WebDriver driver;

	private LoginPageClass loginObject;

	private HomePageClass homeObject;

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
		loginObject = new LoginPageClass(driver);
		homeObject = new HomePageClass(driver);
		obj= Helper.createUser();
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
		error = true;
			errstr = "There was an issue in adding the Klip";
		}
	


	@After
	public void tearDown() {
		Helper.deleteUser(obj.getUserId());
		driver.quit();
	}

}
