package ru.knitu.controller.worksSelection.scinceWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.User;
import ru.knitu.repo.ScienceWorkRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.Optional;

@Controller
public class PatentsByYearAction {

    @Autowired
    ScienceWorkRepository scienceWorkRepository;

    @GetMapping("/getpatentsByYearPage")
    public String getpatentsByYearPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", scienceWorkRepository.getPatentsList());
        return "patentsByYear";
    }

    @PostMapping("/getpatentsByYearPage")
    public String getpatentsByYear(ModelMap modelMap, @RequestParam Optional<Integer> yearOfPublication, Authentication authentication){
        if(!yearOfPublication.isPresent()){
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userDetails.getUser();
            String userImage = user.getImage();
            if(userImage==null || userImage.length()==0){
                modelMap.addAttribute("userImage", "logo1.png");
            }
            else{modelMap.addAttribute("userImage", user.getImage()); }
            modelMap.addAttribute("login", user.getLogin());
            //--------------------------------------------------------------

            modelMap.addAttribute("works", scienceWorkRepository.getPatentsList());
            return "patentsByYear";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "/src/uploads/logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", scienceWorkRepository.getListByYearOfPublication(yearOfPublication.get()));
        return "patentsByYear";
    }

}
