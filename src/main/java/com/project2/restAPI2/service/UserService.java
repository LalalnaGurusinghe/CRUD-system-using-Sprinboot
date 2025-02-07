package com.project2.restAPI2.service;

import com.project2.restAPI2.dto.userDTO;
import com.project2.restAPI2.model.User;
import com.project2.restAPI2.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<userDTO> getAllUsers() {
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList , new TypeToken<List<userDTO>>(){}.getType());
    }
}
