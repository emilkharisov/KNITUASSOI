package ru.knitu.controller.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.knitu.model.User;
import ru.knitu.model.Worker;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.MailSender;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class MailSenderController {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    MailSender mailSender;
    @Value("${upload.path4}")
    String uploadPath;

    @GetMapping("/mailSender")
    public String getPage(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("workers", workerRepository.findAll());
        return "mailSender";
    }

    @PostMapping("/mailSender")
    public String sendMail(Authentication authentication, ModelMap modelMap, @RequestParam String workers, @RequestParam String message, @RequestParam("image") MultipartFile file, @RequestParam String subj) throws IOException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("workers", workerRepository.findAll());

        if(subj.equals("")){
            subj = "Кафедра АССОИ";
        }

        ArrayList <Worker> listOfWorkers = new ArrayList<>();
        for(int i=0; i<workers.split("&").length; i++){
            listOfWorkers.add(workerRepository.findById(Long.parseLong(workers.split("&")[i])));
        }

        String resultFileName = null;
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));

            String path = uploadPath + "/" + resultFileName;
            for(Worker worker : listOfWorkers){
                mailSender.send(worker.getEmail(),subj, message, true, path);
            }
        }
        else{

            for(Worker worker : listOfWorkers){
                mailSender.send(worker.getEmail(),subj, message, false, "");
            }

        }


        return "mailSender";
    }

}
