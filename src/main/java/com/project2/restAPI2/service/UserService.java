package com.project2.restAPI2.service;

import com.project2.restAPI2.dto.UserDTO;
import com.project2.restAPI2.model.User;
import com.project2.restAPI2.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
@Transactional
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();

        // Check if users exist
        if (userList.isEmpty()) {
            logger.warn("No users found in the database.");
        }

        // Convert Entity List → DTO List
        return userList.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }


    public UserDTO saveUser(UserDTO userdto) {
        try {
            logger.info("Received UserDTO: {}", userdto);

            // Convert DTO → Entity
            User user = modelMapper.map(userdto, User.class);

            // Save to database
            User savedUser = userRepo.save(user);

            logger.info("Saved User: {}", savedUser);

            // Convert Entity → DTO and return
            return modelMapper.map(savedUser, UserDTO.class);
        } catch (Exception e) {
            logger.error("Error saving user: ", e);
            throw new RuntimeException("Error saving user", e);
        }
    }

}
