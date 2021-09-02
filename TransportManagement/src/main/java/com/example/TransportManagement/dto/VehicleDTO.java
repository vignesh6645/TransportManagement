package com.example.TransportManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class VehicleDTO {

    private  Integer vehicle_id;

    private String vehicle_name;

    private Integer registrationNumber;

    private Integer vehicle_type_id;

    private Integer id;

    private int isActive;

    private int isDelete;
}
