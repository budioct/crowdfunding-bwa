package com.bwa.crowdfunding.dao;

import com.bwa.crowdfunding.entity.Users;
import com.bwa.crowdfunding.utilities.config.HibernateConfigure;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.UUID;

@Slf4j
public class UsersDaoTest {

    private Session session;

    private UsersDao dao;

    @BeforeEach
    void setUp() {
        log.info("ini hibernate session");
        this.session = HibernateConfigure.getSession();
        this.dao = new UsersDao(session);
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
    void testSaveUserDao() throws NoSuchFieldException, IllegalAccessException {

        Users malik = Users.builder()
                .name("agnes")
                .occupation("bekerja")
                .email("agnes@test.com")
                .passwordhash("rahasil")
                .role("user")
                .token(UUID.randomUUID().toString())
                .create_at(LocalDateTime.now(ZoneId.of("Asia/Jakarta")))
                .build();

        this.session.beginTransaction();
        malik = this.dao.save(malik);

        Assertions.assertNotNull(malik);

        this.session.getTransaction().commit();

        log.info("Save Users: {}", malik);
        // 22:57:34.937 [main] INFO com.bwa.crowdfunding.dao.UsersDaoTest - Save Users: Users(iduser=3, name=malik, occupation=bekerja, email=malik@test.com, passwordhash=rahasil, avatarfilename=null, role=user, token=478bf1f4-354d-434d-accf-c6c7c8b5f7fd, create_at=2023-03-30T22:57:34.785650700, update_at=null)

    }

    @Test
    void testFindUserById(){

        this.session.beginTransaction();
        var id = 3;

        Optional<Users> byId = this.dao.findById(id);
        Users users = byId.get();

        Assertions.assertTrue(byId.isPresent(), "Id Tidak ada Bro!!");
        Assertions.assertNotNull(users);
        Assertions.assertEquals(id, users.getIduser());

        this.session.getTransaction().commit();

        log.info("Id: {}", id);
        log.info("Data FindById Optional<T>: {}", byId);
        log.info("Data FindById: {}", users);

    }

    @Test
    void testFindAll(){

        this.session.beginTransaction();

        List<Users> users = this.dao.findAll();

        Assertions.assertEquals(1, users.size());

        this.session.getTransaction().commit();

        log.info("Size Data Users: {}", users.size());
        log.info("Data FindAll: {}", users);

    }

    @Test
    void testDeleteById(){

        this.session.beginTransaction();

        var id = 100;
        boolean hasil = this.dao.removeById(id);

        Assertions.assertNotNull(hasil);
        Assertions.assertTrue(hasil);

        this.session.getTransaction().commit();

        log.info("Remove Data: {}", hasil);

    }





}
