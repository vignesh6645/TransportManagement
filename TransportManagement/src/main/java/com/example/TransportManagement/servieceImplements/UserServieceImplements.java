package com.example.TransportManagement.servieceImplements;

import com.example.TransportManagement.dto.TokenDTO;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.example.TransportManagement.Utill.JwtUtil.generateToken;

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

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = new User();

        user.setName(userDTO.getName());
        user.setPassword(bcrypt.encode(userDTO.getPassword()));
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
        else {
            throw new RuntimeException("Not found");
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
        else {
            throw new RuntimeException("Not found");
        }

        User obj= userRepository.save(existUser.get());
        return existUser;


    }


    @Override
    public TokenDTO Jwt(TokenDTO tokenDTO) {
        Optional<User> users = userRepository.findByName(tokenDTO.getName());
        try {
            if (users.isPresent()) {
                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
                boolean chek = bcrypt.matches(tokenDTO.getPassword(), users.get().getPassword());
                if (chek == true) {
                    String jwtt = generateToken(users.get().getId(), "üser", users.get().getName());
                    tokenDTO.setToken(jwtt);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenDTO;
    }


    public UserDetails loadByUserId(String userId) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(userId);
        Optional<User> opt = Optional.ofNullable(user).orElseThrow(
                        () -> new UsernameNotFoundException("useridnot found"))
                .map(UserDetailImp::new);
        if (opt.isPresent()) {
            return (UserDetails) opt.get();
        }
        return null;

    }
    }

