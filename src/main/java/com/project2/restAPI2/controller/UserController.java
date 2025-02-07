package com.project2.restAPI2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class UserController {
    @GetMapping("/getuser")
    public String getUser(){
        return "All Users";
    }
}
