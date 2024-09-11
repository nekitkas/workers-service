package com.koodvojage.worker_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "workers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private WorkerRole role;

    @Column(name = "hire_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private WorkerStatus status;
}
