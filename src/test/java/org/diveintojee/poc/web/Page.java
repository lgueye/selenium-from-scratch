package org.diveintojee.poc.web;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * User: lgueye Date: 21/08/12 Time: 14:21
 */
public abstract class Page {

  public static final String BASE_URL = "http://localhost:9090/selenium-from-scratch";

  private WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver getDriver() {
    return driver;
  }

  protected abstract void assertIdentity();

  public void visit() {
    visitInternal();
    assertIdentity();
  }

  protected abstract void visitInternal();
  
}
