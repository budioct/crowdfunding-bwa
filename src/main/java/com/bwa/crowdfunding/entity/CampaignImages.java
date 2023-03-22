package com.bwa.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CampaignImages {

    private int idcampaignimages;
    private Campaign campaignid;
    private String filename;
    private String isprimary; // (tinyint) 1= true 0=false
    private LocalDateTime create_at;
    private LocalDateTime update_at;

}
