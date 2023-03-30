package com.bwa.crowdfunding.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users", schema = "jointable")
@SequenceGenerator(
        name = "seq_generator_users",
        schema = "generator",
        allocationSize = 1,
        sequenceName = "seq_users",
        initialValue = 1)
public class Users {

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(generator = "seq_generator_users")
    private int iduser;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "occupation", length = 50)
    private String occupation;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "passwordhash", nullable = false)
    private String passwordhash;
    @Column(name = "avatarfilename")
    private String avatarfilename;
    @Column(name = "role")
    private String role;
    @Column(name = "token")
    private String token;
    @Column(name = "create_at")
    private LocalDateTime create_at;
    @Column(name = "update_at")
    private LocalDateTime update_at;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToMany(mappedBy = "users")
    private List<Campaign> campaignList = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToMany(mappedBy = "users")
    private List<Transaction> transactionList = new ArrayList<>();


}
