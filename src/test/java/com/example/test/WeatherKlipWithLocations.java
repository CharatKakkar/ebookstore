package com.example.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WeatherKlipWithLocations {

	TestClassNg myObj ;

	@BeforeSuite
	public void setUp() {
		myObj  = new TestClassNg();
		myObj.setUp();
		myObj.login();
	}

	@DataProvider(name = "locationData")
	public static Object[][] LocationData() {
		return new Object[][] { { "Toronto", "Canada", "Weather" }, { "Ottawa", "Canada", "Weather" }, {"Montreal", "Canada", "Weather"}};
	}

	@Test(dataProvider = "locationData")
	public void AddingWeatherKlipWithLocations(String city, String country, String klipName) throws InterruptedException {
		
		myObj.createNewDashBoard();
		myObj.klipToBeAdded(klipName);
		myObj.klipWithLocation(city, country);
		myObj.addKlip();
		myObj.confirmKlipAddition();	
	}

	@DataProvider(name = "googleKlips")
	public static Object[][] searchData() {
		return new Object[][] { { "Google AdWords" }, { "Google Analytics" }, { "Google Calendar" },{ "Google Search Console" } };
	}

	@Test(dataProvider = "googleKlips")
	public void googleKlips(String klipName) throws InterruptedException {
		myObj.klipFolioIcon();
		myObj.createNewDashBoard();
		myObj.klipToBeAdded(klipName);
		myObj.connectLaterButton();
		myObj.confirmKlipAddition();
	}

	@DataProvider(name = "otherKlips")
	public static Object[][] otherKlipsData() {
		return new Object[][] { { "RSS Feeds" }, { "Zapier" } };
	}

	@Test(dataProvider = "otherKlips")
	public void moreKlips(String klipName) throws InterruptedException {
		
		myObj.klipFolioIcon();
		myObj.createNewDashBoard();
		myObj.klipToBeAdded(klipName);
		myObj.confirmKlipAddition();
	}
	
	@AfterSuite
	public void tearDown() {
		myObj.tearDown();
	}

}
