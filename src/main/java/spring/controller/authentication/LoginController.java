package spring.controller.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @PostMapping("/authenticate_user")
    public ModelAndView authenticateUser() {
        return new ModelAndView("success/success");
    }

}
