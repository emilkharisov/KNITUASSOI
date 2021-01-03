package ru.knitu.controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.ConferenceForm;
import ru.knitu.model.Conference;
import ru.knitu.model.ConferenceParticipants;
import ru.knitu.model.User;
import ru.knitu.repo.ConferenceParticipantsRepository;
import ru.knitu.repo.ConferenceRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ConferenceEditController {

    @Autowired
    ConferenceRepository conferenceRepository;
    @Autowired
    ConferenceParticipantsRepository conferenceParticipantsRepository;

    @GetMapping("/conferenceEditList")
    public String getPage(Authentication authentication, ModelMap modelMap){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("conferences", conferenceRepository.findAll());
        return "conferenceEditList";
    }

    @PostMapping("/conferenceEditList")
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
            modelMap.addAttribute("conferences", conferenceRepository.findAll());
            return "conferenceEditList";
        }

        modelMap.addAttribute("conferences", conferenceRepository.findAllByNameOrderByDateOfStart(name));
        return "conferenceEditList";
    }

    @GetMapping("/conferencePage/{conference}")
    public String getConferencePage(Authentication authentication, ModelMap modelMap, @PathVariable Conference conference){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("conference", conference);
        return "conferencePage";
    }

    @GetMapping("/conferenceDelete/{conference}")
    public String delete(Authentication authentication, ModelMap modelMap, @PathVariable Conference conference){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

       for(ConferenceParticipants conferenceParticipants : conferenceParticipantsRepository.getConferenceParticipants(conference.getId())){
           conferenceParticipantsRepository.delete(conferenceParticipants);
        }
        conferenceRepository.delete(conference);

        return "redirect:/conferenceEditList";
    }

    @GetMapping("/conferenceChange/{conference}")
    public String changePage(Authentication authentication, ModelMap modelMap, @PathVariable Conference conference){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        modelMap.addAttribute("startDate", simpleDateFormat.format(conference.getDateOfStart()));
        modelMap.addAttribute("endDate", simpleDateFormat.format(conference.getDateOfEnd()));
        modelMap.addAttribute("conference", conference);

        return "conferenceChange";
    }

    @PostMapping("/conferenceChange/{conference}")
    public String change(Authentication authentication, ModelMap modelMap, @PathVariable Conference conference, ConferenceForm conferenceForm) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfStart = simpleDateFormat.parse(conferenceForm.getDateOfStart());
        Date dateOfEnd = simpleDateFormat.parse(conferenceForm.getDateOfEnd());

        conference.setName(conferenceForm.getName());
        conference.setCity(conference.getCity());
        conference.setDateOfStart(dateOfStart);
        conference.setDateOfEnd(dateOfEnd);
        conference.setLevel(conferenceForm.getLevel());
        conference.setDateOfStartShow(simpleDateFormatForShow.format(dateOfStart));
        conference.setDateOfEndShow(simpleDateFormatForShow.format(dateOfEnd));

        conferenceRepository.save(conference);

        return "redirect:/conferencePage/"+conference.getId();

    }

    }
