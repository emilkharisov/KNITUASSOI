package ru.knitu.controller.workersSelection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class JubileeSelectAction {
    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/selectJubilee")
    public String getJubileeSelectPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        ArrayList<Worker> listOfWorkers = new ArrayList<Worker>();
        for(Worker worker : workerRepository.findAll()){
            Date currentDate = new Date();
            Period period = Period.between(currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),worker.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            Integer yearsInt = Math.abs(period.getYears());
            System.out.println(yearsInt.toString());
            if(yearsInt.toString().endsWith("0") || yearsInt.toString().endsWith("5")){
                listOfWorkers.add(worker);
            }
        }
        modelMap.addAttribute("workers",listOfWorkers);
        return "jubileeWorkers";
    }

    @PostMapping("/selectJubilee")
    public String getJubileeSelectPage2(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        ArrayList<Worker> listOfWorkers = new ArrayList<Worker>();
        for(Worker worker : workerRepository.findAll()){
            Date currentDate = new Date();
            Period period = Period.between(currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),worker.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            Integer yearsInt = Math.abs(period.getYears());
            if(yearsInt.toString().endsWith("4") || yearsInt.toString().endsWith("9")){
                listOfWorkers.add(worker);
            }
        }
        modelMap.addAttribute("workers",listOfWorkers);
        return "jubileeWorkers";
    }
}
