package ru.knitu.controller.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.Message;
import ru.knitu.model.User;
import ru.knitu.repo.MessageRepository;
import ru.knitu.repo.UserRepository;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.AddessageService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatController {

    @Autowired
    AddessageService addessageService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/getChatPage/{userPath}")
    public String getPage(Authentication authentication, ModelMap modelMap, @PathVariable User userPath){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("users", userRepository.findAll());

        modelMap.addAttribute("userPath", userPath);
        modelMap.addAttribute("currentUser", user);

        modelMap.addAttribute("messages", messageRepository.findAllByFromUserAndToUserOrFromUserAndToUserOrderByDate(user, userPath, userPath, user));


        return  "chat";
    }

    @GetMapping("/getChatPage/{userPath}/search")
    public String getPageSearch(Authentication authentication, ModelMap modelMap, HttpServletRequest httpServletRequest, @PathVariable User userPath){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("users", userRepository.findAllByLastnameContaining(httpServletRequest.getParameter("textSearch")));

        modelMap.addAttribute("userPath", userPath);
        modelMap.addAttribute("currentUser", user);

        modelMap.addAttribute("messages", messageRepository.findAllByFromUserAndToUserOrFromUserAndToUserOrderByDate(user, userPath, userPath, user));

        return  "chat";
    }

    @PostMapping("/getChatPage/{userPath}")
    public String addMsg(Authentication authentication, ModelMap modelMap, @RequestParam String msg, @PathVariable User userPath){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        addessageService.addMessage(msg, user, userPath);

        return  "redirect:/getChatPage/"+userPath.getId();
    }

}
