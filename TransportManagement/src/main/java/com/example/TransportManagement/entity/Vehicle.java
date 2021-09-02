package com.example.TransportManagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@Transactional
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Integer vehicle_id;

    @Column(name = "vehicle_name",nullable = false)
    private String vehicle_name;

    @Column(name = "registration_number")
    private Integer registrationNumber;

    @Column(name = "is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name = "is_delete",columnDefinition = "integer default 0")
    private int isDelete;


    @CreationTimestamp
    @Column(name = "created_at")
    private Time createDateTime;


    @UpdateTimestamp
    @Column(name = "modified_at")
    private Time updateDateTime;

    @OneToOne
    @JoinColumn(name = "fk_vehicle_type_id")
    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "fk_user_id",nullable = false,updatable = false)
    private User user;

    @OneToMany(mappedBy = "vehicle")
    private List<Load>loads;
}
