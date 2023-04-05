package com.bwa.crowdfunding.controller;

import com.bwa.crowdfunding.entity.Users;
import com.bwa.crowdfunding.service.UsersService;
import com.bwa.crowdfunding.utilities.config.ConvertJSON;
import com.bwa.crowdfunding.utilities.config.HibernateConfigure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public Map<String, Object> getAllUsers() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Users> list = usersService.getAllUsers();
            if (list.size() > 0) {
                map.put("Data", list);
                map.put("Total Data", list.size());
                map.put("Status", Boolean.TRUE);
            } else {
                map.put("Data", "Not Found");
                map.put("Status", Boolean.FALSE);
            }
            return map;
        } catch (Throwable e){
            e.printStackTrace();
            return map;
        }

    }

    @GetMapping("/test")
    public String testRestApi() throws JsonProcessingException {

        ObjectMapper mapper = ConvertJSON.getObjectMapper();

        log.info("testRestApi()");

        return mapper.writeValueAsString("hello");
    }


}
