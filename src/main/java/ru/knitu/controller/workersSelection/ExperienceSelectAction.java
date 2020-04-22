package ru.knitu.controller.workersSelection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ExperienceSelectAction {

    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/selectByExperience")
    public String getPage(ModelMap modelMap, Authentication authentication) {
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
        return "experienceSelection";
    }

    @PostMapping("/selectByExperience")
    public String getWorkers(ModelMap modelMap, @RequestParam String experienceInput, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        if(experienceInput == null || experienceInput.length() == 0){
            modelMap.addAttribute("workers", workerRepository.findAll());
            return "experienceSelection";
        }
        int experience = Integer.parseInt(experienceInput);
        ArrayList<Worker> listOfWorkers = new ArrayList<Worker>();
        for(Worker worker: workerRepository.findAll()){
            Date currentDate = new Date();
            Period period = Period.between(currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),worker.getDateOfBeginWork().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            if(Math.abs(period.getYears())==experience || Math.abs(period.getYears())>experience){
                listOfWorkers.add(worker);
            }
        }
        modelMap.addAttribute("workers", listOfWorkers);
        return "experienceSelection";
    }
}
