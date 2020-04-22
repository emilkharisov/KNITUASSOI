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

import java.util.ArrayList;
import java.util.Date;

@Controller
public class ExpiringContractSelectAction {
    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/selectExpiringContractWorkers")
    public String getSelectByExpContPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        Date currentDate = new Date();
        ArrayList<Worker> listOfWorkers = new ArrayList<>();
        for(Worker worker : workerRepository.findAll()){
            int currentYear = currentDate.getYear();
            int yearOfEndContract = worker.getDateEndOfContract().getYear();
            System.out.println(currentYear + " " + yearOfEndContract);
            if(currentYear==yearOfEndContract){
                listOfWorkers.add(worker);
            }
        }
        modelMap.addAttribute("workers", listOfWorkers);
        return "expiredContract";
    }

    @PostMapping("/selectExpiringContractWorkers")
    public String getWorkers(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        Date currentDate = new Date();
        ArrayList<Worker> listOfWorkers = new ArrayList<>();
        for(Worker worker : workerRepository.findAll()){
            int nextYear = currentDate.getYear()+1;
            int yearOfEndContract = worker.getDateEndOfContract().getYear();
            if(nextYear==yearOfEndContract){
                listOfWorkers.add(worker);
            }
        }
        modelMap.addAttribute("workers", listOfWorkers);
        return "expiredContract";
    }
}
