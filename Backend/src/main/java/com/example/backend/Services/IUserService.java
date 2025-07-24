package com.example.backend.Services;
import com.example.backend.DTO.UserDTO ;
import com.example.backend.Entites.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    com.example.backend.DTO.UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
