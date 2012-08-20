package org.diveintojee.poc.web;

import org.diveintojee.poc.domain.Message;

/**
 * User: lgueye Date: 20/08/12 Time: 12:13
 */
public class TestFixtures {

  public static Message validMessage() {
    Message message = new Message();
    String name = "louis gueye";
    String email = "louis.gueye@gmail.com";
    String phone = "0606060606";
    String website = "http://diveintojee.wordpress.com";
    String content = "Selenium saves time when it comes to web functionnal testing automation";

    message.setEmail(email);
    message.setMessage(content);
    message.setName(name);
    message.setPhone(phone);
    message.setWebsite(website);

    return message;
  }
}
