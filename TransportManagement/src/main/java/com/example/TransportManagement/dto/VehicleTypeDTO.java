package com.example.TransportManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class VehicleTypeDTO {

    private Integer vehicle_type_id;

    private String vehicleName;

    private Integer isActive;

    private Integer isDelete;

}
