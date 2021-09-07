package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.baseresponse.BaseResponseRep;
import com.example.TransportManagement.dto.LoadDTO;
import com.example.TransportManagement.dto.UserDTO;
import com.example.TransportManagement.dto.VehicleDTO;
import com.example.TransportManagement.entity.Vehicle;
import com.example.TransportManagement.servieceImplements.VehicleServieceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {

   @Autowired
    private VehicleServieceImplements vehicleServiece;

  @PostMapping("/create")
  public BaseResponseRep addvehicle(@RequestBody VehicleDTO vehicleDTO){
      BaseResponseRep<Object> base=null;
      base= BaseResponseRep.builder().Data(vehicleServiece.addvehicle(vehicleDTO)).build();
      return base;
  }
    @PutMapping("/update")
    public BaseResponseRep updatedetail(@RequestBody VehicleDTO vehicleDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(vehicleServiece.updatevehicle(vehicleDTO)).build();
        return base;
    }


    @GetMapping("/page/{offset}/{pageSize}/{vehicleName}")
    private APIResponse<Vehicle> vehiclePagination
            (@PathVariable int offset, @PathVariable int pageSize, @PathVariable String vehicleName){
        return vehicleServiece.vehiclepagination(offset, pageSize, vehicleName);
    }

    @GetMapping("/vehicleId/{id}")

    public BaseResponseRep<Optional<Vehicle>>findByVehicleId(@PathVariable int id){
      BaseResponseRep base;
      base = BaseResponseRep.<Optional<Vehicle>>builder().Data(vehicleServiece.findvehicleById(id)).build();
      return base;
    }


    @PutMapping("/delete")
    public BaseResponseRep deleteLoad(@RequestBody VehicleDTO vehicleDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(vehicleServiece.deletevehicle(vehicleDTO)).build();
        return base;
    }

}
