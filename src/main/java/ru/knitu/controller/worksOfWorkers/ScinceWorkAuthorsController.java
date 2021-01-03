package ru.knitu.controller.worksOfWorkers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.knitu.model.*;
import ru.knitu.repo.*;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScinceWorkAuthorsController {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ScWorkAuthorsRepository scWorkAuthorsRepository;
    @Autowired
    ScienceWorkRepository scienceWorkRepository;

    @GetMapping("/addScinceWorkAuthors")
    public String getEducationalWorkPage(Authentication authentication, ModelMap modelMap) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());

        modelMap.addAttribute("workers", workerRepository.findAll());
        modelMap.addAttribute("students", studentRepository.findAll());
        modelMap.addAttribute("works", scienceWorkRepository.findAll());
        return "scienceAuthors";
    }

    @PostMapping("/addScinceWorkAuthors")
    public String addEducationalWork(ModelMap modelMap, Authentication authentication, @RequestParam String works, @RequestParam String workers, @RequestParam String students){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------
        modelMap.addAttribute("workers", workerRepository.findAll());
        modelMap.addAttribute("students", studentRepository.findAll());
        modelMap.addAttribute("works", scienceWorkRepository.findAll());


        if((workers.equals("") && students.equals("")) || works.equals("")){
            modelMap.addAttribute("validError", true);
            return "eduAuthors";
        }

        List<Worker> listWorkers = new ArrayList<>();
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

        for (Worker worker : listWorkers){
            ScienceWorkAuthors scienceWorkAuthors = new ScienceWorkAuthors();
            scienceWorkAuthors.setWorker(worker);
            scienceWorkAuthors.setScienceWork(scienceWorkRepository.findById(Long.parseLong(works)));
            scWorkAuthorsRepository.save(scienceWorkAuthors);
        }

        for (Student student : listStudents){
            ScienceWorkAuthors scienceWorkAuthors = new ScienceWorkAuthors();
            scienceWorkAuthors.setStudent(student);
            scienceWorkAuthors.setScienceWork(scienceWorkRepository.findById(Long.parseLong(works)));
            scWorkAuthorsRepository.save(scienceWorkAuthors);
        }
        return "scienceAuthors";
    }
}
