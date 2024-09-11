package com.koodvojage.worker_service.service;

import com.koodvojage.worker_service.model.Worker;
import com.koodvojage.worker_service.model.WorkerRole;
import com.koodvojage.worker_service.repository.WorkerRepository;
import com.koodvojage.worker_service.repository.WorkerRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerRoleRepository workerRoleRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository, WorkerRoleRepository workerRoleRepository){
        this.workerRepository = workerRepository;
        this.workerRoleRepository = workerRoleRepository;
    }

    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }
}
