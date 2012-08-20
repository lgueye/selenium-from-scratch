package org.diveintojee.poc.web;

import org.diveintojee.poc.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

/**
 * Handles requests for the application message page.
 */
@Controller(value = "/")
public class MessageController {

  private static final Logger logger = LoggerFactory
      .getLogger(MessageController.class);

  private static List<Message> messagesRepository = new ArrayList<Message>();


  @Autowired
  @Qualifier("validator")
  private Validator validator;

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    binder.setValidator(validator);
  }

  /**
   * Simply selects the home view to render by returning its name.
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String newForm(Model model) {
    logger.info("Welcome home! from Thymeleaf");

    model.addAttribute("messageInfo", new Message());

    return "index";
  }

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public String create(@Valid @ModelAttribute("messageInfo") Message message,
                       BindingResult result) {

    if (result.hasErrors()) {
      return "index";
    }

    addNewMessage(message);
    return "redirect:/list";

  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView list() {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("list");
    modelAndView.addObject("messages", messagesRepository);

    return modelAndView;

  }

  private void addNewMessage(Message message) {
    messagesRepository.add(message);
  }

}
