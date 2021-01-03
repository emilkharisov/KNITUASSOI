package ru.knitu.controller.worksOfWorkers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.EducationalWorkForm;
import ru.knitu.model.EducationalWorkAuthors;
import ru.knitu.model.Student;
import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.EduWorkAuthorsRepository;
import ru.knitu.repo.EducationalWorkRepisitory;
import ru.knitu.repo.StudentRepository;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EduWorkAuthorsController {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EduWorkAuthorsRepository eduWorkAuthorsRepository;
    @Autowired
    EducationalWorkRepisitory educationalWorkRepisitory;

    @GetMapping("/addEducationalWorkAuthors")
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
        modelMap.addAttribute("works", educationalWorkRepisitory.findAll());
        return "eduAuthors";
    }

    @PostMapping("/addEducationalWorkAuthors")
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
        modelMap.addAttribute("works", educationalWorkRepisitory.findAll());

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
            EducationalWorkAuthors educationalWorkAuthors = new EducationalWorkAuthors();
            educationalWorkAuthors.setWorker(worker);
            educationalWorkAuthors.setEducationalWork(educationalWorkRepisitory.findById(Long.parseLong(works)));
            eduWorkAuthorsRepository.save(educationalWorkAuthors);
        }

        for (Student student : listStudents){
            EducationalWorkAuthors educationalWorkAuthors = new EducationalWorkAuthors();
            educationalWorkAuthors.setStudent(student);
            educationalWorkAuthors.setEducationalWork(educationalWorkRepisitory.findById(Long.parseLong(works)));
            eduWorkAuthorsRepository.save(educationalWorkAuthors);
        }
        return "eduAuthors";
    }
}
