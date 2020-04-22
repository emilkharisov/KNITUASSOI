package ru.knitu.controller.worksOfWorkers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.ScienceWorkForm;

import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.ScienceWorkRepository;
import ru.knitu.repo.StudentRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.AddWorkService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ScienceWorkController {
    @Autowired
    ScienceWorkRepository scienceWorkRepository;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    @Qualifier("addScienceWorkServiceImpl")
    AddWorkService addWorkService;
    @GetMapping("/addScienceWork")
    public String getScienceWorkPage(Authentication authentication, ModelMap modelMap){
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
        return "scienceWork";
    }

    @PostMapping("/addScienceWork")
    public String addScienceWork(ScienceWorkForm scienceWorkForm, ModelMap modelMap, Authentication authentication){
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
        //--------------------------------------------------------------

        addWorkService.addWork(scienceWorkForm);
        return "scienceWork";
    }

}
