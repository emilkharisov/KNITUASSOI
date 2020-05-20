package ru.knitu.controller.addings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.EducationalWork;
import ru.knitu.model.User;
import ru.knitu.repo.EducationalWorkRepisitory;
import ru.knitu.repo.ScienceWorkRepository;
import ru.knitu.security.details.UserDetailsImpl;

@Controller
public class StudentWorksExtract {

    @Autowired
    EducationalWorkRepisitory educationalWorkRepisitory;
    @Autowired
    ScienceWorkRepository scienceWorkRepository;

    @GetMapping("/getStudentWorks")
    public String getPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("educational", educationalWorkRepisitory.findAllByStudentIsNotNull());
        modelMap.addAttribute("science", scienceWorkRepository.findAllByStudentIsNotNull());

        return "studentWorksExtract";
    }

    @PostMapping("/getStudentWorks")
    public String getStudentWorks(Authentication authentication, ModelMap modelMap, @RequestParam String year){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(year == null || year.equals("")){
            return "redirect:/getStudentWorks";
        }

        modelMap.addAttribute("educational", educationalWorkRepisitory.findAllByStudentIsNotNullAndYearOfPublication(Integer.parseInt(year)));
        modelMap.addAttribute("science", scienceWorkRepository.findAllByStudentIsNotNullAndYearOfPublication(Integer.parseInt(year)));

        return "studentWorksExtract";
    }

}
