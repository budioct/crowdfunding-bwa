package com.bwa.crowdfunding.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class UsersDTO {
    private int iduser;
    private String name;
    private String occupation;
    private String email;
    private String passwordhash;
    private String avatarfilename;
    private String role;
    private String token;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

}
