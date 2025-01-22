package com.tekarch.TafUserService.Service.Interface;

import com.tekarch.TafUserService.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserByUsername(String username);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long id, UserDTO userDTO);
}
