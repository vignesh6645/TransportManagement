package com.example.TransportManagement.controller;


import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.LoadDTO;
import com.example.TransportManagement.entity.Load;
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
    public BaseResponse addDetail(@RequestBody LoadDTO loadDTO){
        return userServiece.addLoad(loadDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateLoad(@RequestBody LoadDTO loadDTO){
        return userServiece.updateLoad(loadDTO);
    }
    @PutMapping("/delete")
    public BaseResponse deleteLoad(@RequestBody LoadDTO loadDTO){
        return userServiece.deleteLoad(loadDTO);
    }
    @GetMapping("/getAll")
    public List<Load> listAll1(){
        return userServiece.listAll1();
    }

}
