package com.example.TransportManagement.serviece;

import com.example.TransportManagement.dto.VehicleTypeDTO;
import com.example.TransportManagement.entity.VehicleType;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeInterface {
    VehicleType addvehicleType(VehicleTypeDTO vehicleTypeDTO);

    Optional<VehicleType> updatevehicleType(VehicleTypeDTO vehicleTypeDTO);

    Optional<VehicleType> deletevehicleType(VehicleTypeDTO vehicleTypeDTO);



    List<VehicleType> listAll();
}
