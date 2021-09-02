package com.example.TransportManagement.baseresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse <T>{

    Integer recordCount;
    T response;
}
