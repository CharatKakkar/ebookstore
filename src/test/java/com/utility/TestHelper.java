package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHelper {

	private static WebDriver driver;
	private static TestHelper setUp;
	private String baseUrl;

	public TestHelper() {
		driver = new ChromeDriver();
	    baseUrl = "http://localhost:8080/";
		//baseUrl="http://myubuntu.com:8080";
		driver.get(baseUrl + "/ebookstore/");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		TestHelper.driver = driver;
	}

	public static TestHelper getSetUp() {
		if (setUp == null) {
			setUp = new TestHelper();
		}
		return setUp;
	}

}
