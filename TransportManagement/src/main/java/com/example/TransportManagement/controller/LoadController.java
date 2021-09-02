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

@RequestMapping("/loads")
@RestController
public class LoadController {

    @Autowired
    private UserServiece userServiece;

    @PostMapping("/create")
    public BaseResponse add(@RequestBody LoadDTO loadDTO){

        return userServiece.addLoad(loadDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateDetail(@RequestBody LoadDTO loadDTO){
        return userServiece.update(loadDTO);
    }

    @GetMapping("/getAll")
    public List<Load> list(){
        return userServiece.listAll1();
    }
}
