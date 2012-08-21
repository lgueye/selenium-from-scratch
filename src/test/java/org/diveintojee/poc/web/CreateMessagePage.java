package org.diveintojee.poc.web;

import org.diveintojee.poc.domain.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: lgueye Date: 21/08/12 Time: 14:04
 */
public class CreateMessagePage extends Page {

  public CreateMessagePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id="create-message-form") WebElement form;

  @Override
  public void visitInternal() {
    getDriver().get(BASE_URL);
  }

  public void assertIdentity() {
    String createMessagePageTitle = "dive into jee :: create message";
    assertTrue(getDriver().getTitle().equalsIgnoreCase(createMessagePageTitle));
  }

  public void fillCreateMessageForm(Message message) {
    WebElement name_input = getDriver().findElement(By.id("name"));
    assertNotNull(name_input);
    name_input.sendKeys(message.getName());
    WebElement email_input = getDriver().findElement(By.id("email"));
    assertNotNull(email_input);
    email_input.sendKeys(message.getEmail());
    WebElement phone_input = getDriver().findElement(By.id("phone"));
    assertNotNull(phone_input);
    phone_input.sendKeys(message.getPhone());
    WebElement website_input = getDriver().findElement(By.id("website"));
    assertNotNull(website_input);
    website_input.sendKeys(message.getWebsite());
    WebElement message_input = getDriver().findElement(By.id("message"));
    assertNotNull(message_input);
    message_input.sendKeys(message.getMessage());
  }

  public Page sendCreateMessageForm(boolean failureExpected) {
    assertNotNull(form);
    form.submit();
    Page page;
    if (failureExpected) page = PageFactory.initElements(getDriver(), CreateMessagePage.class);
    else page = PageFactory.initElements(getDriver(), ListMessagesPage.class);
    page.assertIdentity();
    return page;
  }


  public void assertContainsExpectedErrorMessage(String expectedErrorMessage) {
    String errorMessageXpathExpression = "//div[@id='errors']//li[text()='" + expectedErrorMessage + "']";
    WebElement errorMessageNode = getDriver().findElement(By.xpath(errorMessageXpathExpression));
    assertNotNull(errorMessageNode);
  }
}
