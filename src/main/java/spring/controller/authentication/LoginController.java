package spring.controller.authentication;

import model.LogInUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import spring.controller.BaseController;
import support.DataSourceHelper;

import javax.sql.DataSource;

@Controller
@SessionAttributes("logInUser")
public class LoginController extends BaseController {

    @ModelAttribute("logInUser")
    public LogInUser setUpUserForm() {
        return new LogInUser();
    }

    @PostMapping("/authenticate_user")
    public ModelAndView authenticateUser(@ModelAttribute("logInUser") LogInUser logInUser) {
        initUserRole(logInUser);
        return SendResponseModelAndView("success/success", "Welcome " + logInUser.getRole());
    }



    private void initUserRole(LogInUser logInUser) {
        DataSource dataSource = DataSourceHelper.getDataSource(logInUser.getUserName(), logInUser.getPassword());
        logInUser.setDataSource(dataSource);
        if ("admin".equals(logInUser.getUserName())) {
            logInUser.setRole("admin");
        } else {
            logInUser.setRole("user");
        }
    }

}
