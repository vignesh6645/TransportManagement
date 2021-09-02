package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.VehicleDTO;
import com.example.TransportManagement.entity.User;
import com.example.TransportManagement.entity.Vehicle;
import com.example.TransportManagement.serviece.UserServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {
    @Autowired
    UserServiece userServiece;

    @PostMapping("/create")
    public BaseResponse add(@RequestBody VehicleDTO vehicleDTO){

        return userServiece.addVehicle(vehicleDTO);
    }

    @PutMapping("/update")
    public BaseResponse update(@RequestBody VehicleDTO vehicleDTO){
        return userServiece.updateUserDetailForVehicle(vehicleDTO);
    }

    @GetMapping("/vehicleid/{id}")
    public User findvehicleById(@PathVariable int id){
        return userServiece.findVehicleById(id);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Vehicle>> findVehicleWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Vehicle> Pagination = userServiece.findVehicleWithPagination(offset, pageSize);
        return new APIResponse<>(Pagination.getSize(),Pagination);
    }


}
