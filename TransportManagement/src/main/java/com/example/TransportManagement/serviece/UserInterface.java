package com.example.TransportManagement.serviece;

import com.example.TransportManagement.dto.TokenDTO;
import com.example.TransportManagement.dto.UserDTO;
import com.example.TransportManagement.entity.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserInterface {
    User adduser(UserDTO userDTO);

    Page<User> userpagination(int offset, int pageSize, String name);

    Optional<User> getuserById(int id);

    Optional<User> deleteuser(UserDTO userDTO);

    Optional<User> UpdateUser(UserDTO userDTO);

    TokenDTO Jwt(TokenDTO tokenDTO);
}
