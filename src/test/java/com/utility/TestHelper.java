package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHelper {

	
	private static WebDriver driver;
	private static TestHelper setUp;

	public static void tearDown(){
		if (driver!=null){
			driver.quit();
		}
	}
	
	private String baseUrl;
	
	public TestHelper(){
		System.setProperty("webdriver.chrome.driver", "F:/Project/Selenium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://localhost:8080/";
		driver.get(baseUrl + "/ebookstore/");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public static TestHelper getSetUp() {
		if(setUp== null){
			setUp= new TestHelper();
		}
		return setUp;
	}

	
	
	
//	public void setFetchBrowser(TestHelper fetchBrowser) {
//		this.fetchBrowser = fetchBrowser;
//	}
}
