package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CampaignImages {

    @Id
    private int idcampaignimages;

    @ManyToOne
    @JoinColumn(name="campaignid")
    private Campaign campaignid;
    private String filename;
    private String isprimary; // (tinyint) 1= true 0=false
    private LocalDateTime create_at;
    private LocalDateTime update_at;

}
