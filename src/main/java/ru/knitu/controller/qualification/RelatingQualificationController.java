package ru.knitu.controller.qualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.IncreaseQualificationForm;
import ru.knitu.model.IncreaseQualification;
import ru.knitu.model.IncreaseQualificationRelate;
import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.IncreaseQualificationRelateRepository;
import ru.knitu.repo.IncreaseQualificationRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.text.ParseException;

@Controller
public class RelatingQualificationController {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    IncreaseQualificationRepository qualificationRepository;
    @Autowired
    IncreaseQualificationRelateRepository increaseQualificationRelateRepository;

    @GetMapping("/qualification")
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
        modelMap.addAttribute("qualifications", qualificationRepository.findAll());

        return "qualification";
    }

    @PostMapping("/qualification")
    public String addQualification(Authentication authentication, ModelMap modelMap, @RequestParam String qualification, @RequestParam String workers) throws ParseException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("workers", workerRepository.findAll());
        modelMap.addAttribute("qualifications", qualificationRepository.findAll());

        if(qualification.equals("") || workers.equals("")){
            modelMap.addAttribute("validError", true);
            return "qualification";
        }

        IncreaseQualification increaseQualification=null;
        if(!qualification.equals("")) {
            increaseQualification = qualificationRepository.findById(Long.parseLong(qualification));
        }

        Worker worker=null;
        if(!workers.equals("")){
           worker = workerRepository.findById(Long.parseLong(workers));
        }

        if (increaseQualification != null && worker != null){

            worker.setQualificationDate(increaseQualification.getDateOfEnd());
            workerRepository.save(worker);

            IncreaseQualificationRelate increaseQualificationRelate = IncreaseQualificationRelate.builder()
                    .qualification(increaseQualification)
                    .worker(worker)
            .build();

            increaseQualificationRelateRepository.save(increaseQualificationRelate);
        }

        return "qualification";
    }

}
