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

@Entity
@Table(name = "vehicleType")
@Data
@NoArgsConstructor
@Transactional
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_type_id")
    private Integer vehicle_type_id;

    @Column(name = "vehicleName")
    private String vehicleName;

    @Column(name = "is_active",columnDefinition = "integer default 0")
    private Integer isActive;

    @Column(name = "is_delete",columnDefinition = "integer default 0")
    private Integer isDelete;


    @CreationTimestamp
    @Column(name = "created_at")
    private Time createDateTime;


    @UpdateTimestamp
    @Column(name = "modified_at")
    private Time updateDateTime;
}