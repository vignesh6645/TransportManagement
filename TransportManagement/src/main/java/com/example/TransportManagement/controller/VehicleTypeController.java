package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.baseresponse.BaseResponseRep;
import com.example.TransportManagement.dto.VehicleDTO;
import com.example.TransportManagement.dto.VehicleTypeDTO;
import com.example.TransportManagement.entity.Load;
import com.example.TransportManagement.entity.VehicleType;
import com.example.TransportManagement.servieceImplements.VehicleTypeServieceImplements;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/vehicleType")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeServieceImplements vehicleTypeServiece;

    @PostMapping("/create")
    @Authorization(value = "Bearer")
    public BaseResponseRep addvehicle(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        BaseResponseRep base;
        base= BaseResponseRep.builder().Data(vehicleTypeServiece.addvehicleType(vehicleTypeDTO)).build();
        return base;
    }
    @PutMapping("/update")
    @Authorization(value = "Bearer")
    public BaseResponseRep updatedetail(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(vehicleTypeServiece.updatevehicleType(vehicleTypeDTO)).build();
        return base;
    }

    @PutMapping("/delete")
    @Authorization(value = "Bearer")
    public BaseResponseRep deletedetail(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(vehicleTypeServiece.deletevehicleType(vehicleTypeDTO)).build();
        return base;
    }
    @GetMapping("/getAll")
    @Authorization(value = "Bearer")
        public BaseResponseRep<List<VehicleType>>listAll(){
            BaseResponseRep<List<VehicleType>> base;
            base = BaseResponseRep.<List<VehicleType>> builder().Data(vehicleTypeServiece.listAll()).build();
            return base;
    }

}
