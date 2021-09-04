package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.UserDTO;

import com.example.TransportManagement.entity.User;
import com.example.TransportManagement.serviece.UserServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserServiece userServiece;

    @PostMapping("/create")
    public BaseResponse add(@RequestBody UserDTO userDTO){

        return userServiece.addUser(userDTO);
    }
    @GetMapping("/pagination/{offset}/{pageSize}/{name}")
    private APIResponse<User> userPagination
            (@PathVariable int offset, @PathVariable int pageSize, @PathVariable String name){
        return userServiece.userPagination(offset, pageSize,name);
    }
    @GetMapping("/userid/{id}")
    public User findUserById(@PathVariable int id){
        return userServiece.getUserById(id);
    }

    @PutMapping("/deleteSoft")
    public BaseResponse  deleteSoft(@RequestBody UserDTO userDTO){
        return userServiece.deleteUser(userDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateInfo(@RequestBody UserDTO userDTO){
        return userServiece.updateUser(userDTO);
    }

}
