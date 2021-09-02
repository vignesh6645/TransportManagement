package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.UserDTO;
import com.example.TransportManagement.dto.VehicleTypeDTO;
import com.example.TransportManagement.entity.VehicleType;
import com.example.TransportManagement.serviece.UserServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vehicleType")
@RestController
public class VehicleTypeController {

    @Autowired
    private UserServiece userServiece;
    @PostMapping("/create")
    public BaseResponse add(@RequestBody VehicleTypeDTO vehicleTypeDTO){

        return userServiece.addVehicleType(vehicleTypeDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateDetail(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        return userServiece.updateVehicleTypeForVehicle(vehicleTypeDTO);
    }

    @GetMapping("/getAll")
    public List<VehicleType> list(){
        return userServiece.listAll();
    }

}
