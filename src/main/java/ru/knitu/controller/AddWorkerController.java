package ru.knitu.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.security.core.Authentication;
        import org.springframework.ui.ModelMap;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.multipart.MultipartFile;
        import ru.knitu.form.WorkerForm;
        import ru.knitu.model.User;
        import ru.knitu.security.details.UserDetailsImpl;
        import ru.knitu.service.AddWorkerService;

        import javax.validation.Valid;
        import java.io.File;
        import java.io.IOException;
        import java.text.ParseException;
        import java.util.UUID;

@org.springframework.stereotype.Controller
public class AddWorkerController {
    @Autowired
    AddWorkerService addWorkerService;
    @Value("${upload.path}")
    String uploadPath;
    @Value("${upload.path3}")
    String uploadPath3;

    @GetMapping("/addWorker")
    public String method(Authentication authentication, ModelMap modelMap) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        modelMap.addAttribute("userImage", ControllerUtils.setUserImage(userImage));
        modelMap.addAttribute("name", user.getLogin());
        modelMap.addAttribute("image", user.getImage());
        modelMap.addAttribute("im", uploadPath3);
        modelMap.addAttribute("login", user.getLogin());
        return "addWorker";
    }


    @PostMapping("/addWorker")
    public String method1(@Valid WorkerForm workerForm, BindingResult bindingResult, ModelMap modelMap, @RequestParam("image") MultipartFile file, Authentication authentication) throws IOException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        modelMap.addAttribute("userImage", ControllerUtils.setUserImage(userImage));
        modelMap.addAttribute("login", user.getLogin());

        if (bindingResult.hasErrors()) {
            modelMap.addAllAttributes(ControllerUtils.getErrors(bindingResult));
            modelMap.addAttribute("validError", true);
            return "addWorker";
        } else {
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
            try {
                addWorkerService.addWorker(workerForm, resultFileName);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return "redirect:/addWorker";
        }
    }
}
