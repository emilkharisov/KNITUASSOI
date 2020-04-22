package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.User;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

@Controller
public class AllWorkersController {
    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/getAllWorkersPage")
    public  String getAllWorkersPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("workers",workerRepository.findAll());
        return "allWorkers";
    }

    @PostMapping("/getAllWorkersPage")
    public  String getWorkers(ModelMap modelMap,  @RequestParam String lastname, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        if(lastname==null || lastname.length()==0){
            modelMap.addAttribute("workers",workerRepository.findAll());
        }
        else {
            modelMap.addAttribute("workers", workerRepository.findAllByLastname(lastname));
        }
        return "allWorkers";
    }
}
