package ru.knitu.controller.conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.ConferenceForm;
import ru.knitu.model.User;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.AddConferenceService;

import java.text.ParseException;

@Controller
public class AddConferenceController {
    @Autowired
    AddConferenceService addConferenceService;
    @Value("${upload.path}")
    String uploadPath;

    @GetMapping("/addConference")
    public String getAddConferencePage(Authentication authentication, ModelMap modelMap) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        return "addConference";
    }

    @PostMapping("/addConference")
    public String addConference(Authentication authentication, ModelMap modelMap, ConferenceForm conferenceForm) throws ParseException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        addConferenceService.addConference(conferenceForm);

        return "addConference";
    }
}