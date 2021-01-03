package ru.knitu.controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.IncreaseQualificationForm;
import ru.knitu.model.IncreaseQualification;
import ru.knitu.model.IncreaseQualificationRelate;
import ru.knitu.model.User;
import ru.knitu.repo.IncreaseQualificationRelateRepository;
import ru.knitu.repo.IncreaseQualificationRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class QulificationEditController {

    @Autowired
    IncreaseQualificationRepository increaseQualificationRepository;
    @Autowired
    IncreaseQualificationRelateRepository increaseQualificationRelateRepository;

    @GetMapping("/getQualificationList")
    public String getPage(Authentication authentication, ModelMap modelMap) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        modelMap.addAttribute("qualificationList", increaseQualificationRepository.findAll());
        return "editQualificationList";
    }

    @PostMapping("/getQualificationList")
    public String getPageByProgramm(Authentication authentication, ModelMap modelMap, @RequestParam String name) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        if (name.length() == 0) return "redirect:/getQualificationList";

        modelMap.addAttribute("qualificationList", increaseQualificationRepository.findAllByProgramm(name));
        return "editQualificationList";
    }


    @GetMapping("/qualificationPage/{qualification}")
    public String getPage(Authentication authentication, ModelMap modelMap, @PathVariable IncreaseQualification qualification) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        modelMap.addAttribute("qualification", qualification);

        return "qualificationPage";
    }

    @GetMapping("/changeQualification/{qualification}")
    public String changePage(Authentication authentication, ModelMap modelMap, @PathVariable IncreaseQualification qualification) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if (userImage == null || userImage.length() == 0) {
            modelMap.addAttribute("userImage", "logo1.png");
        } else {
            modelMap.addAttribute("userImage", user.getImage());
        }
        modelMap.addAttribute("login", user.getLogin());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        modelMap.addAttribute("qualification", qualification);
        modelMap.addAttribute("dateStart", simpleDateFormat.format(qualification.getDateOfBegin()));
        modelMap.addAttribute("dateEnd", simpleDateFormat.format(qualification.getDateOfEnd()));

        return "qualificationEditPage";
    }

    @PostMapping("/changeQualification/{qualification}")
    public String change(@PathVariable IncreaseQualification qualification, IncreaseQualificationForm increaseQualificationForm) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");

        Date dateOfBegin = simpleDateFormat.parse(increaseQualificationForm.getDateOfBegin());
        Date dateOfEnd = simpleDateFormat.parse(increaseQualificationForm.getDateOfEnd());

        qualification.setProgramm(increaseQualificationForm.getProgramm());
        qualification.setCountOfHours(increaseQualificationForm.getCountOfHours());
        qualification.setDateOfBegin(dateOfBegin);
        qualification.setDateOfBeginShow(simpleDateFormatForShow.format(dateOfBegin));
        qualification.setDateOfEnd(dateOfEnd);
        qualification.setDateOfEndShow(simpleDateFormatForShow.format(dateOfEnd));
        qualification.setOrganisation(increaseQualificationForm.getOrganisation());
        qualification.setSeria(increaseQualificationForm.getSeria());
        qualification.setNumber(increaseQualificationForm.getNumber());
        qualification.setNameOfDocument(increaseQualificationForm.getNameOfDocument());

        increaseQualificationRepository.save(qualification);
        return "redirect:/qualificationPage/" + qualification.getId();
    }

    @GetMapping("/deleteQualification/{qualification}")
    public String delete(@PathVariable IncreaseQualification qualification){

        List<IncreaseQualificationRelate> increaseQualificationRelateList = increaseQualificationRelateRepository.findAllByQualification(qualification);
        for(IncreaseQualificationRelate increaseQualificationRelate : increaseQualificationRelateList){

            increaseQualificationRelateRepository.delete(increaseQualificationRelate);

        }

        increaseQualificationRepository.delete(qualification);

        return "redirect:/getQualificationList";
    }
}