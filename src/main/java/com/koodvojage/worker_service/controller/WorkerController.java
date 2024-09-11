package com.koodvojage.worker_service.controller;

import com.koodvojage.worker_service.model.Worker;
import com.koodvojage.worker_service.model.WorkerRole;
import com.koodvojage.worker_service.service.WorkerRoleService;
import com.koodvojage.worker_service.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/workers")
public class WorkerController {

    private final WorkerService workerService;
    private final WorkerRoleService roleService;

    @Autowired
    public WorkerController(WorkerService workerService, WorkerRoleService roleService) {
        this.workerService = workerService;
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        String roleName = worker.getRole().getRoleName();
        WorkerRole role = roleService.findByRoleName(roleName)
                .orElseGet(() -> roleService.addRole(roleName));
        worker.setRole(role);
        Worker savedWorker = workerService.addWorker(worker);

        return new ResponseEntity<>(savedWorker, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getWorkers() {
        List<Worker> workers = workerService.getWorkers();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

}
