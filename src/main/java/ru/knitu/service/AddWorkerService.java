package ru.knitu.service;


import ru.knitu.form.WorkerForm;

import java.text.ParseException;

public interface AddWorkerService {
    public void addWorker(WorkerForm workerForm,String resultFileName) throws ParseException;
}
