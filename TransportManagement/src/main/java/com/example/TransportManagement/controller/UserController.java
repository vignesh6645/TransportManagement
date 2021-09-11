package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.baseresponse.BaseResponseRep;
import com.example.TransportManagement.dto.TokenDTO;
import com.example.TransportManagement.dto.UserDTO;

import com.example.TransportManagement.entity.User;
import com.example.TransportManagement.servieceImplements.UserServieceImplements;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserServieceImplements userServiece;


    @PostMapping("/create")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<User>> adduser(@RequestBody UserDTO userDTO){
        BaseResponseRep base;
        base= BaseResponseRep.builder().Data(userServiece.adduser(userDTO)).build();
        return base;
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{name}")

    @Authorization(value = "Bearer")
    public APIResponse<User>userPagination( @PathVariable int offset ,@PathVariable int pageSize,@PathVariable String name){
        APIResponse base;

        base= APIResponse.<Page<User>>builder().response(userServiece.userpagination(offset,pageSize,name)).build();
        return base;
    }


    @GetMapping("/userid/{id}")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<User>>getById( @PathVariable int id){
       BaseResponseRep<Optional<User>> base;
        base =BaseResponseRep.<Optional<User>>builder().Data(userServiece.getuserById(id)).build();
        return base;
    }

    @PutMapping("/delete")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<User>> deleteuser(@RequestBody UserDTO userDTO){
        BaseResponseRep<Optional<User>> base;
        base = BaseResponseRep.<Optional<User>>builder().Data(userServiece.deleteuser(userDTO)).build();
        return base;
    }

    @PutMapping("/update")

    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<User>> updatedetail(@RequestBody UserDTO userDTO){
        BaseResponseRep<Optional<User>> base  ;
        base = BaseResponseRep.<Optional<User>>builder().Data(userServiece.UpdateUser(userDTO)).build();
        return base;
    }
    @GetMapping("/login")
    //public BaseResponseRep jwt(@RequestBody TokenDTO tokenDTO){
     //   return userServiece.Jwt(tokenDTO);
    public BaseResponseRep<Optional<User>> jwt(@RequestBody TokenDTO tokenDTO){
        BaseResponseRep base;
        base=BaseResponseRep.builder().Data(userServiece.Jwt(tokenDTO)).build();
        return base;
    }

}
