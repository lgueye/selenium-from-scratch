package org.diveintojee.poc.web;

import org.diveintojee.poc.domain.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateMessagePageFunctionnalTest {

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
    CreateMessagePage createMessagePage = PageFactory.initElements(driver, CreateMessagePage.class);
    createMessagePage.visit();
    Message message = TestFixtures.validMessage();
    createMessagePage.fillCreateMessageForm(message);
    ListMessagesPage
        listMessagesPage =
        (ListMessagesPage) createMessagePage.sendCreateMessageForm(false);
    listMessagesPage.assertContainsExpectedName(message.getName());
    listMessagesPage.assertContainsExpectedEmail(message.getEmail());
    listMessagesPage.assertContainsExpectedPhone(message.getPhone());
    listMessagesPage.assertContainsExpectedMessage(message.getMessage());
    listMessagesPage.assertContainsExpectedWebsite(message.getWebsite());

  }

  @Test
  public void createMessageShouldFailAndDisplayErrorMessage() {
    CreateMessagePage createMessagePage = PageFactory.initElements(driver, CreateMessagePage.class);
    createMessagePage.visit();
    Message message = TestFixtures.validMessage();
    String invalidPhone = "06060606";
    message.setPhone(invalidPhone);
    CreateMessagePage outcome = (CreateMessagePage) createMessagePage.sendCreateMessageForm(true);
    outcome.assertContainsExpectedErrorMessage(
        "Un numéro de téléphone valide comporte au moins 9 chiffres.");
  }
}
