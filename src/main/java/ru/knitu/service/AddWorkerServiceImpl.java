package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.WorkerForm;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.Worker;
import ru.knitu.repo.WorkerRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class AddWorkerServiceImpl implements AddWorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Override
    public void addWorker(WorkerForm workerForm,String resultFileName) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirthWorker = simpleDateFormat.parse(workerForm.getDateOfBirth());
        Date dateOfEndOfContractWorker = simpleDateFormat.parse(workerForm.getDateEndOfContract());
        Date dateOfBeginWorkWorker = simpleDateFormat.parse(workerForm.getDateOfBeginWork());
        Date dateOfPedBeginWork = simpleDateFormat.parse(workerForm.getDateOfPedBeginWork());
        String pasportInfo = workerForm.getPasport() + " " +  workerForm.getPasport1() + " " +  workerForm.getPasport2() + " " + workerForm.getPasport3();

        //Educational info
        String highDirection="";
        String highSpec="";
        String highNumber="";
        String highSeria="";
        String highYear="";
        String highOrganiation="";
        String highEducationInfo="";
        //Avg Education
        String avDirection="";
        String avSpec="";
        String avNumber="";
        String avSeria="";
        String avYear="";
        String avOrganiation="";
        String avgEducationInfo="";
        //Begin Education
        String begDirection="";
        String begSpec="";
        String begNumber="";
        String begSeria="";
        String begYear="";
        String begOrganiation="";
        String begEducationInfo="";

        Optional<Boolean> workerFormOptional = Optional.ofNullable(workerForm.getCheckHigh());
        Optional<Boolean> workerFormOptional1 = Optional.ofNullable(workerForm.getCheckAverage());
        Optional<Boolean> workerFormOptional2 = Optional.ofNullable(workerForm.getCheckBegin());

        if (workerFormOptional.isPresent()){
            highDirection = workerForm.getHighDirection();
            highSpec = workerForm.getHighSpec();
            highNumber = workerForm.getHighNumber();
            highSeria = workerForm.getHighSeria();
            highYear = workerForm.getHighYear();
            highOrganiation = workerForm.getHighOrganiation();
            highEducationInfo = highDirection + "#" + highSpec + "#" + highNumber + "#" + highSeria + "#" + highYear + "#" + highOrganiation;
        }
        if (workerFormOptional1.isPresent()){
            avDirection = workerForm.getAvDirection();
            avSpec = workerForm.getAvSpec();
            avNumber = workerForm.getAvNumber();
            avSeria = workerForm.getAvSeria();
            avYear = workerForm.getAvYear();
            avOrganiation = workerForm.getAvOrganiation();
            avgEducationInfo = avDirection + "#" + avSpec + "#" + avNumber + "#" + avSeria + "#" + avYear + "#" + avOrganiation;
        }
        if (workerFormOptional2.isPresent()){
            begDirection = workerForm.getBegDirection();
            begSpec = workerForm.getBegSpec();
            begNumber = workerForm.getBegNumber();
            begSeria = workerForm.getBegSeria();
            begYear = workerForm.getBegYear();
            begOrganiation = workerForm.getBegOrganiation();
            begEducationInfo = begDirection + "#" + begSpec + "#" + begNumber + "#" + begSeria + "#" + begYear + "#" + begOrganiation;
        }


        Worker worker = Worker.builder()
                    .firstname(workerForm.getFirstname())
                    .lastname(workerForm.getLastname())
                    .thirdname(workerForm.getThirdname())
                    .telephone(workerForm.getTelephone())
                    .education(workerForm.getEducation())
                    .position(workerForm.getPosition())
                    .academicDegree(workerForm.getAcademicDegree())
                    .academicRank(workerForm.getAcademicRank())
                    .dateEndOfContract(dateOfEndOfContractWorker)
                    .dateOfBirth(dateOfBirthWorker)
                    .dateOfBeginWork(dateOfBeginWorkWorker)
                    .dateOfPedBeginWork(dateOfPedBeginWork)
                    .checkMagistr(workerForm.getCheckMagistr())
                    .image(resultFileName)
                    .dateOfBirthShow(simpleDateFormatForShow.format(dateOfBirthWorker))
                    .dateOfBeginWorkShow(simpleDateFormatForShow.format(dateOfBeginWorkWorker))
                    .dateEndOfContractShow(simpleDateFormatForShow.format(dateOfEndOfContractWorker))
                    .dateOfPedBeginWorkShow(simpleDateFormatForShow.format(dateOfPedBeginWork))
                    .addressRegistration(workerForm.getAddressRegistration())
                    .addressPlaceOfResidence(workerForm.getAddressPlaceOfResidence())
                    .rate(workerForm.getRate())
                    .hiringTerm(workerForm.getHiringTerm())
                    .hiringConditionOfWorker(workerForm.getHiringConditionOfWorker())
                    .email(workerForm.getEmail())
                    .pasport(pasportInfo)
                    .highEducation(workerForm.getCheckHigh())
                    .highEducationInfo(highEducationInfo)
                    .avgEducation(workerForm.getCheckAverage())
                    .avgEducationInfo(avgEducationInfo)
                    .begEducation(workerForm.getCheckBegin())
                    .begEducationInfo(begEducationInfo)
                .build();
        workerRepository.save(worker);
    }
}
