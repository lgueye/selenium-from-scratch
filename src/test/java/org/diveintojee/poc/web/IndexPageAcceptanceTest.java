package org.diveintojee.poc.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

public class IndexPageAcceptanceTest {

  private String urlUnderTest = "http://localhost:9090/selenium-from-scratch/";

  private WebDriver driver;

  @Before
  public void before() throws Exception {
    driver = new FirefoxDriver();
  }
  
  @After
  public void after() throws Exception {
    driver.quit();
  }

  @Test
  public void shouldPostMessageForm() {
    driver.get(urlUnderTest);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    WebElement name_input = driver.findElement(By.id("name"));
    assertNotNull(name_input);
    name_input.sendKeys("louis gueye");
    WebElement email_input = driver.findElement(By.id("email"));
    assertNotNull(email_input);
    email_input.sendKeys("louis.gueye@gmail.com");
    WebElement phone_input = driver.findElement(By.id("phone"));
    assertNotNull(phone_input);
    phone_input.sendKeys("0606060606");
    WebElement website_input = driver.findElement(By.id("website"));
    assertNotNull(website_input);
    website_input.sendKeys("http://diveintojee.wordpress.com");
    WebElement message_input = driver.findElement(By.id("message"));
    assertNotNull(message_input);
    website_input.sendKeys("Selenium saves time when it comes to web functionnal testing automation");
    WebElement form = driver.findElement(By.id("create-message-form"));
    assertNotNull(message_input);
    website_input.sendKeys("Selenium saves time when it comes to web functionnal testing automation");

  }

}
