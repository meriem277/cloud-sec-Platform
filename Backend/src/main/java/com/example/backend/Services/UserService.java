package com.example.backend.Services;

import com.example.backend.DTO.UserDTO;
import com.example.backend.Entites.User;
import com.example.backend.Repositories.UserRepository;
import com.example.backend.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ CREATE
    @Override
    public UserDTO createUser(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setImage(dto.getImage());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setRole(dto.getRole());
        user.setEnabled(dto.isEnabled());

        userRepository.save(user);
        dto.setIdUser(user.getIdUser());
        return dto;
    }

    // ✅ READ ALL
    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> UserDTO.builder()
                .idUser(user.getIdUser())
                .username(user.getUsername())
                .email(user.getEmail())
                .image(user.getImage())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .enabled(user.isEnabled())
                .build()).collect(Collectors.toList());
    }

    // ✅ READ BY ID
    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(user -> UserDTO.builder()
                .idUser(user.getIdUser())
                .username(user.getUsername())
                .email(user.getEmail())
                .image(user.getImage())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .enabled(user.isEnabled())
                .build());
    }

    // ✅ UPDATE
    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return null;

        User user = optionalUser.get();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setImage(dto.getImage());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setRole(dto.getRole());
        user.setEnabled(dto.isEnabled());

        userRepository.save(user);
        return dto;
    }

    // ✅ DELETE
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
