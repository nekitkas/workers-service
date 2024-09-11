package com.koodvojage.worker_service.controller;

import com.koodvojage.worker_service.model.WorkerRole;
import com.koodvojage.worker_service.service.WorkerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/roles")
public class WorkerRoleController {

    private final WorkerRoleService workerRoleService;

    @Autowired
    public WorkerRoleController(WorkerRoleService workerRoleService) {
        this.workerRoleService = workerRoleService;
    }

    @GetMapping
    public List<WorkerRole> getRoles() {
        return workerRoleService.getRoles();
    }

    @GetMapping(params = "roleName")
    public Optional<WorkerRole> getRoleByName(@RequestParam String roleName) {
        return workerRoleService.findByRoleName(roleName);
    }

    @PostMapping
    public void addRole(@RequestBody String roleName) {
        workerRoleService.addRole(roleName);
    }
}
