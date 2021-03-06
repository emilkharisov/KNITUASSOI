package ru.knitu.controller.intellectualProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.IntellectualProperty;
import ru.knitu.model.IntellectualPropertyAuthors;
import ru.knitu.model.User;
import ru.knitu.repo.IntellectualPropertyAuthorsRepository;
import ru.knitu.repo.IntellectualPropertyRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

@Controller
public class IntellectualPropertyAuthorsController {

    @Autowired
    IntellectualPropertyRepository intellectualPropertyRepository;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    IntellectualPropertyAuthorsRepository intellectualPropertyAuthorsRepository;

    @GetMapping("/intellectualPropertyAuthors")
    public String getPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("conferences",intellectualPropertyRepository.findAll());
        modelMap.addAttribute("workers",workerRepository.findAll());

        return "intellectualAuthors";
    }

    @PostMapping("/intellectualPropertyAuthors")
    public String addIntellectualPropertyAuthors(Authentication authentication, ModelMap modelMap, @RequestParam String intellectualProperty, @RequestParam String workers){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("conferences",intellectualPropertyRepository.findAll());
        modelMap.addAttribute("workers",workerRepository.findAll());

        if(intellectualProperty.equals("") || workers.equals("")){
            modelMap.addAttribute("validError",true);
            return "intellectualAuthors";
        }

        IntellectualPropertyAuthors intellectualPropertyAuthors = new IntellectualPropertyAuthors();



        IntellectualProperty intellectualProperty1 = intellectualPropertyRepository.findById(Long.parseLong(intellectualProperty));
        intellectualPropertyAuthors.setIntellectualProperty(intellectualProperty1);

        if(!workers.equals("")){

            intellectualPropertyAuthors.setWorker(workerRepository.findById(Long.parseLong(workers)));
        }
        intellectualPropertyAuthorsRepository.save(intellectualPropertyAuthors);
        return "intellectualAuthors";
    }

}
