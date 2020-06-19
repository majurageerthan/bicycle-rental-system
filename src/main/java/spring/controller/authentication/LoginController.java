package spring.controller.authentication;

import dao.UserDao;
import dao.impl.UserDaoImpl;
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

        return showUserPageBasedOnUser(logInUser);

//        return SendResponseModelAndView("response/success", "Welcome " + logInUser.getRole());
    }

    private ModelAndView showUserPageBasedOnUser(LogInUser logInUser) {
        ModelAndView modelAndView = new ModelAndView();


        if (USER_NAME_CUSTOMER.equals(logInUser.getRole())) {
            UserDao userDao = new UserDaoImpl(logInUser.getDataSource());
            modelAndView.addObject("user", userDao.getUser(logInUser.getUserName()));
            modelAndView.setViewName("users/customer");

        } else if (USER_NAME_MANAGER.equals(logInUser.getRole())) {
            return SendResponseModelAndView("response/success", "Welcome " + logInUser.getRole());
        } else if (USER_NAME_CASHIER.equals(logInUser.getRole())) {
            return SendResponseModelAndView("response/success", "Welcome " + logInUser.getRole());

        }


        return modelAndView;
    }


    private void initUserRole(LogInUser logInUser) {
        DataSource dataSource = null;
        if ("941112293V".equals(logInUser.getUserName())) {
            dataSource = DataSourceHelper.getDataSourceWithDatabaseName("customer", logInUser.getPassword());
            logInUser.setRole(USER_NAME_CUSTOMER);

        } else if ("941212293V".equals(logInUser.getUserName())) {
            dataSource = DataSourceHelper.getDataSourceWithDatabaseName("manager", logInUser.getPassword());
            logInUser.setRole(USER_NAME_MANAGER);

        } else if ("941312293V".equals(logInUser.getUserName())) {
            dataSource = DataSourceHelper.getDataSourceWithDatabaseName("cachier", logInUser.getPassword());

            logInUser.setRole(USER_NAME_CASHIER);
        } else {
            logInUser.setRole(null);
        }

        if (!logInUser.getPassword().equals("1234")) {
            logInUser.setRole(null);
        }

        logInUser.setDataSource(dataSource);
    }

}
