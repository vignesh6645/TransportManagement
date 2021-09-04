package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.VehicleDTO;
import com.example.TransportManagement.entity.Vehicle;
import com.example.TransportManagement.serviece.UserServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {
   @Autowired
    private UserServiece userServiece;

  @PostMapping("/create")
    public BaseResponse adddetail(@Valid @RequestBody VehicleDTO vehicleDTO){
       return  userServiece.addVehicle(vehicleDTO);
   }

   @PutMapping("/update")
   public BaseResponse updateVehicle(@RequestBody VehicleDTO vehicleDTO){
      return userServiece.updateVehicle(vehicleDTO);
   }

    @GetMapping("/pagination/{offset}/{pageSize}/{vehicle_name}")
    private APIResponse<Vehicle> vehiclePagination
            (@PathVariable int offset, @PathVariable int pageSize, @PathVariable String vehicle_name){
        return userServiece.vehiclePagination(offset, pageSize,vehicle_name);
    }

    @GetMapping("/vehicleId/{id}")
    public Vehicle findByVehicleId(@PathVariable int id){
      return userServiece.findVehicleById(id);
    }

    @PutMapping("/delete")
    public BaseResponse deleteVehicle(@RequestBody VehicleDTO vehicleDTO){
      return userServiece.deleteVehicle(vehicleDTO);
    }

}
