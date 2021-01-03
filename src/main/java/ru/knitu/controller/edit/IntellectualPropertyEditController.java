package ru.knitu.controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.IntellectualPropertyForm;
import ru.knitu.model.IntellectualProperty;
import ru.knitu.model.IntellectualPropertyAuthors;
import ru.knitu.model.User;
import ru.knitu.repo.IntellectualPropertyAuthorsRepository;
import ru.knitu.repo.IntellectualPropertyRepository;
import ru.knitu.security.details.UserDetailsImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class IntellectualPropertyEditController {

    @Autowired
    IntellectualPropertyRepository intellectualPropertyRepository;
    @Autowired
    IntellectualPropertyAuthorsRepository intellectualPropertyAuthorsRepository;

    @GetMapping("/getPropList")
    public String getList(Authentication authentication, ModelMap modelMap){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.put("propList", intellectualPropertyRepository.findAll());

        return "editIntellectualList";
    }

    @PostMapping("/getPropList")
    public String searchByName(Authentication authentication, ModelMap modelMap, @RequestParam String name){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        if(name.length() == 0) return  "redirect:/getPropList";
        modelMap.put("propList", intellectualPropertyRepository.findAllByName(name));

        return "editIntellectualList";
    }

    @GetMapping("/progPage/{prop}")
    public String getPage(Authentication authentication, ModelMap modelMap, @PathVariable IntellectualProperty prop){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        modelMap.addAttribute("prop", prop);

        return "intPropPage";
    }

    @GetMapping("/deleteProp/{prop}")
    public String delete(@PathVariable IntellectualProperty prop){

        List<IntellectualPropertyAuthors> intellectualPropertyAuthorsList = intellectualPropertyAuthorsRepository.findAllByIntellectualProperty(prop);
        for(IntellectualPropertyAuthors intellectualPropertyAuthors : intellectualPropertyAuthorsList){
            intellectualPropertyAuthorsRepository.delete(intellectualPropertyAuthors);
        }

        intellectualPropertyRepository.delete(prop);

        return "redirect:/getPropList";
    }

    @GetMapping("/changeProp/{prop}")
    public String changePage(Authentication authentication, ModelMap modelMap, @PathVariable IntellectualProperty prop){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        String userImage = user.getImage();
        if(userImage==null || userImage.length()==0){
            modelMap.addAttribute("userImage", "logo1.png");
        }
        else{modelMap.addAttribute("userImage", user.getImage()); }
        modelMap.addAttribute("login",user.getLogin());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        modelMap.addAttribute("dateOfPubl", simpleDateFormat.format(prop.getDateOfPublication()));
        modelMap.addAttribute("dateOfAssign", simpleDateFormat.format(prop.getDateOfAssignment()));
        modelMap.addAttribute("dateOfPrior", simpleDateFormat.format(prop.getDateOfPriority()));
        modelMap.addAttribute("dateOfExp", simpleDateFormat.format(prop.getDateOfExpiration()));

        modelMap.addAttribute("prop", prop);

        return "intPropChangePage";
    }

    @PostMapping("/changeProp/{prop}")
    public String change(Authentication authentication, ModelMap modelMap, @PathVariable IntellectualProperty prop, IntellectualPropertyForm intellectualPropertyForm) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");

        Date dateOfAssignment = simpleDateFormat.parse(intellectualPropertyForm.getDateOfAssignment());
        Date dateOfExpiration = simpleDateFormat.parse(intellectualPropertyForm.getDateOfExpiration());
        Date dateOfPriority = simpleDateFormat.parse(intellectualPropertyForm.getDateOfPriority());
        Date dateOfPublication = simpleDateFormat.parse(intellectualPropertyForm.getDateOfPublication());

        prop.setName(intellectualPropertyForm.getName());
        prop.setTypeOfDocument(intellectualPropertyForm.getTypeOfDocument());
        prop.setObject(intellectualPropertyForm.getObject());
        prop.setRegistrationNumber(intellectualPropertyForm.getRegistrationNumber());
        prop.setNumberOfRequest(intellectualPropertyForm.getNumberOfRequest());
        prop.setOwner(intellectualPropertyForm.getOwner());
        prop.setDateOfPublication(dateOfPublication);
        prop.setDateOfPublicationShow(simpleDateFormatForShow.format(dateOfPublication));
        prop.setDateOfAssignment(dateOfAssignment);
        prop.setDateOfAssignmentShow(simpleDateFormatForShow.format(dateOfAssignment));
        prop.setDateOfPriority(dateOfPriority);
        prop.setDateOfPriorityShow(simpleDateFormatForShow.format(dateOfPriority));
        prop.setDateOfExpiration(dateOfExpiration);
        prop.setDateOfExpirationShow(simpleDateFormatForShow.format(dateOfExpiration));

        intellectualPropertyRepository.save(prop);

        return "redirect:/progPage/"+prop.getId();
    }


}
