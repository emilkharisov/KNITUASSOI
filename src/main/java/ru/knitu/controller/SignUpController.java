package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.knitu.form.UserForm;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.SignUpService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @Value("${upload.path1}")
    String uploadPath;
    @Value("${activateKey}")
    String activateKey;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }
    @PostMapping("/signUp")
    public String signUp(@Valid UserForm userForm, BindingResult bindingResult, ModelMap modelMap, @RequestParam("image") MultipartFile file) throws IOException {
        if(!activateKey.equals(userForm.getActivateKey())){
            modelMap.addAttribute("error",true);
            return "signUp";
        }

        if(userRepository.findUserByLogin(userForm.getLogin()) != null){
            modelMap.addAttribute("error1",true);
            return "signUp";
        }

        if(bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            modelMap.addAllAttributes(errors);
            modelMap.addAttribute("validError",true);
            return "signUp";
        }
        else {
            String resultFileName = null;
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                resultFileName = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFileName));
            }
            signUpService.signUp(userForm, resultFileName);
            return "redirect:/login";
        }
    }
}
