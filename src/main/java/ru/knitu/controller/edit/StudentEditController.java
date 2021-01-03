package ru.knitu.controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.controller.ControllerUtils;
import ru.knitu.form.StudentForm;
import ru.knitu.model.*;
import ru.knitu.repo.ConferenceParticipantsRepository;
import ru.knitu.repo.EduWorkAuthorsRepository;
import ru.knitu.repo.ScWorkAuthorsRepository;
import ru.knitu.repo.StudentRepository;
import ru.knitu.security.details.UserDetailsImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentEditController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ScWorkAuthorsRepository scWorkAuthorsRepository;
    @Autowired
    EduWorkAuthorsRepository eduWorkAuthorsRepository;
    @Autowired
    ConferenceParticipantsRepository conferenceParticipantsRepository;

    @GetMapping("/studentList")
    public String getStudentList(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("students", studentRepository.findAll());
        return "allstudents";
    }

    @PostMapping("/studentList")
    public String getStudentListByLastName(Authentication authentication, ModelMap modelMap, @RequestParam String lastname){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(lastname == null || lastname.length() == 0){
            return "redirect:/studentList";
        }

        modelMap.addAttribute("students", studentRepository.findAllByLastname(lastname));
        return "allstudents";
    }

    @GetMapping("/studentPage/{student}")
    public String getPage(Authentication authentication, ModelMap modelMap, @PathVariable Student student){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("student", student);
        return "studentPage";
    }

    @GetMapping("/deleteStudent/{student}")
    public String deleteStudent(Authentication authentication, ModelMap modelMap, @PathVariable Student student){

        List<EducationalWorkAuthors> educationalWorkAuthorsList = eduWorkAuthorsRepository.findAllByStudent(student);

        for(EducationalWorkAuthors educationalWorkAuthors : educationalWorkAuthorsList){

                eduWorkAuthorsRepository.delete(educationalWorkAuthors);

        }

        List<ScienceWorkAuthors> scienceWorkAuthorsList = scWorkAuthorsRepository.findAllByStudent(student);

        for(ScienceWorkAuthors scienceWorkAuthors : scienceWorkAuthorsList){

                scWorkAuthorsRepository.delete(scienceWorkAuthors);

        }

        List<ConferenceParticipants> conferenceParticipantsList = conferenceParticipantsRepository.findAllByStudent(student);

        for(ConferenceParticipants conferenceParticipants : conferenceParticipantsList){

                conferenceParticipantsRepository.delete(conferenceParticipants);

        }

        studentRepository.delete(student);


        return "redirect:/studentList";
    }

    @GetMapping("/changeStudent/{student}")
    public String changeStudentPage(Authentication authentication, ModelMap modelMap, @PathVariable Student student){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("student", student);
        return "studentChangePage";
    }

    @PostMapping("/changeStudent/{student}")
    public String changeStudent(Authentication authentication, @Valid StudentForm studentForm, BindingResult bindingResult, ModelMap modelMap, @PathVariable Student student){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if (bindingResult.hasErrors()) {
            modelMap.addAllAttributes(ControllerUtils.getErrors(bindingResult));
            modelMap.addAttribute("validError", true);
            return "studentChangePage";
        }

        Student student1 = Student.builder()
                .firstname(studentForm.getFirstname())
                .lastname(studentForm.getLastname())
                .thirdname(studentForm.getThirdname())
                .telephone(studentForm.getTelephone())
                .educationLevel(studentForm.getEducationLevel())
                .formOfEducation(studentForm.getFormOfEducation())
                .direction(studentForm.getDirection())
                .educationGroup(studentForm.getGroup())
                .id(student.getId())
        .build();


        studentRepository.save(student1);

        return "redirect:/studentPage/"+ student.getId();
    }

}
