package ru.knitu.controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.CandidateWorkForm;
import ru.knitu.model.CandidateWork;
import ru.knitu.model.User;
import ru.knitu.repo.CandidateWorkRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CandidateWorkEditController {

    @Autowired
    CandidateWorkRepository candidateWorkRepository;

    @GetMapping("getCandidateEditList")
    public String getList(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("candidateWorks", candidateWorkRepository.findAll());

        return "candidateWorkEditList";
    }

    @PostMapping("/getCandidateEditList")
    public String getListByName(Authentication authentication, ModelMap modelMap, @RequestParam String name){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(name.length() == 0){
            modelMap.addAttribute("candidateWorks", candidateWorkRepository.findAll());
            return "candidateWorkEditList";
        }

        modelMap.addAttribute("candidateWorks", candidateWorkRepository.findAllByNameContaining(name));

        return "candidateWorkEditList";
    }

    @GetMapping("/candidatePage/{candidate}")
    public String getConferencePage(Authentication authentication, ModelMap modelMap, @PathVariable CandidateWork candidate){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("candidateWork", candidate);
        return "candidateWorkPage";
    }

    @GetMapping("/candidateChange/{candidate}")
    public String getChangePage(Authentication authentication, ModelMap modelMap, @PathVariable CandidateWork candidate){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        modelMap.addAttribute("date", simpleDateFormat.format(candidate.getDate()));
        modelMap.addAttribute("candidateWork", candidate);
        return "candidateChange";
    }

    @PostMapping("/candidateChange/{candidate}")
    public String change (Authentication authentication, ModelMap modelMap, @PathVariable CandidateWork candidate, CandidateWorkForm candidateWorkForm) throws ParseException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");
        Date date = simpleDateFormat.parse(candidateWorkForm.getDate());

        candidate.setType(candidateWorkForm.getType());
        candidate.setName(candidateWorkForm.getName());
        candidate.setDate(date);
        candidate.setDateShow(simpleDateFormatForShow.format(date));
        candidate.setNumberOfDocument(candidateWorkForm.getNumberOfDocument());
        candidate.setSciences(candidateWorkForm.getSciences());
        candidate.setSpecialization(candidateWorkForm.getSpecialization());
        candidate.setPlace(candidateWorkForm.getPlace());

        candidateWorkRepository.save(candidate);

        return "redirect:/candidatePage/" + candidate.getId();
    }

    @GetMapping("/candidateDelete/{candidate}")
    public String delete(@PathVariable CandidateWork candidate){

        candidateWorkRepository.delete(candidate);

        return "redirect:/getCandidateEditList";
    }

}
