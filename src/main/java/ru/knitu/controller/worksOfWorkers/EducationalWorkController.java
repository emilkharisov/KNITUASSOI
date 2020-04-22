package ru.knitu.controller.worksOfWorkers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.EducationalWorkForm;
import ru.knitu.model.User;
import ru.knitu.repo.StudentRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.AddWorkService;

@Controller
public class EducationalWorkController {
    @Autowired
    @Qualifier("addEducationalWorkServiceImpl")
    AddWorkService addWorkService;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("addEducationalWork")
    public String getEducationalWorkPage(Authentication authentication, ModelMap modelMap) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());

        modelMap.addAttribute("workers", workerRepository.findAll());
        modelMap.addAttribute("students", studentRepository.findAll());
        return "educationalWork";
    }

    @PostMapping("addEducationalWork")
    public String addEducationalWork(EducationalWorkForm educationalWorkForm, ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------
        modelMap.addAttribute("workers", workerRepository.findAll());
        modelMap.addAttribute("students", studentRepository.findAll());
        addWorkService.addWork(educationalWorkForm);
        return "educationalWork";
    }
}
