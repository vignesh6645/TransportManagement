package com.example.TransportManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;
import java.util.List;


@Getter
@Setter

public class LoadDTO {

    private Integer load_id;

    private String loadName;

    private String destination;

    private int isActive;

    private int isDelete;

    private List<VehicleDTO> vehicleId;

}
