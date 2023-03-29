package com.bwa.crowdfunding.testconnection;

import com.bwa.crowdfunding.utilities.config.HibernateConfigure;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Slf4j
public class HibernateConnectionTest {

    private static final Logger log = LoggerFactory.getLogger(HibernateConnectionTest.class);

    private Session session;

    @BeforeEach
    void setUp() {
        log.info("ini hibernate session");
        this.session = HibernateConfigure.getSession();
    }

    @AfterEach
    void tearDown() {
        log.info("destroy hibernate session!");
        this.session.close();
    }

    @Test
    void testConnectionHibernate(){
        this.session.beginTransaction();
    }

}
