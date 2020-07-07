package ru.knitu.controller.addings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.*;
import ru.knitu.repo.EduWorkAuthorsRepository;
import ru.knitu.repo.EducationalWorkRepisitory;
import ru.knitu.repo.ScWorkAuthorsRepository;
import ru.knitu.repo.ScienceWorkRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentWorksExtract {

    @Autowired
    EducationalWorkRepisitory educationalWorkRepisitory;
    @Autowired
    ScienceWorkRepository scienceWorkRepository;
    @Autowired
    EduWorkAuthorsRepository eduWorkAuthorsRepository;
    @Autowired
    ScWorkAuthorsRepository scWorkAuthorsRepository;

    @GetMapping("/getStudentWorks")
    public String getPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        Map<EducationalWork, List<Student>> educationalWorkMap = new HashMap<>();
        Map<ScienceWork, List<Student>> scienceWorkMap = new HashMap<>();

        List<EducationalWorkAuthors> educationalWorkAuthorsList = eduWorkAuthorsRepository.findAllByStudentIsNotNull();
        List<ScienceWorkAuthors> scienceWorkAuthorsList = scWorkAuthorsRepository.findAllByStudentIsNotNull();

        for(EducationalWorkAuthors educationalWorkAuthor : educationalWorkAuthorsList){

            EducationalWork educationalWork = educationalWorkRepisitory.findById(educationalWorkAuthor.getEducationalWork().getId());

            if(!educationalWorkMap.containsKey(educationalWork)){

                List<Student> studentList = new ArrayList<>();
                studentList.add(educationalWorkAuthor.getStudent());

                educationalWorkMap.put(educationalWork, studentList);

            }
            else {
                List<Student> studentList = educationalWorkMap.get(educationalWork);
                studentList.add(educationalWorkAuthor.getStudent());

                educationalWorkMap.put(educationalWork, studentList);
            }
        }

        for(ScienceWorkAuthors scienceWorkAuthor : scienceWorkAuthorsList){

            ScienceWork scienceWork = scienceWorkRepository.findById(scienceWorkAuthor.getScienceWork().getId());

            if(!scienceWorkMap.containsKey(scienceWork)){

                List<Student> studentList = new ArrayList<>();
                studentList.add(scienceWorkAuthor.getStudent());

                scienceWorkMap.put(scienceWork, studentList);

            }
            else {
                List<Student> studentList = scienceWorkMap.get(scienceWork);
                studentList.add(scienceWorkAuthor.getStudent());

                scienceWorkMap.put(scienceWork, studentList);
            }
        }

        modelMap.addAttribute("educational", educationalWorkMap);
        modelMap.addAttribute("science", scienceWorkMap);

        return "studentWorksExtract";
    }

    @PostMapping("/getStudentWorks")
    public String getStudentWorks(Authentication authentication, ModelMap modelMap, @RequestParam String year){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(year == null || year.equals("")){
            return "redirect:/getStudentWorks";
        }

        Map<EducationalWork, List<Student>> educationalWorkMap = new HashMap<>();
        Map<ScienceWork, List<Student>> scienceWorkMap = new HashMap<>();

        List<EducationalWorkAuthors> educationalWorkAuthorsList = eduWorkAuthorsRepository.findAllByStudentIsNotNull();
        List<ScienceWorkAuthors> scienceWorkAuthorsList = scWorkAuthorsRepository.findAllByStudentIsNotNull();

        int yearOfPubl = Integer.parseInt(year);

        for(EducationalWorkAuthors educationalWorkAuthor : educationalWorkAuthorsList){

            EducationalWork educationalWork = educationalWorkRepisitory.findById(educationalWorkAuthor.getEducationalWork().getId());

            if (educationalWork.getYearOfPublication() != yearOfPubl) continue;

            if(!educationalWorkMap.containsKey(educationalWork)){

                List<Student> studentList = new ArrayList<>();
                studentList.add(educationalWorkAuthor.getStudent());

                educationalWorkMap.put(educationalWork, studentList);

            }
            else {
                List<Student> studentList = educationalWorkMap.get(educationalWork);
                studentList.add(educationalWorkAuthor.getStudent());

                educationalWorkMap.put(educationalWork, studentList);
            }
        }

        for(ScienceWorkAuthors scienceWorkAuthor : scienceWorkAuthorsList){

            ScienceWork scienceWork = scienceWorkRepository.findById(scienceWorkAuthor.getScienceWork().getId());

            if (scienceWork.getYearOfPublication() != yearOfPubl) continue;

            if(!scienceWorkMap.containsKey(scienceWork)){

                List<Student> studentList = new ArrayList<>();
                studentList.add(scienceWorkAuthor.getStudent());

                scienceWorkMap.put(scienceWork, studentList);

            }
            else {
                List<Student> studentList = scienceWorkMap.get(scienceWork);
                studentList.add(scienceWorkAuthor.getStudent());

                scienceWorkMap.put(scienceWork, studentList);
            }
        }

        modelMap.addAttribute("educational", educationalWorkMap);
        modelMap.addAttribute("science", scienceWorkMap);

        return "studentWorksExtract";
    }

}
