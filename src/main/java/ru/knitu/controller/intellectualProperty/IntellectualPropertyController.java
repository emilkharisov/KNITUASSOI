package ru.knitu.controller.intellectualProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.controller.ControllerUtils;
import ru.knitu.form.IntellectualPropertyForm;
import ru.knitu.model.User;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.IntellectualPropertyService;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class IntellectualPropertyController {

    @Autowired
    IntellectualPropertyService intellectualPropertyService;

    @GetMapping("/addIntellectualProperty")
    public String getPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        return "addIntellectualProperty";
    }

    @PostMapping("/addIntellectualProperty")
    public String addIntellectualProperty(Authentication authentication, @Valid IntellectualPropertyForm intellectualPropertyForm, BindingResult bindingResult, ModelMap modelMap) throws ParseException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if (bindingResult.hasErrors()) {
            modelMap.addAllAttributes(ControllerUtils.getErrors(bindingResult));
            modelMap.addAttribute("validError", true);
            return "addIntellectualProperty";
        }
        else{
            intellectualPropertyService.addIntellectualProperty(intellectualPropertyForm);
        }

        return "addIntellectualProperty";
    }

}
