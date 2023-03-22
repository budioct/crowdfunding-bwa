package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Users {

    @Id
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

    @OneToMany(mappedBy = "usersid")
    private List<Campaign> campaign;

    @OneToMany(mappedBy = "usersid")
    private List<Transaction> transaction;


}
