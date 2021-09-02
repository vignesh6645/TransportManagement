package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.dto.UserDTO;
import com.example.TransportManagement.entity.User;
import com.example.TransportManagement.serviece.UserServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserServiece userServiece;

    @PostMapping("/create")
    public BaseResponse add(@RequestBody UserDTO userDTO){

        return userServiece.add(userDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateDetail(@RequestBody UserDTO userDTO){
        return userServiece.updateUserDetail(userDTO);
    }

   @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<User>> findUserWithPagination(@PathVariable int offset,@PathVariable int pageSize){
        Page<User> Pagination = userServiece.findUserWithPagination(offset, pageSize);
        return new APIResponse<>(Pagination.getSize(),Pagination);
    }

    @GetMapping("/userid/{id}")
    public User findUserById(@PathVariable int id){
        return userServiece.getUserById(id);
    }
}
