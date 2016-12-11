package com.example.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import intermediateClasses.IntermediateAddKlips;

public class TestKlips {

	IntermediateAddKlips intermediateAddKlipsObj ;

	@BeforeSuite
	public void setUp() {
		intermediateAddKlipsObj  = new IntermediateAddKlips();
		intermediateAddKlipsObj.setUp();
		intermediateAddKlipsObj.login();
	}

	@DataProvider(name = "locationData")
	public static Object[][] LocationData() {
		return new Object[][] { { "Toronto", "Canada", "Weather" }, { "Ottawa", "Canada", "Weather" }, {"Montreal", "Canada", "Weather"}};
	}

	@Test(dataProvider = "locationData")
	public void testAddingWeatherKlipWithLocations(String city, String country, String klipName)  {
		
		intermediateAddKlipsObj.createNewDashBoard();
		intermediateAddKlipsObj.klipToBeAdded(klipName);
		intermediateAddKlipsObj.klipWithLocation(city, country);
		intermediateAddKlipsObj.addKlip();
		intermediateAddKlipsObj.confirmKlipAddition();	
	}

	@DataProvider(name = "googleKlips")
	public static Object[][] searchData() {
		return new Object[][] { { "Google AdWords" }, { "Google Analytics" }, { "Google Calendar" },{ "Google Search Console" } };
	}

	@Test(dataProvider = "googleKlips")
	public void testAddingGoogleKlips(String klipName) throws InterruptedException {
		intermediateAddKlipsObj.klipFolioIcon();
		intermediateAddKlipsObj.createNewDashBoard();
		intermediateAddKlipsObj.klipToBeAdded(klipName);
		intermediateAddKlipsObj.connectLaterButton();
		intermediateAddKlipsObj.confirmKlipAddition();
	}

	@DataProvider(name = "otherKlips")
	public static Object[][] otherKlipsData() {
		return new Object[][] { { "RSS Feeds" }, { "Zapier" } };
	}

	@Test(dataProvider = "otherKlips")
	public void testAddingOtherKlips(String klipName) throws InterruptedException {
		
		intermediateAddKlipsObj.klipFolioIcon();
		intermediateAddKlipsObj.createNewDashBoard();
		intermediateAddKlipsObj.klipToBeAdded(klipName);
		intermediateAddKlipsObj.confirmKlipAddition();
	}
	
	@AfterSuite
	public void tearDown() {
		intermediateAddKlipsObj.tearDown();
	}

}
