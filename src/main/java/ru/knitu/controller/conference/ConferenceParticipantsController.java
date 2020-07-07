package ru.knitu.controller.conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.*;
import ru.knitu.repo.ConferenceParticipantsRepository;
import ru.knitu.repo.ConferenceRepository;
import ru.knitu.repo.StudentRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;

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


        if((workers.equals("") && students.equals("")) || conferences.equals("")){
            modelMap.addAttribute("validError", true);
            return "confParticipants";
        }

        List <Worker>  listWorkers = new ArrayList<>();
        List <Student>  listStudents = new ArrayList<>();

        if(!workers.equals("")){
            String [] workersId = workers.split("#");

            for(int i=0; i<workersId.length; i++){
                listWorkers.add(workerRepository.findById(Long.parseLong(workersId[i])));
            }
        }

        if(!students.equals("")){
            String [] studentsId = students.split("#");

            for(int i=0; i<studentsId.length; i++){
                listStudents.add(studentRepository.findById(Long.parseLong(studentsId[i])));
            }
        }

        for(Worker worker : listWorkers){
            ConferenceParticipants conferenceParticipants = new ConferenceParticipants();
            conferenceParticipants.setWorker(worker);
            conferenceParticipants.setConference_id(Long.parseLong(conferences));
            conferenceParticipantsRepository.save(conferenceParticipants);
        }

        for (Student student : listStudents){
            ConferenceParticipants conferenceParticipants = new ConferenceParticipants();
            conferenceParticipants.setStudent(student);
            conferenceParticipants.setConference_id(Long.parseLong(conferences));
            conferenceParticipantsRepository.save(conferenceParticipants);
        }

        return "confParticipants";
    }
}
