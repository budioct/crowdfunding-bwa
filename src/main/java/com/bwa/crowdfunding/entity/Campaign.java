package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Campaign {

    @Id
    private int idcampaign;

    @ManyToOne
    @JoinColumn(name="userid")
    private Users usersid;

    @OneToMany(mappedBy = "campaignid")
    private List<CampaignImages>  campaignimages;

    @OneToMany(mappedBy = "campaignid")
    private List<Transaction> transaction;

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
