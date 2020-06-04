package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView getDefaultLoginPage() {
        return new ModelAndView("authentication/login");
    }

    @GetMapping("/add_bracket_to_copied_clipboard")
    public ModelAndView getLoginPage() {

        return new ModelAndView("authentication/login");
    }

}
