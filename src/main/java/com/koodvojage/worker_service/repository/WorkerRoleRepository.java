package com.koodvojage.worker_service.repository;

import com.koodvojage.worker_service.model.WorkerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRoleRepository extends JpaRepository<WorkerRole, String> {
    Optional<WorkerRole> findByRoleName(String roleName);
}
