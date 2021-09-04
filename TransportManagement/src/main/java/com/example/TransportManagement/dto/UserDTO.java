package com.example.TransportManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserDTO {

    private int id;

    private String name;

    private String password;

    private int isActive;

    private int isDelete;

}
