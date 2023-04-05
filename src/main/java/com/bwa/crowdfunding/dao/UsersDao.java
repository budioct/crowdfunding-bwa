package com.bwa.crowdfunding.dao;

import com.bwa.crowdfunding.entity.Users;
import com.bwa.crowdfunding.repository.CrudRepository;
import com.bwa.crowdfunding.utilities.config.HibernateConfigure;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

//@Component
@Slf4j
@Repository
public class UsersDao implements CrudRepository<Users, Integer> {

//    @PersistenceContext
    private Session session; // = HibernateConfigure.getSession();

    @Autowired
    public UsersDao() {
        //this.session = session;
        this.session = HibernateConfigure.getSession();
    }

    @Override
    public Users save(Users value) throws HibernateException {
        Integer save = (Integer) this.session.save(value);
        value.setIduser(save);
        return value;
    }

    @Override
    public Users update(Users value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(Integer value) throws HibernateException {

        //language=HQL
        String hql = "delete from Users where iduser = :userId";
        Query<Users> query = this.session.createQuery(hql)
                .setParameter("userId", value);
        int delete = query.executeUpdate();
        return delete >= 0;
    }

    @Override
    public Optional<Users> findById(Integer value) {

        //language=HQL
        String hql = "from Users where id = :userId";
        try {

            Query<Users> query = this.session.createQuery(hql, Users.class)
                    .setParameter("userId", value);
            Users result = query.getSingleResult();
            return result != null ? Optional.of(result) : Optional.empty();

        } catch (NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Users> findAll() {
        List<Users> resultList = null;
        try {
            this.session.beginTransaction();
            //language=HQL
            String hql = "from Users";
            Query<Users> query = this.session.createQuery(hql, Users.class);
            resultList = query.getResultList();

            this.session.getTransaction().commit();
            return resultList;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
//            this.session.close();
        }
        return resultList;
    }

}
