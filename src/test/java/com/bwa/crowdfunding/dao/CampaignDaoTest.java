package com.bwa.crowdfunding.dao;

import com.bwa.crowdfunding.entity.Campaign;
import com.bwa.crowdfunding.utilities.config.HibernateConfigure;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

import java.util.List;

@Slf4j
public class CampaignDaoTest {

    private Session session;

    private CampaignDao dao;

    @BeforeEach
    void setUp() {
        log.info("ini hibernate session");
        this.session = HibernateConfigure.getSession();
        this.dao = new CampaignDao(session);
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
        List<Campaign> all = this.dao.findAll();

        Assertions.assertEquals(3, all.size());

        log.info("Campaign Get All: {}", all);



    }


}
