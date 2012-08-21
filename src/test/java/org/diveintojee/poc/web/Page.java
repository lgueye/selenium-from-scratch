package org.diveintojee.poc.web;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * User: lgueye Date: 21/08/12 Time: 14:21
 */
public abstract class Page {

  private WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver getDriver() {
    return driver;
  }

  protected abstract void assertIdentity();

  public void get() {
    getInternal();
    assertIdentity();
  }
  protected abstract void getInternal();
}
