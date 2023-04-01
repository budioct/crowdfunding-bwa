package com.bwa.crowdfunding.dao;

import com.bwa.crowdfunding.entity.Campaign;
import com.bwa.crowdfunding.entity.Users;
import com.bwa.crowdfunding.utilities.config.HibernateConfigure;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class CampaignDaoTest {

    private Session session;

    private UsersDao userDao;

    private CampaignDao campaignDao;

    @BeforeEach
    void setUp() {
        log.info("ini hibernate session");
        this.session = HibernateConfigure.getSession();
        this.userDao = new UsersDao(session);
        this.campaignDao = new CampaignDao(session);
    }

    @AfterEach
    void tearDown() {
        log.info("destroy hibernate session!");
        this.session.close();
    }

    @Test
    @Disabled
    void testConnectionHibernate() {
        this.session.beginTransaction();
    }

    @Test
    void testGetAll(){

        this.session.beginTransaction();
        List<Campaign> all = this.campaignDao.findAll();

        Assertions.assertEquals(3, all.size());

        log.info("Campaign Get All: {}", all);

        /**
         * 12:58:26.336 [main] INFO com.bwa.crowdfunding.dao.CampaignDaoTest - Campaign Get All:
         * [Campaign(idcampaign=1, name=test, shortdescription=test, description=test, goalamount=1, currentamount=1, perks=test, backercount=1, slug=test, create_at=2023-03-31T23:25:08, update_at=2023-03-31T23:25:37, users=Users(iduser=5, name=agnes, occupation=bekerja, email=agnes@test.com, passwordhash=rahasil, avatarfilename=null, role=user, token=9ddaa280-c3eb-4ab7-872f-f95a7834c364, create_at=2023-03-30T23:40:28.178428, update_at=null)), Campaign(idcampaign=2, name=test, shortdescription=test, description=test, goalamount=1, currentamount=1, perks=test, backercount=1, slug=test, create_at=2023-03-31T23:25:08, update_at=2023-03-31T23:25:37, users=Users(iduser=5, name=agnes, occupation=bekerja, email=agnes@test.com, passwordhash=rahasil, avatarfilename=null, role=user, token=9ddaa280-c3eb-4ab7-872f-f95a7834c364, create_at=2023-03-30T23:40:28.178428, update_at=null)), Campaign(idcampaign=3, name=test, shortdescription=test, description=test, goalamount=1, currentamount=1, perks=test, backercount=1, slug=test, create_at=2023-03-31T23:25:08, update_at=2023-03-31T23:25:37, users=Users(iduser=3, name=malik, occupation=bekerja, email=malik@test.com, passwordhash=rahasil, avatarfilename=null, role=user, token=478bf1f4-354d-434d-accf-c6c7c8b5f7fd, create_at=2023-03-30T22:57:34.785651, update_at=null))]
         */

    }

    @Test
    void testCreateCampaignDao(){

        this.session.beginTransaction();

        Users jamal = Users.builder()
                .name("saskia")
                .occupation("koki")
                .email("saskia@test.com")
                .passwordhash("rahasil")
                .role("user")
                .token(UUID.randomUUID().toString())
                .create_at(LocalDateTime.now())
                .build();
        jamal = this.userDao.save(jamal);

        Campaign coinPeduliBurger = Campaign.builder()
                .users(jamal)
                .name("coinPeduliBurger")
                .shortdescription("peludi bro")
                .description("Anda bisa memulainya dengan kami")
                .goalamount(30_000)
                .perks("perks")
                .backercount(0)
                .slug("coinpeduliburger")
                .create_at(LocalDateTime.now())
                .build();
        coinPeduliBurger = this.campaignDao.save(coinPeduliBurger);

        Assertions.assertEquals("saskia", jamal.getName());
        Assertions.assertEquals("coinPeduliBurger", coinPeduliBurger.getName());

        this.session.getTransaction().commit();

        log.info("save data users: {}", jamal);
        log.info("save data campaing: {}", coinPeduliBurger);

        /**
         * 13:38:25.737 [main] INFO com.bwa.crowdfunding.dao.CampaignDaoTest - save data users: Users(iduser=8, name=jamal, occupation=tukang kebun, email=jamal@test.com, passwordhash=rahasil, avatarfilename=null, role=user, token=dd1b29d2-6690-406c-8dd5-cba79856387b, create_at=2023-04-01T13:38:25.316249400, update_at=null)
         * 13:38:25.852 [main] INFO com.bwa.crowdfunding.dao.CampaignDaoTest - save data campaing: Campaign(idcampaign=3, name=coinPeduliBurger, shortdescription=peludi bro, description=Anda bisa memulainya dengan kami, goalamount=30000, currentamount=0, perks=perks, backercount=0, slug=coinpeduliburger, create_at=2023-04-01T13:38:25.541243200, update_at=null, users=Users(iduser=8, name=jamal, occupation=tukang kebun, email=jamal@test.com, passwordhash=rahasil, avatarfilename=null, role=user, token=dd1b29d2-6690-406c-8dd5-cba79856387b, create_at=2023-04-01T13:38:25.316249400, update_at=null))
         */

    }

    @Test
    void testFindbyIdCampaign(){

        this.session.beginTransaction();

        var id = 3;
        Optional<Campaign> byId = this.campaignDao.findById(3);
        Campaign campaign = byId.get();

        Assertions.assertTrue(byId.isPresent(), "ID Tidak Ada Bro!!");
        Assertions.assertEquals("coinPeduliBurger", campaign.getName());
        Assertions.assertEquals("coinpeduliburger", campaign.getSlug());
        Assertions.assertEquals(id, campaign.getIdcampaign());

        this.session.getTransaction().commit();

        log.info("id campaing: {}", campaign.getIdcampaign());
        log.info("id campaing name: {}", campaign.getName());
        log.info("Optional<T> Apakah ADA!!: ", byId.isPresent());

    }

    @Test
    void testRemoveByIdCampaing(){

        this.session.beginTransaction();

        var id = 6; // valid
        //var id = 1; // invalid
        boolean data = this.campaignDao.removeById(id);

        Assertions.assertNotNull(data);
        Assertions.assertTrue(data);

        //log.info("Id campaing: {}", id);
        log.info("status Remove id {}", data);
        //log.info("FindById() {}", campaign);


    }

}
