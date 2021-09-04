package com.example.TransportManagement.serviece;


import com.example.TransportManagement.baseresponse.APIResponse;
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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
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

    //serviece for user..

    public BaseResponse addUser(UserDTO userDTO){
        User user = new User();

        BaseResponse baseResponse = new BaseResponse();

        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setIsActive(userDTO.getIsActive());
        user.setIsDelete(userDTO.getIsDelete());
        user.setCreateDateTime(new Timestamp(new java.util.Date().getTime()));
        user.setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        userRepository.save(user);

        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(user);

        return baseResponse;
    }
    public User getUserById(Integer id){

        return userRepository.findById(id).orElse(null);
    }
    public BaseResponse updateUser(UserDTO userDTO){

        BaseResponse baseResponse = new BaseResponse();

        Optional<User> existUser = userRepository.findById(userDTO.getId());
        existUser.get().setId(userDTO.getId());
        existUser.get().setName(userDTO.getName());
        existUser.get().setPassword(userDTO.getPassword());
        existUser.get().setIsActive(userDTO.getIsActive());
        existUser.get().setIsDelete(userDTO.getIsDelete());

        userRepository.save(existUser.get());

        baseResponse.setData(existUser);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

     public APIResponse<User> userPagination(int offset,int pageSize,String name){
        Pageable paging = PageRequest.of(offset,pageSize);
        Page<User>users = userRepository.searchAllByNameLike("%" + name + "%",paging);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setResponse(users);
        apiResponse.setRecordCount(users.getTotalPages());

        return apiResponse;
    }
    public BaseResponse deleteUser(UserDTO userDTO){
        User user = new User();
        Optional<User> existUser=userRepository.findById(userDTO.getId());
        existUser.get().setIsDelete(1);
        existUser.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        userRepository.save(existUser.get());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(existUser);

        return baseResponse;

    }
    //serviece for vehicle type..

    public BaseResponse addVehicleType(VehicleTypeDTO vehicleTypeDTO){

        VehicleType vehicleType = new VehicleType();
        BaseResponse  baseResponse = new BaseResponse();

        vehicleType.setVehicleName(vehicleTypeDTO.getVehicleName());
        vehicleType.setIsActive(vehicleTypeDTO.getIsActive());
        vehicleType.setIsDelete(vehicleTypeDTO.getIsDelete());
        vehicleType.setCreateDateTime(new Timestamp(new java.util.Date().getTime()));
        vehicleType.setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        vehicleTypeRepository.save(vehicleType);

        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(vehicleType);

        return baseResponse;
    }

    public BaseResponse updateVehicleType(VehicleTypeDTO vehicleTypeDTO){

        BaseResponse baseResponse = new BaseResponse();

        Optional<VehicleType>existVehicleType = vehicleTypeRepository.findById(vehicleTypeDTO.getVehicle_type_id());
        existVehicleType.get().setId(vehicleTypeDTO.getVehicle_type_id());
        existVehicleType.get().setVehicleName(vehicleTypeDTO.getVehicleName());
        existVehicleType.get().setIsActive(vehicleTypeDTO.getIsActive());
        existVehicleType.get().setIsDelete(vehicleTypeDTO.getIsDelete());

        vehicleTypeRepository.save(existVehicleType.get());

        baseResponse.setData(existVehicleType);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public List<VehicleType> listAll(){

        return vehicleTypeRepository.findAll();
    }
    public BaseResponse deleteVehicleType(VehicleTypeDTO vehicleTypeDTO){
        BaseResponse baseResponse = new BaseResponse();
        Optional<VehicleType> existVehicleType=vehicleTypeRepository.findById(vehicleTypeDTO.getVehicle_type_id());
        existVehicleType.get().setIsDelete(1);
        existVehicleType.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        vehicleTypeRepository.save(existVehicleType.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(existVehicleType);

        return baseResponse;
    }

    //serviece for load

    public BaseResponse addLoad(LoadDTO loadDTO){

        Load load = new Load();
        BaseResponse  baseResponse = new BaseResponse();

        load.setLoadName(loadDTO.getLoadName());
        load.setDestination(loadDTO.getDestination());


        loadDTO.getVehicleId().stream().forEachOrdered(vehicleDTO -> {
            Optional<Vehicle> vehicle=vehicleRespository.findById(vehicleDTO.getVehicle_id());
            load.setVehicle(vehicle.get());
        });
        load.setIsActive(loadDTO.getIsActive());
        load.setIsDelete(loadDTO.getIsDelete());
        load.setCreateDateTime(new Timestamp(new Date().getTime()));
        load.setUpdateDateTime(new Timestamp(new Date().getTime()));

        loadRepository.save(load);

        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(load);

        return baseResponse;
    }

    public BaseResponse updateLoad(LoadDTO loadDTO){

        BaseResponse baseResponse = new BaseResponse();

        Optional<Load> existLoad = loadRepository.findById(loadDTO.getLoad_id());
        existLoad.get().setLoad_id(loadDTO.getLoad_id());
        existLoad.get().setLoadName(loadDTO.getLoadName());
        existLoad.get().setDestination(loadDTO.getDestination());

        loadDTO.getVehicleId().stream().forEachOrdered(vehicleDTO -> {
            Optional<Vehicle> vehicle = vehicleRespository.findById(vehicleDTO.getVehicle_id());
            existLoad.get().setVehicle(vehicle.get());
        });
        existLoad.get().setIsActive(loadDTO.getIsActive());
        existLoad.get().setIsDelete(loadDTO.getIsDelete());

        loadRepository.save(existLoad.get());

        baseResponse.setData(existLoad);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }
    public List<Load> listAll1(){

        return loadRepository.findAll();
    }

    public BaseResponse deleteLoad(LoadDTO loadDTO){
        BaseResponse baseResponse = new BaseResponse();
        Optional<Load> existLoad = loadRepository.findById(loadDTO.getLoad_id());
        existLoad.get().setIsDelete(1);
        existLoad.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        loadRepository.save(existLoad.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(existLoad);

        return baseResponse;
    }
    //serviece for vehicle

   public BaseResponse addVehicle(VehicleDTO vehicleDTO){

        Vehicle vehicle = new Vehicle();
        BaseResponse  baseResponse = new BaseResponse();
        vehicle.setVehicle_name(vehicleDTO.getVehicle_name());
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());

        Optional<VehicleType> vehicleType=vehicleTypeRepository.
                findById(vehicleDTO.getVehicle_type_id());
        vehicle.setVehicle_type_id(vehicleType.get());

        Vehicle vehicle1 = vehicle;
        Vehicle finalVehicle = vehicle;
        vehicleDTO.getUserId().stream().forEachOrdered(userDTO -> {
                    Optional<User> user = userRepository.findById(userDTO.getId());
                     finalVehicle.setUser(user.get());
                });
        vehicle.setIsActive(vehicleDTO.getIsActive());
        vehicle.setIsDelete(vehicleDTO.getIsDelete());
        vehicle.setCreateDateTime(new Timestamp(new java.util.Date().getTime()));
        vehicle.setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));

        vehicleRespository.save(vehicle);

        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(vehicle);

        return baseResponse;
    }

    public  BaseResponse updateVehicle(VehicleDTO vehicleDTO){
        Optional<Vehicle> existVehicle = vehicleRespository.findById(vehicleDTO.getVehicle_id());
        existVehicle.get().setVehicle_name(vehicleDTO.getVehicle_name());
        existVehicle.get().setRegistrationNumber(vehicleDTO.getRegistrationNumber());

        Optional<VehicleType> vehicleType=vehicleTypeRepository.findById(vehicleDTO
                .getVehicle_type_id());
        existVehicle.get().setVehicle_type_id(vehicleType.get());

        vehicleDTO.getUserId().stream().forEachOrdered(userDTO -> {
            Optional<User> user = userRepository.findById(userDTO.getId());
            existVehicle.get().setUser(user.get());
        });
        existVehicle.get().setIsActive(vehicleDTO.getIsActive());
        existVehicle.get().setIsDelete(vehicleDTO.getIsDelete());
        existVehicle.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        vehicleRespository.save(existVehicle.get());

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(existVehicle);

        return baseResponse;
    }

    public Vehicle findVehicleById(int id){
        return vehicleRespository.findById(id).orElse(null);
    }

    public BaseResponse deleteVehicle(VehicleDTO vehicleDTO){

        BaseResponse baseResponse=new BaseResponse();
        Optional<Vehicle> existVehicle = vehicleRespository.findById(vehicleDTO.getVehicle_id());
        existVehicle.get().setIsDelete(1);
        existVehicle.get().setUpdateDateTime(new Timestamp(new  java.util.Date().getTime()));
        vehicleRespository.save(existVehicle.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(existVehicle);

        return baseResponse;
    }
    public APIResponse<Vehicle>vehiclePagination(int offset,int pageSize,String vehicle_name){
        Pageable paging=PageRequest.of(offset,pageSize);
        Page<Vehicle> vehicles=vehicleRespository.searchAllByregistrationNumberLike
                ("%"+ vehicle_name + "%",paging);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setResponse(vehicles);
        apiResponse.setRecordCount(vehicles.getTotalPages());
        return apiResponse;
    }

}