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
import ru.knitu.model.*;
import ru.knitu.repo.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class WorkerPageController {
    @Autowired
    WorkerRepository workerRepository;
    @Value("${upload.path}")
    String uploadPath;
    @Autowired
    CandidateWorkRepository candidateWorkRepository;
    @Autowired
    IncreaseQualificationRelateRepository increaseQualificationRelateRepository;
    @Autowired
    IncreaseQualificationRepository increaseQualificationRepository;
    @Autowired
    ConferenceParticipantsRepository conferenceParticipantsRepository;
    @Autowired
    ConferenceRepository conferenceRepository;
    @Autowired
    EducationalWorkRepisitory educationalWorkRepisitory;
    @Autowired
    ScienceWorkRepository scienceWorkRepository;
    @Autowired
    IntellectualPropertyAuthorsRepository intellectualPropertyAuthorsRepository;
    @Autowired
    EduWorkAuthorsRepository eduWorkAuthorsRepository;
    @Autowired
    ScWorkAuthorsRepository scWorkAuthorsRepository;


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


        if(worker.getHighEducation()!=null){
            String highDirection = worker.getHighEducationInfo().split("#")[0];
            String highSpec =  worker.getHighEducationInfo().split("#")[1];
            String highNumber =  worker.getHighEducationInfo().split("#")[2];
            String highSeria =  worker.getHighEducationInfo().split("#")[3];
            String highYear =  worker.getHighEducationInfo().split("#")[4];
            String highOrganiation =  worker.getHighEducationInfo().split("#")[5];

            modelMap.addAttribute("high", true);
            modelMap.addAttribute("highDirection", highDirection);
            modelMap.addAttribute("highSpec", highSpec);
            modelMap.addAttribute("highNumber", highNumber);
            modelMap.addAttribute("highSeria", highSeria);
            modelMap.addAttribute("highYear", highYear);
            modelMap.addAttribute("highOrganiation", highOrganiation);

        }
        if(worker.getAvgEducation()!=null){

            String avgDirection = worker.getAvgEducationInfo().split("#")[0];
            String avgSpec =  worker.getAvgEducationInfo().split("#")[1];
            String avgNumber =  worker.getAvgEducationInfo().split("#")[2];
            String avgSeria =  worker.getAvgEducationInfo().split("#")[3];
            String avgYear =  worker.getAvgEducationInfo().split("#")[4];
            String avgOrganiation =  worker.getAvgEducationInfo().split("#")[5];

            modelMap.addAttribute("avg", true);
            modelMap.addAttribute("avgDirection", avgDirection);
            modelMap.addAttribute("avgSpec", avgSpec);
            modelMap.addAttribute("avgNumber", avgNumber);
            modelMap.addAttribute("avgSeria", avgSeria);
            modelMap.addAttribute("avgYear", avgYear);
            modelMap.addAttribute("avgOrganiation", avgOrganiation);

        }
        if(worker.getBegEducation()!=null){

            String begDirection = worker.getBegEducationInfo().split("#")[0];
            String begSpec =  worker.getBegEducationInfo().split("#")[1];
            String begNumber =  worker.getBegEducationInfo().split("#")[2];
            String begSeria =  worker.getBegEducationInfo().split("#")[3];
            String begYear =  worker.getBegEducationInfo().split("#")[4];
            String begOrganiation =  worker.getBegEducationInfo().split("#")[5];

            modelMap.addAttribute("beg", true);
            modelMap.addAttribute("begDirection", begDirection);
            modelMap.addAttribute("begSpec", begSpec);
            modelMap.addAttribute("begNumber", begNumber);
            modelMap.addAttribute("begSeria", begSeria);
            modelMap.addAttribute("begYear", begYear);
            modelMap.addAttribute("begOrganiation", begOrganiation);

        }

        List <ConferenceParticipants> conferenceParticipantsList = conferenceParticipantsRepository.findAllByWorker(worker);
        if(!conferenceParticipantsList.isEmpty()){

            List <Conference> conferenceList = new ArrayList<>();
            for(ConferenceParticipants conferenceParticipants :  conferenceParticipantsList){
                conferenceList.add(conferenceRepository.findById(conferenceParticipants.getConference_id()));
            }

            modelMap.addAttribute("conference", true);
            modelMap.addAttribute("conferenceList", conferenceList);

        }

        List <CandidateWork> candidateWorkList = candidateWorkRepository.findAllByWorker(worker);
        if(!candidateWorkList.isEmpty()){

            modelMap.addAttribute("candidateWork", true);
            modelMap.addAttribute("candidateWorkList", candidateWorkList);

        }

        List <IncreaseQualificationRelate> increaseQualificationRelateList =  increaseQualificationRelateRepository.findAllByWorker(worker);
        if(!increaseQualificationRelateList.isEmpty()){
            List <IncreaseQualification> increaseQualificationList = new ArrayList<>();

            for(IncreaseQualificationRelate increaseQualificationRelate : increaseQualificationRelateList){
                increaseQualificationList.add(increaseQualificationRelate.getQualification());
            }

            modelMap.addAttribute("qualification", true);
            modelMap.addAttribute("increaseQualificationList", increaseQualificationList);
        }

        List<EducationalWork> educationalWorkList = new ArrayList<>();

        for(EducationalWorkAuthors educationalWorkAuthors : eduWorkAuthorsRepository.findAllByWorker(worker)){
            educationalWorkList.add(educationalWorkAuthors.getEducationalWork());
        }

        if(!educationalWorkList.isEmpty()){
            modelMap.addAttribute("educational", true);
            modelMap.addAttribute("educationalWorkList", educationalWorkList);
        }

        List<ScienceWork> scienceWorkList  = new ArrayList<>();

        for(ScienceWorkAuthors scienceWorkAuthors : scWorkAuthorsRepository.findAllByWorker(worker)){
            scienceWorkList.add(scienceWorkAuthors.getScienceWork());
        }

        if(!scienceWorkList.isEmpty()){
            modelMap.addAttribute("science", true);
            modelMap.addAttribute("scienceWorkList", scienceWorkList);
        }


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

        deleteAllWorks(worker);
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

        String seria = worker.getPasport().split(" ")[0];
        String number = worker.getPasport().split(" ")[1];
        String issuing = worker.getPasport().split(" ")[2];
        String code = worker.getPasport().split(" ")[3];

        modelMap.addAttribute("seria", seria);
        modelMap.addAttribute("number", number);
        modelMap.addAttribute("issuing", issuing);
        modelMap.addAttribute("code", code);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        modelMap.addAttribute("dateOfBirth", simpleDateFormat.format(worker.getDateOfBirth()));
        modelMap.addAttribute("dateOfBeginWork", simpleDateFormat.format(worker.getDateOfBeginWork()));
        modelMap.addAttribute("dateOfPedBeginWork", simpleDateFormat.format(worker.getDateOfPedBeginWork()));
        modelMap.addAttribute("dateEndOfContract", simpleDateFormat.format(worker.getDateEndOfContract()));



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
        String email = (workerForm.getEmail().equals(worker.getEmail()) ? worker.getEmail() :workerForm.getEmail());
        String rate = (workerForm.getRate().equals(worker.getRate()) ? worker.getRate() :workerForm.getRate());
        String hiringConditional = (workerForm.getHiringConditionOfWorker().equals(worker.getHiringConditionOfWorker()) ? worker.getHiringConditionOfWorker() :workerForm.getHiringConditionOfWorker());
        String addressOfRegistration = (workerForm.getAddressRegistration().equals(worker.getAddressRegistration()) ? worker.getAddressRegistration() :workerForm.getAddressRegistration());
        String addressOfPlaceResidence = (workerForm.getAddressPlaceOfResidence().equals(worker.getAddressPlaceOfResidence()) ? worker.getAddressPlaceOfResidence() :workerForm.getAddressPlaceOfResidence());
        String seria = workerForm.getPasport();
        String number = workerForm.getPasport1();
        String issuing = workerForm.getPasport2();
        String code = workerForm.getPasport3();
        String pasport = seria + " " + number + " " + issuing + " " + code;

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
        Date dateOfPedBegin = null;
        String dateOfPedBeginShow = null;
        if(workerForm.getDateOfPedBeginWork()==null || workerForm.getDateOfPedBeginWork().length()==0){
            dateOfPedBegin=worker.getDateOfPedBeginWork();
            dateOfPedBeginShow = worker.getDateOfPedBeginWorkShow();
        }else{
            dateOfPedBegin = simpleDateFormat.parse(workerForm.getDateOfPedBeginWork());
            dateOfPedBeginShow = simpleDateFormatForShow.format(dateOfPedBegin);
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
        worker.setDateOfPedBeginWork(dateOfPedBegin);
        worker.setDateOfPedBeginWorkShow(dateOfPedBeginShow);
        worker.setEmail(email);
        worker.setRate(rate);
        worker.setHiringConditionOfWorker(hiringConditional);
        worker.setAddressPlaceOfResidence(addressOfPlaceResidence);
        worker.setAddressRegistration(addressOfRegistration);
        worker.setPasport(pasport);


        workerRepository.save(worker);
        return "redirect:/getWorkerPage/"+worker.getId();
    }

    private void deleteAllWorks(Worker worker) {
        // Delete Candidate work
        for(CandidateWork candidateWork : candidateWorkRepository.findAllByWorker(worker)){
            candidateWorkRepository.delete(candidateWork);
        }
        // Delete IncreaseQualificationRelate work
        for(IncreaseQualificationRelate increaseQualificationRelate : increaseQualificationRelateRepository.findAllByWorker(worker)){
            increaseQualificationRelateRepository.delete(increaseQualificationRelate);
        }
        // Delete ConferenceParticipants
        for(ConferenceParticipants conferenceParticipants : conferenceParticipantsRepository.findAllByWorker(worker)){
            conferenceParticipantsRepository.delete(conferenceParticipants);
        }
        // Delete Educational work
        for(EducationalWorkAuthors educationalWorkAuthors : eduWorkAuthorsRepository.findAllByWorker(worker)){
            eduWorkAuthorsRepository.delete(educationalWorkAuthors);
        }
        // Delete Science work
        for(ScienceWorkAuthors scienceWorkAuthors : scWorkAuthorsRepository.findAllByWorker(worker)){
            scWorkAuthorsRepository.delete(scienceWorkAuthors);
        }
        // Delete IntellectualPropertyAuthors
        for(IntellectualPropertyAuthors intellectualPropertyAuthors : intellectualPropertyAuthorsRepository.findAllByWorker(worker)){
            intellectualPropertyAuthorsRepository.delete(intellectualPropertyAuthors);
        }
    }

}
