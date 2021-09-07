package com.example.TransportManagement.controller;

import com.example.TransportManagement.baseresponse.BaseResponseRep;
import com.example.TransportManagement.dto.LoadDTO;
import com.example.TransportManagement.entity.Load;
import com.example.TransportManagement.servieceImplements.LoadServieceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/loads")
@RestController
public class LoadController {

    //BaseResponseRep base = new BaseResponseRep();
    @Autowired
    private LoadServieceImplements loadServieceImplements;
  //

    @PostMapping("/create")
   // public BaseResponse addDetail(@RequestBody LoadDTO loadDTO){
     //   return loadServieceImplements.addload(loadDTO);
    public  BaseResponseRep adddetail(@RequestBody LoadDTO loadDTO){
       BaseResponseRep base;
        base= BaseResponseRep.builder().Data(loadServieceImplements.addload(loadDTO)).build();
        return base;
    }

    @PutMapping("/update")



    public BaseResponseRep updatedetail(@RequestBody LoadDTO loadDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(loadServieceImplements.UpdateLoad(loadDTO)).build();
        return base;
    }

    @PutMapping("/delete")
    public BaseResponseRep deleteLoad(@RequestBody LoadDTO loadDTO){
        BaseResponseRep base ;
        base = BaseResponseRep.builder().Data(loadServieceImplements.DeleteLoad(loadDTO)).build();
        return base;
    }

    @GetMapping("/getAll")
    public BaseResponseRep<List<Load>>listAll(){
        BaseResponseRep<List<Load>> base;
        base = BaseResponseRep.<List<Load>> builder().Data(loadServieceImplements.ListAll1()).build();
        return base;
    }

}
