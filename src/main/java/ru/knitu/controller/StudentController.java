package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.StudentForm;
import ru.knitu.model.User;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.AddStudent;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Value("${upload.path}")
    String uploadPath;
    @Autowired
    AddStudent addStudentService;

    @GetMapping("/addStudent")
    public String getAddStudentPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());


    return "student";
    }

    @PostMapping("/addStudent")
    public String addStudent(Authentication authentication, @Valid StudentForm studentForm, BindingResult bindingResult, ModelMap modelMap){

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
            return "student";
        }
        else {
            addStudentService.addStudent(studentForm);
        }
        return "student";
    }
}
