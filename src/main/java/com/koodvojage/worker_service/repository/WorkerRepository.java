package com.koodvojage.worker_service.repository;

import com.koodvojage.worker_service.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, String> {
}
