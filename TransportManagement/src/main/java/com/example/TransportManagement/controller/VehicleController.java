package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;

import com.example.TransportManagement.baseresponse.BaseResponseRep;

import com.example.TransportManagement.dto.VehicleDTO;
import com.example.TransportManagement.entity.Vehicle;
import com.example.TransportManagement.servieceImplements.VehicleServieceImplements;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {

   @Autowired
    private VehicleServieceImplements vehicleServiece;

  @PostMapping("/create")
  @Authorization(value = "Bearer")
  public BaseResponseRep <Optional<Vehicle>>addvehicle(@RequestBody VehicleDTO vehicleDTO){
      BaseResponseRep base;
      base= BaseResponseRep.builder().Data(vehicleServiece.addvehicle(vehicleDTO)).build();
      return base;
  }
    @PutMapping("/update")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<Vehicle>> updatedetail(@RequestBody VehicleDTO vehicleDTO){
        BaseResponseRep<Optional<Vehicle>> base ;
        base = BaseResponseRep.<Optional<Vehicle>>builder().Data(vehicleServiece.updatevehicle(vehicleDTO)).build();
        return base;
    }


    @GetMapping("/page/{offset}/{pageSize}/{vehicleName}")
    @Authorization(value = "Bearer")
    private APIResponse<Vehicle> vehiclePagination
            (@PathVariable int offset, @PathVariable int pageSize, @PathVariable String vehicleName){
        return vehicleServiece.vehiclePagination(offset, pageSize, vehicleName);
    }

    @GetMapping("/vehicleId/{id}")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<Vehicle>>findByVehicleId(@PathVariable int id){
      BaseResponseRep<Optional<Vehicle>> base;
      base = BaseResponseRep.<Optional<Vehicle>>builder().Data(vehicleServiece.findvehicleById(id)).build();
      return base;
    }


    @PutMapping("/delete")
    @Authorization(value = "Bearer")
    public BaseResponseRep deleteLoad(@RequestBody VehicleDTO vehicleDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(vehicleServiece.deletevehicle(vehicleDTO)).build();
        return base;
    }

}
