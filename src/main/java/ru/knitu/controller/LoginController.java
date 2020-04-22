package ru.knitu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.form.LoginForm;
import ru.knitu.repo.UserRepository;


import javax.servlet.http.HttpServletRequest;



@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap modelMap, HttpServletRequest request, LoginForm loginForm){
        if (authentication != null) {
            return "redirect:/getMainPage";
        }
        else {
            if (request.getParameterMap().containsKey("error")) {
                modelMap.addAttribute("error", true);
            }
        }
        return "login";
    }
}
