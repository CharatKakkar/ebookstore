package com.example.test;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginAndLogout {
  private WebDriver driver;

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
 
    System.setProperty("webdriver.chrome.driver", "/I:/Project/Selenium/chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginAndLogout() throws Exception {
    driver.get(baseUrl + "/ebookstore/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("charat");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("charat");
    driver.findElement(By.name("go")).click();
    driver.findElement(By.linkText("Products")).click();
    driver.findElement(By.cssSelector("img[alt=\"image\"]")).click();
    driver.findElement(By.linkText("Back")).click();
    driver.findElement(By.linkText("Logout")).click();
  }


  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
