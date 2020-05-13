package ru.knitu.controller.candidateWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.controller.ControllerUtils;
import ru.knitu.form.CandidateWorkForm;
import ru.knitu.model.User;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.CandidateWorkService;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class AddCandidateWorkController {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    CandidateWorkService candidateWorkService;

    @GetMapping("/addCandidateWork")
    public String getPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("workers", workerRepository.findAll());

        return "addCandidateWork";
    }

    @PostMapping("/addCandidateWork")
    public String addCandidateWork(Authentication authentication, @Valid CandidateWorkForm candidateWorkForm, BindingResult bindingResult, ModelMap modelMap) throws ParseException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("workers", workerRepository.findAll());

        if (bindingResult.hasErrors()) {
            modelMap.addAllAttributes(ControllerUtils.getErrors(bindingResult));
            modelMap.addAttribute("validError", true);
            return "addCandidateWork";
        }
        else{
            candidateWorkService.addCandidateWork(candidateWorkForm);
        }

        return "addCandidateWork";
    }

}
