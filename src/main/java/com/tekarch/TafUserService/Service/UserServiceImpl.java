package com.tekarch.TafUserService.Service;

import com.tekarch.TafUserService.DTO.UserDTO;
import com.tekarch.TafUserService.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Value("${datastore.service.url}")
    private String datastoreServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

   @Override
    public UserDTO getUserByUsername(String username) {
        String url = datastoreServiceUrl + "/users/username/" + username;
        return restTemplate.getForObject(url, UserDTO.class);
    }
    // Get user by ID
    @Override
    public UserDTO getUserById(Long id) {
        String url = datastoreServiceUrl + "/users/" + id;
        return restTemplate.getForObject(url, UserDTO.class);
    }

    // Get all users
    @Override
    public List<UserDTO> getAllUsers() {
        String url = datastoreServiceUrl + "/users";
        return restTemplate.getForObject(url, List.class);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        String url = datastoreServiceUrl + "/users";
        return restTemplate.postForObject(url, userDTO, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        String url = datastoreServiceUrl + "/users/" + id;
        restTemplate.put(url, userDTO);
        return userDTO;
    }

}
