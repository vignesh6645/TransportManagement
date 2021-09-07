package com.example.TransportManagement.servieceImplements;

import com.example.TransportManagement.dto.UserDTO;
import com.example.TransportManagement.entity.User;
import com.example.TransportManagement.repository.LoadRepository;
import com.example.TransportManagement.repository.UserRepository;
import com.example.TransportManagement.repository.VehicleRespository;
import com.example.TransportManagement.repository.VehicleTypeRepository;
import com.example.TransportManagement.serviece.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServieceImplements implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRespository vehicleRespository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private LoadRepository loadRepository;

    @Override
    public User adduser(UserDTO userDTO) {


        User user = new User();

        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        User obj = userRepository.save(user);

        return user;
    }

    @Override
    public Page<User> userpagination(int offset, int pageSize, String name) {

        Pageable paging = PageRequest.of(offset,pageSize);
        Page<User> users = userRepository.searchAllByNameLike("%" + name + "%",paging);

        //APIResponse apiResponse = new APIResponse();
        //apiResponse.setResponse(users);
        //apiResponse.setRecordCount(users.getTotalPages());

        return users;


    }

    @Override
    public Optional<User> getuserById(int id) {

     Optional<User>user=userRepository.findById(id);
      return user;
    }

    @Override
    public Optional<User> deleteuser(UserDTO userDTO) {
        User user = new User();
        Optional<User> existUser=userRepository.findById(userDTO.getId());
        if (existUser.isPresent()){

            existUser.get().setIsDelete(1);
        }


         User obj =userRepository.save(existUser.get());

        return existUser;


    }

    @Override
    public Optional<User> UpdateUser(UserDTO userDTO) {

        Optional<User> existUser = userRepository.findById(userDTO.getId());
        if(existUser.isPresent()){

            existUser.get().setId(userDTO.getId());
            existUser.get().setName(userDTO.getName());
            existUser.get().setPassword(userDTO.getPassword());
        }


        User obj= userRepository.save(existUser.get());
        return existUser;


    }

}
