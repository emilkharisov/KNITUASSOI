package ru.knitu.controller.addings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.Conference;
import ru.knitu.model.ConferenceParticipants;
import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.ConferenceParticipantsRepository;
import ru.knitu.repo.ConferenceRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.*;

@Controller
public class ConferenceExtractController {

    @Autowired
    ConferenceParticipantsRepository conferenceParticipantsRepository;
    @Autowired
    ConferenceRepository conferenceRepository;
    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/getСonfExctract")
    public String getPage(Authentication authentication, ModelMap modelMap){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        HashMap<Conference, ArrayList<Worker>> map = new HashMap<>();
        for(ConferenceParticipants conferenceParticipants : conferenceParticipantsRepository.findAll()){

            Conference conference = conferenceRepository.findById(conferenceParticipants.getConference_id());
            Worker worker = conferenceParticipants.getWorker();

            if (worker== null) continue;

            if(map.containsKey(conference)){
                ArrayList<Worker> listOfWorker = map.get(conference);
                listOfWorker.add(worker);
                map.put(conference, listOfWorker);
            }
            else{
                ArrayList<Worker> listOfWorker = new ArrayList<>();
                listOfWorker.add(worker);
                map.put(conference, listOfWorker);
            }
        }


        modelMap.addAttribute("map", map);

        return "confExctract";
    }

    @PostMapping("/getСonfExctract")
    public String getСonfExctract(Authentication authentication, ModelMap modelMap, @RequestParam String year){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(year== null || year.equals("")){
            return "redirect:/getСonfExctract";
        }


        HashMap<Conference, ArrayList<Worker>> map = new HashMap<>();
        for(ConferenceParticipants conferenceParticipants : conferenceParticipantsRepository.findAll()) {

            Conference conference = conferenceRepository.findById(conferenceParticipants.getConference_id());
            Worker worker = conferenceParticipants.getWorker();

            if (worker == null) continue;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(conference.getDateOfStart());
            if (calendar.get(Calendar.YEAR) != Integer.parseInt(year)) continue;

            if (map.containsKey(conference)) {
                ArrayList<Worker> listOfWorker = map.get(conference);
                listOfWorker.add(worker);
                map.put(conference, listOfWorker);
            } else {
                ArrayList<Worker> listOfWorker = new ArrayList<>();
                listOfWorker.add(worker);
                map.put(conference, listOfWorker);
            }

        }
            if(!map.isEmpty()) modelMap.addAttribute("map", map);

            if (map.isEmpty()) return "redirect:/getConfExctractError";

        return "confExctract";
    }

    @GetMapping("/getConfExctractError")
    public String getPageWithParams(Authentication authentication, ModelMap modelMap){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        HashMap<Conference, ArrayList<Worker>> map = new HashMap<>();
        for(ConferenceParticipants conferenceParticipants : conferenceParticipantsRepository.findAll()){

            Conference conference = conferenceRepository.findById(conferenceParticipants.getConference_id());
            Worker worker = conferenceParticipants.getWorker();

            if (worker== null) continue;

            if(map.containsKey(conference)){
                ArrayList<Worker> listOfWorker = map.get(conference);
                listOfWorker.add(worker);
                map.put(conference, listOfWorker);
            }
            else{
                ArrayList<Worker> listOfWorker = new ArrayList<>();
                listOfWorker.add(worker);
                map.put(conference, listOfWorker);
            }
        }

        modelMap.addAttribute("empty", true);
        modelMap.addAttribute("map", map);

        return "confExctract";
    }

}
