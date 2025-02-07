package com.project2.restAPI2.controller;

import com.project2.restAPI2.dto.UserDTO;
import com.project2.restAPI2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/getuser")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveuser")
    public UserDTO saveUser(@RequestBody UserDTO userdto){
        return userService.saveUser(userdto);
    }
}
