package org.diveintojee.poc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: lgueye Date: 21/08/12 Time: 14:25
 */
public class ListMessagesPage extends Page {

  public ListMessagesPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void assertIdentity() {
    final String listMessagesPageTitle = "dive into jee :: list messages";
    assertTrue(getDriver().getTitle().equalsIgnoreCase(listMessagesPageTitle));
  }

  @Override
  public void getInternal() {
    getDriver().get("http://localhost:9090/selenium-from-scratch/list");
  }

  public void assertContainsExpectedName(String name) {
    String nameXpathExpression = "//table[@id='display-data']//td[text()='" + name + "']";
    WebElement nameNode = getDriver().findElement(By.xpath(nameXpathExpression));
    assertNotNull(nameNode);
  }

  public void assertContainsExpectedEmail(String email) {
    String emailXpathExpression = "//table[@id='display-data']//td[text()='" + email + "']";
    WebElement emailNode = getDriver().findElement(By.xpath(emailXpathExpression));
    assertNotNull(emailNode);
  }

  public void assertContainsExpectedPhone(String phone) {
    String phoneXpathExpression = "//table[@id='display-data']//td[text()='" + phone + "']";
    WebElement phoneNode = getDriver().findElement(By.xpath(phoneXpathExpression));
    assertNotNull(phoneNode);
  }

  public void assertContainsExpectedMessage(String message) {
    String messageXpathExpression = "//table[@id='display-data']//td[text()='" + message + "']";
    WebElement messageNode = getDriver().findElement(By.xpath(messageXpathExpression));
    assertNotNull(messageNode);
  }

  public void assertContainsExpectedWebsite(String website) {
    String websiteXpathExpression = "//table[@id='display-data']//td[text()='" + website + "']";
    WebElement websiteNode = getDriver().findElement(By.xpath(websiteXpathExpression));
    assertNotNull(websiteNode);
  }


}
