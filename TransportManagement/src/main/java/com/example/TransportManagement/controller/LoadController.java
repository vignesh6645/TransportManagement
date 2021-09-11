package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.BaseResponseRep;
import com.example.TransportManagement.dto.LoadDTO;
import com.example.TransportManagement.entity.Load;
import com.example.TransportManagement.servieceImplements.LoadServieceImplements;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/loads")
@RestController
public class LoadController {

    //BaseResponseRep base = new BaseResponseRep();
    @Autowired
    private LoadServieceImplements loadServieceImplements;
  //

    @PostMapping("/create")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Object> adddetail(@RequestBody LoadDTO loadDTO){
       BaseResponseRep  base;
        base= BaseResponseRep.builder().Data(loadServieceImplements.addload(loadDTO)).build();
        return base;
    }

    @PutMapping("/update")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<Load>> updatedetail(@RequestBody LoadDTO loadDTO){
        BaseResponseRep<Optional<Load>> base ;
        base = BaseResponseRep.<Optional<Load>>builder().Data(loadServieceImplements.UpdateLoad(loadDTO)).build();
        return base;
    }

    @PutMapping("/delete")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<Load>> deleteLoad(@RequestBody LoadDTO loadDTO){
        BaseResponseRep <Optional<Load>>base ;
        base = BaseResponseRep.<Optional<Load>>builder().Data(loadServieceImplements.DeleteLoad(loadDTO)).build();
        return base;
    }

    @GetMapping("/getAll")
    @Authorization(value = "Bearer")
    public BaseResponseRep<List<Load>>listAll(){
        BaseResponseRep<List<Load>> base;
        base = BaseResponseRep.<List<Load>> builder().Data(loadServieceImplements.ListAll1()).build();
        return base;
    }

}
