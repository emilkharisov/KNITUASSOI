package ru.knitu.controller.conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.Conference;
import ru.knitu.model.ConferenceParticipants;
import ru.knitu.model.User;
import ru.knitu.repo.ConferenceParticipantsRepository;
import ru.knitu.repo.ConferenceRepository;
import ru.knitu.repo.StudentRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.ArrayList;

@Controller
public class ConferenceParticipantsController {
    @Value("${upload.path}")
    String uploadPath;

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ConferenceRepository conferenceRepository;
    @Autowired
    ConferenceParticipantsRepository conferenceParticipantsRepository;

    @GetMapping("/addConferenceParticipants")
    public String getAddConferenceParticipantsPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        modelMap.addAttribute("conferences",conferenceRepository.findAll());
        modelMap.addAttribute("workers",workerRepository.findAll());
        modelMap.addAttribute("students",studentRepository.findAll());

        return "confParticipants";
    }

    @PostMapping("/addConferenceParticipants")
    public String addConferenceParticipants(Authentication authentication, ModelMap modelMap, @RequestParam String conferences, @RequestParam String workers, @RequestParam String students){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        modelMap.addAttribute("conferences",conferenceRepository.findAll());
        modelMap.addAttribute("workers",workerRepository.findAll());
        modelMap.addAttribute("students",studentRepository.findAll());


        ConferenceParticipants conferenceParticipants = new ConferenceParticipants();
        String conferenceName = conferences.split("\\|")[0];
        String conferenceDate = conferences.split("\\|")[1];
        System.out.println(conferences);
        System.out.println(conferenceName+" "+conferenceDate);

        conferenceParticipants.setConference_id(conferenceRepository.findOneByNameAndDateOfStartShow(conferenceName, conferenceDate).getId());
        if(!workers.equals("")){
            String firstName = workers.split("\\|")[1];
            String lastName = workers.split("\\|")[0];
            String thirdName = workers.split("\\|")[2];
            String position = workers.split("\\|")[3];
            conferenceParticipants.setWorker_id(workerRepository.findByLastnameAndFirstnameAndThirdnameAndPosition(lastName, firstName, thirdName, position).getId());
        }

        if(!students.equals("")){
            String firstName = students.split("\\|")[1];
            String lastName = students.split("\\|")[0];
            String thirdName = students.split("\\|")[2];
            String group = students.split("\\|")[3];
            conferenceParticipants.setStudent_id(studentRepository.findByLastnameAndFirstnameAndThirdnameAndEducationGroup(lastName,firstName,thirdName,group).getId());
        }
        conferenceParticipantsRepository.save(conferenceParticipants);
        return "confParticipants";
    }
}
