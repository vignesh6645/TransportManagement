package com.example.TransportManagement.serviece;

import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.LoadDTO;
import com.example.TransportManagement.dto.UserDTO;
import com.example.TransportManagement.dto.VehicleDTO;
import com.example.TransportManagement.dto.VehicleTypeDTO;
import com.example.TransportManagement.entity.Load;
import com.example.TransportManagement.entity.User;
import com.example.TransportManagement.entity.Vehicle;
import com.example.TransportManagement.entity.VehicleType;
import com.example.TransportManagement.repository.LoadRepository;
import com.example.TransportManagement.repository.UserRepository;
import com.example.TransportManagement.repository.VehicleRespository;
import com.example.TransportManagement.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiece {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRespository vehicleRespository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private LoadRepository loadRepository;

    public BaseResponse add(UserDTO userDTO){

        User user = new User();
        BaseResponse  baseResponse = new BaseResponse();

        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setIsActive(userDTO.getIsActive());
        user.setIsDelete(userDTO.getIsDelete());

        userRepository.save(user);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(user);

        return baseResponse;
    }

    public User getUserById(Integer id){

        return userRepository.findById(id).orElse(null);
    }

    public BaseResponse deleteById(Integer id){

        BaseResponse baseResponse = new BaseResponse();

        userRepository.deleteById(id);
        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public BaseResponse updateUserDetail(UserDTO userDTO){

        BaseResponse baseResponse = new BaseResponse();

        Optional<User>existUser = userRepository.findById(userDTO.getId());
        existUser.get().setId(userDTO.getId());
        existUser.get().setName(userDTO.getName());
        existUser.get().setPassword(userDTO.getPassword());
        existUser.get().setIsActive(userDTO.getIsActive());
        existUser.get().setIsDelete(userDTO.getIsDelete());

        userRepository.save(existUser.get());

        baseResponse.setData(existUser);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public Page<User> findUserWithPagination(int offset,int pageSize){
        Page<User> user = userRepository.findAll(PageRequest.of(offset, pageSize));
        return  user;
    }
    //serviece for vehicle

    public BaseResponse addVehicle(VehicleDTO vehicleDTO){

        Vehicle vehicle = new Vehicle();
        BaseResponse  baseResponse = new BaseResponse();

        vehicle.setVehicle_name(vehicleDTO.getVehicle_name());
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        vehicle.setIsActive(vehicleDTO.getIsActive());
        vehicle.setIsDelete(vehicleDTO.getIsDelete());

        vehicleRespository.save(vehicle);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(vehicle);

        return baseResponse;
    }

    public BaseResponse updateUserDetailForVehicle(VehicleDTO vehicleDTO){

        BaseResponse baseResponse = new BaseResponse();

        Optional<Vehicle>existVehicle = vehicleRespository.findById(vehicleDTO.getVehicle_id());
        existVehicle.get().setVehicle_id(vehicleDTO.getVehicle_id());
        existVehicle.get().setVehicle_name(vehicleDTO.getVehicle_name());
        existVehicle.get().setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        existVehicle.get().setIsActive(vehicleDTO.getIsActive());
        existVehicle.get().setIsDelete(vehicleDTO.getIsDelete());

        vehicleRespository.save(existVehicle.get());

        baseResponse.setData(existVehicle);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public Page<Vehicle> findVehicleWithPagination(int offset,int pageSize){
        Page<Vehicle> vehicle = vehicleRespository.findAll(PageRequest.of(offset, pageSize));
        return vehicle;
    }


    public BaseResponse deleteVehicleById(Integer vehicle_id){

        BaseResponse baseResponse = new BaseResponse();

        vehicleRespository.deleteById(vehicle_id);
        baseResponse.setData(vehicle_id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public User findVehicleById(Integer vehicle_id){

        return userRepository.findById(vehicle_id).orElse(null);
    }

   // serviece for vehicleType

    public BaseResponse addVehicleType(VehicleTypeDTO vehicleTypeDTO){

        VehicleType vehicleType = new VehicleType();
        BaseResponse  baseResponse = new BaseResponse();

        vehicleType.setVehicleName(vehicleTypeDTO.getVehicleName());
        vehicleType.setIsActive(vehicleTypeDTO.getIsActive());
        vehicleType.setIsDelete(vehicleTypeDTO.getIsDelete());

        vehicleTypeRepository.save(vehicleType);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(vehicleType);

        return baseResponse;
    }

    public BaseResponse updateVehicleTypeForVehicle(VehicleTypeDTO vehicleTypeDTO){

        BaseResponse baseResponse = new BaseResponse();

        Optional<VehicleType>existVehicleType = vehicleTypeRepository.findById(vehicleTypeDTO.getVehicle_type_id());
        existVehicleType.get().setVehicle_type_id(vehicleTypeDTO.getVehicle_type_id());
        existVehicleType.get().setVehicleName(vehicleTypeDTO.getVehicleName());
        existVehicleType.get().setIsActive(vehicleTypeDTO.getIsActive());
        existVehicleType.get().setIsDelete(vehicleTypeDTO.getIsDelete());

        vehicleTypeRepository.save(existVehicleType.get());

        baseResponse.setData(existVehicleType);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public List<VehicleType> listAll(){

        return vehicleTypeRepository.findAll();
    }

    //serviece for loads

    public BaseResponse addLoad(LoadDTO loadDTO){

        Load load = new Load();
        BaseResponse  baseResponse = new BaseResponse();

        load.setLoadName(loadDTO.getLoadName());
        load.setDestination(loadDTO.getDestination());
        load.setIsActive(loadDTO.getIsActive());
        load.setIsDelete(loadDTO.getIsDelete());

        loadRepository.save(load);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(load);

        return baseResponse;
    }

    public BaseResponse update(LoadDTO loadDTO){

        BaseResponse baseResponse = new BaseResponse();

        Optional<Load> existLoad = loadRepository.findById(loadDTO.getLoad_id());
        existLoad.get().setLoad_id(loadDTO.getLoad_id());
        existLoad.get().setLoadName(loadDTO.getLoadName());
        existLoad.get().setDestination(loadDTO.getDestination());
        existLoad.get().setIsActive(loadDTO.getIsActive());
        existLoad.get().setIsDelete(loadDTO.getIsDelete());

        loadRepository.save(existLoad.get());

        baseResponse.setData(existLoad);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }
    public List<Load> listAll1(){

        return loadRepository.findAll();
    }

}
