package ru.knitu.controller.workersSelection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.model.User;
import ru.knitu.repo.WorkerRepository;
import ru.knitu.security.details.UserDetailsImpl;

@Controller
public class СheckMagistrAction {
    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/getCheckMagistrPage")
    public String getCheckMagistrPage(ModelMap modelMap, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login", user.getLogin());
        //--------------------------------------------------------------

        modelMap.addAttribute("workers",workerRepository.findAllByCheckMagistrIsNull());
        return "checkMagistr";
    }
}
