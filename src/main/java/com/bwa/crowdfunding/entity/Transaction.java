package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Entity
public class Transaction {

//    @Id
    private int idtransaction;

//    @ManyToOne
//    @JoinColumn(name= "campaignid")
//    private Campaign campaignid;

//    @ManyToOne
//    @JoinColumn(name= "usersid")
//    private Users usersid;
    private int amount;
    private String status;
    private String code;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

}
