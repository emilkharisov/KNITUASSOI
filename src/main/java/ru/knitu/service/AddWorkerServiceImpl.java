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
                .build();
        System.out.println();
        workerRepository.save(worker);
    }
}
