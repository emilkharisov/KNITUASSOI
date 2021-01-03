package ru.knitu.controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.EducationalWorkForm;
import ru.knitu.model.*;
import ru.knitu.repo.EduWorkAuthorsRepository;
import ru.knitu.repo.EducationalWorkRepisitory;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.List;

@Controller
public class EduWorkEditController {

    @Autowired
    EducationalWorkRepisitory educationalWorkRepisitory;
    @Autowired
    EduWorkAuthorsRepository eduWorkAuthorsRepository;

    @GetMapping("/eduWorkEditList")
    public String getList(Authentication authentication, ModelMap modelMap){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("works", educationalWorkRepisitory.findAll());
        return "eduWorkPageList";
    }

    @PostMapping("/eduWorkEditList")
    public String getListByYear(Authentication authentication, ModelMap modelMap, @RequestParam String year){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(year.length() == 0){
            modelMap.addAttribute("works", educationalWorkRepisitory.findAll());
            return "eduWorkPageList";
        }
        int yearInt = Integer.parseInt(year);
        modelMap.addAttribute("works", educationalWorkRepisitory.findAllByYearOfPublicationOrderByTypeOfWork(yearInt));
        return "eduWorkPageList";
    }

    @GetMapping("/eduWorkPage/{educationalWork}")
    public String getPage(Authentication authentication, ModelMap modelMap, @PathVariable EducationalWork educationalWork){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("work", educationalWork);
        return "eduWorkPage";
    }

    @GetMapping("/deleteEduWork/{educationalWork}")
    public String deleteWork(Authentication authentication, ModelMap modelMap, @PathVariable EducationalWork educationalWork){

        List <EducationalWorkAuthors> educationalWorkAuthorsList = eduWorkAuthorsRepository.findAllByEducationalWork(educationalWork);
        for(EducationalWorkAuthors educationalWorkAuthors : educationalWorkAuthorsList){
            eduWorkAuthorsRepository.delete(educationalWorkAuthors);
        }

        educationalWorkRepisitory.delete(educationalWork);

        return "redirect:/eduWorkEditList";
    }

    @GetMapping("/changeEduWork/{educationalWork}")
    public String changeEduWorkPage(Authentication authentication, ModelMap modelMap, @PathVariable EducationalWork educationalWork){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("work", educationalWork);

        return "eduWorkChangePage";
    }

    @PostMapping("/changeEduWork/{educationalWork}")
    public String changeEduWork(Authentication authentication, ModelMap modelMap, @PathVariable EducationalWork educationalWork, EducationalWorkForm educationalWorkForm){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        educationalWork.setNameOfWork(educationalWorkForm.getNameOfWork());
        educationalWork.setTypeOfWork(educationalWorkForm.getTypeOfWork());
        educationalWork.setAmountOfPages(educationalWorkForm.getAmountOfPages());
        educationalWork.setPublishing(educationalWorkForm.getPublishing());

        educationalWorkRepisitory.save(educationalWork);

        modelMap.addAttribute("work", educationalWork);

        return "redirect:/eduWorkPage/"+educationalWork.getId();
    }
}
