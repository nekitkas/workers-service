package com.koodvojage.worker_service.service;

import com.koodvojage.worker_service.model.WorkerRole;
import com.koodvojage.worker_service.repository.WorkerRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerRoleService {
    private final WorkerRoleRepository workerRoleRepository;

    @Autowired
    public WorkerRoleService(WorkerRoleRepository workerRoleRepository) {
        this.workerRoleRepository = workerRoleRepository;
    }

    public WorkerRole addRole(String roleName) {
        WorkerRole workerRole = new WorkerRole();
        workerRole.setRoleName(roleName);
        return workerRoleRepository.save(workerRole);
    }

    public List<WorkerRole> getRoles() {
        return workerRoleRepository.findAll();
    }

    public Optional<WorkerRole> findById(String id) {
        return workerRoleRepository.findById(id);
    }

    public Optional<WorkerRole> findByRoleName(String roleName) {
        return workerRoleRepository.findByRoleName(roleName);
    }

}
