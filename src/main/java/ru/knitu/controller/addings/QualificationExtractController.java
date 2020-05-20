package ru.knitu.controller.addings;

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

import java.util.Calendar;
import java.util.Date;

@Controller
public class QualificationExtractController {

    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/getQualificationAfter")
    public String getPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, -3);
        modelMap.addAttribute("workers", workerRepository.findAllByQualificationDateBeforeOrQualificationDateIsNull(calendar.getTime()));

        return "qualificationAfter";
    }

    @PostMapping("/getQualificationAfter")
    public String getQualificationAfter(Authentication authentication, ModelMap modelMap, @RequestParam String year){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(year== null || year.equals("")){
            return "redirect:/getQualificationAfter";
        }

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, -(Integer.parseInt(year)));
        modelMap.addAttribute("workers", workerRepository.findAllByQualificationDateBeforeOrQualificationDateIsNull(calendar.getTime()));

        return "qualificationAfter";
    }

    @GetMapping("/getQualificationReport")
    public String getQPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, -3);
        modelMap.addAttribute("workers", workerRepository.findAllByQualificationDateAfter(calendar.getTime()));

        return "qualificationReport";
    }

    @PostMapping("/getQualificationReport")
    public String getQualificationReport(Authentication authentication, ModelMap modelMap, @RequestParam String year){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(year == null || year.equals("")){
            return "redirect:/getQualificationReport";
        }

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, -(Integer.parseInt(year)));
        modelMap.addAttribute("workers", workerRepository.findAllByQualificationDateAfter(calendar.getTime()));

        return "qualificationReport";
    }

}
