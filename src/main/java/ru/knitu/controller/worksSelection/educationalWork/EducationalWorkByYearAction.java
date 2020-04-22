package ru.knitu.controller.worksSelection.educationalWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.User;
import ru.knitu.repo.EducationalWorkRepisitory;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.Optional;

@Controller
public class EducationalWorkByYearAction {

    @Autowired
    EducationalWorkRepisitory educationalWorkRepisitory;

    @GetMapping("/getBooksByYearPage")
    public String getBooksByYearPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", educationalWorkRepisitory.getPatentsListBooks());
        return "booksByYearEducational";
    }

    @PostMapping("/getBooksByYearPage")
    public String getBooksByYear(ModelMap modelMap, @RequestParam Optional <Integer> yearOfPublication, Authentication authentication){
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

            modelMap.addAttribute("works", educationalWorkRepisitory.getPatentsListBooks());
            return "booksByYearEducational";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", educationalWorkRepisitory.getListByYearOfPublicationBooks(yearOfPublication.get()));
        return "booksByYearEducational";
    }

    @GetMapping("/getMethodologyByYearPage")
    public String getMethodologyByYearPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", educationalWorkRepisitory.getPatentsListMethodology());
        return "methologyByYearEducational";
    }

    @PostMapping("/getMethodologyByYearPage")
    public String getMethodologyByYear(ModelMap modelMap, @RequestParam Optional <Integer> yearOfPublication, Authentication authentication){
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

            modelMap.addAttribute("works", educationalWorkRepisitory.getPatentsListMethodology());
            return "methologyByYearEducational";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", educationalWorkRepisitory.getListByYearOfPublicationMethodology(yearOfPublication.get()));
        return "methologyByYearEducational";
    }

    @GetMapping("/getBenefitsByYearPage")
    public String getBenefitsByYearPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", educationalWorkRepisitory.getPatentsListBenefits());
        return "benefitsByYearEducational";
    }

    @PostMapping("/getBenefitsByYearPage")
    public String getBenefitsByYear(ModelMap modelMap, @RequestParam Optional <Integer> yearOfPublication, Authentication authentication){
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

            modelMap.addAttribute("works", educationalWorkRepisitory.getPatentsListBenefits());
            return "benefitsByYearEducational";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("works", educationalWorkRepisitory.getListByYearOfPublicationBenefits(yearOfPublication.get()));
        return "benefitsByYearEducational";
    }
}
