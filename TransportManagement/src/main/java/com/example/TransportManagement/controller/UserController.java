package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.APIResponse;
import com.example.TransportManagement.baseresponse.BaseResponse;
import com.example.TransportManagement.baseresponse.BaseResponseRep;
import com.example.TransportManagement.dto.LoadDTO;
import com.example.TransportManagement.dto.UserDTO;

import com.example.TransportManagement.entity.User;
import com.example.TransportManagement.servieceImplements.UserServieceImplements;
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

    public BaseResponseRep adduser(@RequestBody UserDTO userDTO){
        BaseResponseRep base;
        base= BaseResponseRep.builder().Data(userServiece.adduser(userDTO)).build();
        return base;
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{name}")
    //private APIResponse<User> userPagination
          //  (@PathVariable int offset, @PathVariable int pageSize, @PathVariable String name){
      //  return userServiece.userpagination(offset, pageSize,name);
    public APIResponse<User>userPagination( @PathVariable int offset ,@PathVariable int pageSize,@PathVariable String name){
        APIResponse base;
       
        base= APIResponse.<Page<User>>builder().response(userServiece.userpagination(offset,pageSize,name)).build();
        return base;
    }


    @GetMapping("/userid/{id}")
    public BaseResponseRep<Optional<User>>getById(@PathVariable int id){
        BaseResponseRep base;
        base =BaseResponseRep.<Optional<User>>builder().Data(userServiece.getuserById(id)).build();
        return base;
    }

    @PutMapping("/delete")

    public BaseResponseRep deleteuser(@RequestBody UserDTO userDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(userServiece.deleteuser(userDTO)).build();
        return base;
    }

    @PutMapping("/update")

    public BaseResponseRep updatedetail(@RequestBody UserDTO userDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(userServiece.UpdateUser(userDTO)).build();
        return base;
    }

}
