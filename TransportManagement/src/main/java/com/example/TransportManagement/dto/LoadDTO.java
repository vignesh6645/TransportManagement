package com.example.TransportManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;

@Data
@Getter
@Setter
@Transactional
public class LoadDTO {

    private Integer load_id;

    private String loadName;

    private String destination;

    private Integer vehicle_id;

    private int isActive;

    private int isDelete;

}
