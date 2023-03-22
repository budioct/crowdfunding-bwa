package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Campaign {

    private int idcampaign;
    private Users usersid;
    private String name;
    private String shortdescription;
    private String description;
    private int goalamount;
    private int currentamount;
    private String perks;
    private int backercount;
    private String slug;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

}
