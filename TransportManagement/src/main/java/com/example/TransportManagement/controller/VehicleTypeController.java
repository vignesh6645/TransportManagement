package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.LoadDTO;
import com.example.TransportManagement.dto.VehicleTypeDTO;
import com.example.TransportManagement.entity.Load;
import com.example.TransportManagement.entity.VehicleType;
import com.example.TransportManagement.serviece.UserServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/vehicleType")
public class VehicleTypeController {

    @Autowired
    private UserServiece userServiece;
    @PostMapping("/create")
    public BaseResponse add(@RequestBody VehicleTypeDTO vehicleTypeDTO){

        return userServiece.addVehicleType(vehicleTypeDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        return userServiece.updateVehicleType(vehicleTypeDTO);
    }
    @PutMapping("/delete")
    public BaseResponse deleteVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        return userServiece.deleteVehicleType(vehicleTypeDTO);
    }
    @GetMapping("/getAll")
    public List<VehicleType> listAll(){
        return userServiece.listAll();
    }

}
