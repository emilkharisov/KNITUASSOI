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
import ru.knitu.form.ScienceWorkForm;
import ru.knitu.model.*;
import ru.knitu.repo.ScWorkAuthorsRepository;
import ru.knitu.repo.ScienceWorkRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.List;

@Controller
public class ScWorkEditController {

    @Autowired
    ScienceWorkRepository scienceWorkRepository;
    @Autowired
    ScWorkAuthorsRepository scWorkAuthorsRepository;

    @GetMapping("/scWorkEditList")
    public String getList(Authentication authentication, ModelMap modelMap){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("works", scienceWorkRepository.findAll());
        return "scWorkPageList";
    }

    @PostMapping("/scWorkEditList")
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
            modelMap.addAttribute("works", scienceWorkRepository.findAll());
            return "scWorkPageList";
        }
        int yearInt = Integer.parseInt(year);
        modelMap.addAttribute("works", scienceWorkRepository.findAllByYearOfPublicationOrderByTypeOfWork(yearInt));
        return "scWorkPageList";
    }

    @GetMapping("/scWorkPage/{scWork}")
    public String getPage(Authentication authentication, ModelMap modelMap, @PathVariable ScienceWork scWork){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("work", scWork);
        return "scWorkPage";
    }

    @GetMapping("/deleteScWork/{scWork}")
    public String deleteWork(Authentication authentication, ModelMap modelMap, @PathVariable ScienceWork scWork){

        List<ScienceWorkAuthors> scienceWorkAuthorsList = scWorkAuthorsRepository.findAllByScienceWork(scWork);
        for(ScienceWorkAuthors scienceWorkAuthor : scienceWorkAuthorsList){
            scWorkAuthorsRepository.delete(scienceWorkAuthor);
        }

        scienceWorkRepository.delete(scWork);

        return "redirect:/scWorkEditList";
    }

    @GetMapping("/changeScWork/{scWork}")
    public String changeScWorkPage(Authentication authentication, ModelMap modelMap, @PathVariable ScienceWork scWork){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("work", scWork);

        return "scWorkChangePage";
    }

    @PostMapping("/changeScWork/{scWork}")
    public String changeScWork(ScienceWorkForm scienceWorkForm, Authentication authentication, ModelMap modelMap, @PathVariable ScienceWork scWork){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        scWork.setNameOfWork(scienceWorkForm.getNameOfWork());
        scWork.setNameOfJournal(scienceWorkForm.getNameOfJournal());
        scWork.setNumberOfJournal(scienceWorkForm.getNumberOfJournal());
        scWork.setPages(scienceWorkForm.getPages());
        scWork.setTom(scienceWorkForm.getTom());
        scWork.setTypeOfWork(scienceWorkForm.getTypeOfWork());
        scWork.setYearOfPublication(scienceWorkForm.getYearOfPublication());
        scWork.setRinc(scienceWorkForm.isRinc());
        scWork.setScopus(scienceWorkForm.isScopus());
        scienceWorkRepository.save(scWork);

        modelMap.addAttribute("work", scWork);

        return "redirect:/scWorkPage/"+scWork.getId();
    }

}
