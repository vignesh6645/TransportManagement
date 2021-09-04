package com.example.TransportManagement.entity;

import lombok.*;
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

@Getter
@Setter

@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private int id;

    @Column(name = "vehicle_name",nullable = false)
    private String vehicle_name;

    @Column(name = "registration_number")
    private Integer registrationNumber;

    @Column(name = "is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name = "is_delete",columnDefinition = "integer default 0")
    private int isDelete;



    @Column(name = "created_at")
    private Timestamp createDateTime;



    @Column(name = "modified_at")
    private Timestamp updateDateTime;

    @OneToOne
    @JoinColumn(name = "fk_vehicle_type_id")
    private VehicleType vehicle_type_id;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;


}
