package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {

    private int iduser;
    private String name;
    private String occupation;
    private String email;
    private String passwordhash;
    private String repasswordhash;
    private String avatarfilename;
    private String role;
    private String token;
    private LocalDateTime create_at;
    private LocalDateTime update_at;



}
