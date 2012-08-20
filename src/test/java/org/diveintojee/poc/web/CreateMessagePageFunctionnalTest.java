package org.diveintojee.poc.web;

import org.diveintojee.poc.domain.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CreateMessagePageFunctionnalTest {

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
  public void createMessageShouldSucceedAndListMessages() {
    displayCreateMessagePage();
    Message message = TestFixtures.validMessage();
    fillCreateMessageForm(message);
    sendCreateMessageForm();
    assertFormSubmissionOutcomeIsListMessagesPage();
    assertListMessagesPageContainsExpectedName(message.getName());
    assertListMessagesPageContainsExpectedEmail(message.getEmail());
    assertListMessagesPageContainsExpectedPhone(message.getPhone());
    assertListMessagesPageContainsExpectedMessage(message.getMessage());
    assertListMessagesPageContainsExpectedWebsite(message.getWebsite());

  }

  @Test
  public void createMessageShouldFailAndDisplayErrorMessage() {
    displayCreateMessagePage();
    Message message = TestFixtures.validMessage();
    String invalidPhone = "06060606";
    message.setPhone(invalidPhone);
    fillCreateMessageForm(message);
    sendCreateMessageForm();
    assertFormSubmissionOutcomeIsCreateMessagePage();
    assertCreateMessagePageContainsExpectedErrorMessage(
        "Un numéro de téléphone valide comporte au moins 9 chiffres.");
  }

  private void assertCreateMessagePageContainsExpectedErrorMessage(String errorMessage) {
    String errorMessageXpathExpression = "//div[@id='errors']//li[text()='" + errorMessage + "']";
    WebElement errorMessageNode = driver.findElement(By.xpath(errorMessageXpathExpression));
    assertNotNull(errorMessageNode);
  }

  private void assertFormSubmissionOutcomeIsCreateMessagePage() {
    assertCurrentPageIsCreateMessagePage();
  }

  private void assertCurrentPageIsCreateMessagePage() {
    String createMessagePageTitle = "dive into jee :: create message";
    assertTrue(driver.getTitle().equalsIgnoreCase(createMessagePageTitle));
  }

  private void assertListMessagesPageContainsExpectedName(String name) {
    String nameXpathExpression = "//table[@id='display-data']//td[text()='" + name + "']";
    WebElement nameNode = driver.findElement(By.xpath(nameXpathExpression));
    assertNotNull(nameNode);
  }

  private void assertListMessagesPageContainsExpectedEmail(String email) {
    String emailXpathExpression = "//table[@id='display-data']//td[text()='" + email + "']";
    WebElement emailNode = driver.findElement(By.xpath(emailXpathExpression));
    assertNotNull(emailNode);
  }

  private void assertListMessagesPageContainsExpectedPhone(String phone) {
    String phoneXpathExpression = "//table[@id='display-data']//td[text()='" + phone + "']";
    WebElement phoneNode = driver.findElement(By.xpath(phoneXpathExpression));
    assertNotNull(phoneNode);
  }

  private void assertListMessagesPageContainsExpectedMessage(String message) {
    String messageXpathExpression = "//table[@id='display-data']//td[text()='" + message + "']";
    WebElement messageNode = driver.findElement(By.xpath(messageXpathExpression));
    assertNotNull(messageNode);
  }

  private void assertListMessagesPageContainsExpectedWebsite(String website) {
    String websiteXpathExpression = "//table[@id='display-data']//td[text()='" + website + "']";
    WebElement websiteNode = driver.findElement(By.xpath(websiteXpathExpression));
    assertNotNull(websiteNode);
  }

  private void assertFormSubmissionOutcomeIsListMessagesPage() {
    assertCurrentPageIsListMessages();
  }

  private void assertCurrentPageIsListMessages() {
    final String listMessagesPageTitle = "dive into jee :: list messages";
    assertTrue(driver.getTitle().equalsIgnoreCase(listMessagesPageTitle));
  }

  private void sendCreateMessageForm() {
    WebElement form = driver.findElement(By.id("create-message-form"));
    assertNotNull(form);
    form.submit();
  }

  private void fillCreateMessageForm(Message message) {
    WebElement name_input = driver.findElement(By.id("name"));
    assertNotNull(name_input);
    name_input.sendKeys(message.getName());
    WebElement email_input = driver.findElement(By.id("email"));
    assertNotNull(email_input);
    email_input.sendKeys(message.getEmail());
    WebElement phone_input = driver.findElement(By.id("phone"));
    assertNotNull(phone_input);
    phone_input.sendKeys(message.getPhone());
    WebElement website_input = driver.findElement(By.id("website"));
    assertNotNull(website_input);
    website_input.sendKeys(message.getWebsite());
    WebElement message_input = driver.findElement(By.id("message"));
    assertNotNull(message_input);
    message_input.sendKeys(message.getMessage());
  }

  private void displayCreateMessagePage() {
    driver.get(urlUnderTest);
    assertCurrentPageIsCreateMessagePage();
  }

}
