package com.bwa.crowdfunding.controller;

import com.bwa.crowdfunding.entity.Users;
import com.bwa.crowdfunding.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {

        return usersService.findAll();

    }

    @GetMapping("/test")
    public String testRestApi(){
        return "hello";
    }



}
