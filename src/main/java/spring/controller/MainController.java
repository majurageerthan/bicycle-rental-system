package spring.controller;

import model.LogInUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import service.SQLScriptRunner;
import support.DataSourceHelper;

import javax.sql.DataSource;

@Controller
public class MainController extends BaseController {
    @GetMapping("/")
    public ModelAndView getDefaultLoginPage() {
        return new ModelAndView("index");
    }


    @PostMapping("/initialize_system")
    public ModelAndView authenticateUser(@RequestParam String userName, @RequestParam String password) {
        userName = "user";
        password = "password";
        DataSource dataSource = DataSourceHelper.getDataSource(userName, password);
        SQLScriptRunner.initializeDatabaseAndTablesWithPermissions(dataSource);
        return new ModelAndView("redirect:login_page");
    }

    @GetMapping("/login_page")
    public ModelAndView getLoginPage() {
        return SendResponseModelAndView("authentication/login", "Database successfully created and tables are initialized. Now login with multi user credentials");

    }

    @GetMapping("/test_user")
    public ModelAndView testUser(@SessionAttribute("logInUser") LogInUser logInUser) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", logInUser.getRole());
        mav.setViewName("success/success");
        return mav;
    }
}
