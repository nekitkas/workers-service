package com.koodvojage.worker_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "worker_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkerRole {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;
}