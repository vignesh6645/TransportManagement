package com.example.TransportManagement.serviece;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.dto.VehicleDTO;
import com.example.TransportManagement.entity.Vehicle;

import java.util.Optional;

public interface VehicleInterface {
    Vehicle addvehicle(VehicleDTO vehicleDTO);

    Optional<Vehicle> updatevehicle(VehicleDTO vehicleDTO);

    APIResponse<Vehicle> vehiclepagination(int offset, int pageSize, String vehicleName);

    Optional<Vehicle> findvehicleById(int id);

    Optional<Vehicle> deletevehicle(VehicleDTO vehicleDTO);
}
