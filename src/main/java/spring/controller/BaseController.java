package spring.controller;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    public ModelAndView SendResponseModelAndView(String page, String message) {
        ModelAndView modelAndView = new ModelAndView(page);
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
