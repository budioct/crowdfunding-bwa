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
@Entity
@Builder
@Table(name = "campaign", schema = "jointable")
@SequenceGenerator(
        name = "seq_generator_campaign",
        schema = "generator",
        allocationSize = 1,
        sequenceName = "seq_campaign",
        initialValue = 1)
public class Campaign {

    @Id
    @Column(name = "id_campaign", nullable = false)
    @GeneratedValue(generator = "seq_generator_campaign")
    private int idcampaign;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "shortdescription")
    private String shortdescription;
    @Column(name = "description")
    private String description;
    @Column(name = "goalamount")
    private int goalamount;
    @Column(name = "currentamount")
    private int currentamount;
    @Column(name = "perks")
    private String perks;
    @Column(name = "backercount")
    private int backercount;
    @Column(name = "slug")
    private String slug;
    @Column(name = "create_at")
    private LocalDateTime create_at;
    @Column(name = "update_at")
    private LocalDateTime update_at;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToMany(mappedBy = "campaigns")
    private List<Transaction> transactionList = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToMany(mappedBy = "campaigns")
    private List<CampaignImages> campaignImagesList = new ArrayList<>();




}
