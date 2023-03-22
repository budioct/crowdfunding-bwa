package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    private int idtransaction;
    private Campaign campaignid;
    private Users usersid;
    private int amount;
    private String status;
    private String code;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

}
