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

import static support.Constant.*;

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

        if (logInUser.getRole() == null)
            return SendResponseModelAndView("response/fail", "Access denied, User name or password wrong");

        return SendResponseModelAndView("response/success", "Welcome " + logInUser.getRole());
    }


    private void initUserRole(LogInUser logInUser) {
        DataSource dataSource = DataSourceHelper.getDataSource(logInUser.getUserName(), logInUser.getPassword());
        logInUser.setDataSource(dataSource);
        if (USER_NAME_CUSTOMER.toLowerCase().equals(logInUser.getUserName())) {
            logInUser.setRole(USER_NAME_CUSTOMER);
        } else if (USER_NAME_MANAGER.toLowerCase().equals(logInUser.getUserName())) {
            logInUser.setRole(USER_NAME_MANAGER);
        } else if (USER_NAME_CASHIER.toLowerCase().equals(logInUser.getUserName())) {
            logInUser.setRole(USER_NAME_CASHIER);
        } else {
            logInUser.setRole(null);
        }

        if (!logInUser.getPassword().equals("1234")) {
            logInUser.setRole(null);
        }
    }

}
