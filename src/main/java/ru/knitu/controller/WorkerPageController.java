package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.knitu.form.WorkerForm;
import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class WorkerPageController {
    @Autowired
    WorkerRepository workerRepository;
    @Value("${upload.path}")
    String uploadPath;

    @GetMapping("/getWorkerPage/{worker}")
    public String getWorkerPage(Authentication authentication, ModelMap modelMap, @PathVariable Worker worker){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        if(worker.getImage()==null || worker.getImage().length()==0){
            modelMap.addAttribute("workerImage", "/img/usersImg/logo1.png");
        }
        else{modelMap.addAttribute("workerImage", "/img/workersImg/"+worker.getImage()); }
        modelMap.addAttribute("login",user.getLogin());
        modelMap.addAttribute("worker",worker);
        if(worker.getCheckMagistr()==null){modelMap.addAttribute("magistr","Нет"); }
        else{modelMap.addAttribute("magistr","Да"); }
        return "workerPage";
    }
    @GetMapping("/getMainPage")
    public String getMainPage(Authentication authentication, ModelMap modelMap){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());
        return "mainPage";
    }

    @GetMapping("/deleteWorker/{worker}")
    public String deleteWorker(HttpServletRequest request, @PathVariable Worker worker){
        workerRepository.delete(worker);
        return "redirect:/getAllWorkersPage";
    }

    @GetMapping("/changeWorker/{worker}")
    public String changeWorker(Authentication authentication, ModelMap modelMap, @PathVariable Worker worker){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        modelMap.addAttribute("userImage", ControllerUtils.setUserImage(userImage));
        modelMap.addAttribute("login", user.getLogin());
        modelMap.addAttribute("worker",worker);
        if(worker.getImage()==null || worker.getImage().length()==0){
            modelMap.addAttribute("workerImage", "/img/usersImg/logo1.png");
        }
        else{modelMap.addAttribute("workerImage", "/img/workersImg/"+worker.getImage()); }
        if(worker.getCheckMagistr()==null){modelMap.addAttribute("magistr","Нет"); }
        else{modelMap.addAttribute("magistr","Да"); }
        return "workerChangePage";
    }

    @PostMapping("/changeWorker/{worker}")
    public String updateWorker(WorkerForm workerForm, Authentication authentication, ModelMap modelMap, @PathVariable Worker worker, @RequestParam("image") MultipartFile file) throws IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");
        String resultFileName=null;
        String telephone = (workerForm.getTelephone().equals(worker.getTelephone()) ? worker.getTelephone() :workerForm.getTelephone());
        String education = (workerForm.getEducation().equals(worker.getEducation()) ? worker.getEducation() :workerForm.getEducation());
        String position = (workerForm.getPosition().equals(worker.getPosition()) ? worker.getPosition() :workerForm.getPosition());
        String academicRank = (workerForm.getAcademicRank().equals(worker.getAcademicRank()) ? worker.getAcademicRank() :workerForm.getAcademicRank());
        String academicDegree = (workerForm.getAcademicDegree().equals(worker.getAcademicDegree()) ? worker.getAcademicDegree() :workerForm.getAcademicDegree());

        Date dateOfBeginWork = null;
        String dateOfBeginWorkShow = null;
        if(workerForm.getDateOfBeginWork()==null || workerForm.getDateOfBeginWork().length()==0){
            dateOfBeginWork=worker.getDateOfBeginWork();
            dateOfBeginWorkShow = worker.getDateOfBeginWorkShow();
        }else{
            dateOfBeginWork = simpleDateFormat.parse(workerForm.getDateOfBeginWork());
            dateOfBeginWorkShow = simpleDateFormatForShow.format(dateOfBeginWork);
        }
        Date dateEndOfContract = null;
        String dateEndOfContractShow = null;
        if(workerForm.getDateEndOfContract()==null || workerForm.getDateEndOfContract().length()==0){
            dateEndOfContract=worker.getDateEndOfContract();
            dateEndOfContractShow = worker.getDateEndOfContractShow();
        }else{
            dateEndOfContract = simpleDateFormat.parse(workerForm.getDateEndOfContract());
            dateEndOfContractShow = simpleDateFormatForShow.format(dateEndOfContract);
        }
        Date dateOfBirth = null;
        String dateOfBirthShow = null;
        if(workerForm.getDateOfBirth()==null || workerForm.getDateOfBirth().length()==0){
            dateOfBirth=worker.getDateOfBirth();
            dateOfBirthShow = worker.getDateOfBirthShow();
        }else{
            dateOfBirth = simpleDateFormat.parse(workerForm.getDateOfBirth());
            dateOfBirthShow = simpleDateFormatForShow.format(dateOfBirth);
        }
        Boolean checkMagistr = null;
        if(workerForm.getCheckMagistr()== worker.getCheckMagistr()){checkMagistr=worker.getCheckMagistr();}
        else{checkMagistr=workerForm.getCheckMagistr();}
        if(file == null || file.getOriginalFilename().isEmpty()){
            resultFileName = worker.getImage();
        }
        else {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
        }
        //----------------------------------------------------------------------------------------------------//
        worker.setAcademicDegree(academicDegree);
        worker.setAcademicRank(academicRank);
        worker.setCheckMagistr(checkMagistr);
        worker.setTelephone(telephone);
        worker.setEducation(education);
        worker.setImage(resultFileName);
        worker.setDateOfBirth(dateOfBirth);
        worker.setPosition(position);
        worker.setDateOfBirthShow(dateOfBirthShow);
        worker.setDateEndOfContract(dateEndOfContract);
        worker.setDateEndOfContractShow(dateEndOfContractShow);
        worker.setDateOfBeginWork(dateOfBeginWork);
        worker.setDateOfBeginWorkShow(dateOfBeginWorkShow);
        workerRepository.save(worker);
        return "redirect:/getWorkerPage/31";
    }
}
