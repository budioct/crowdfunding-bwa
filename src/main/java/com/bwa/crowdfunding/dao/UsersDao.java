package com.bwa.crowdfunding.dao;

import com.bwa.crowdfunding.entity.Users;
import com.bwa.crowdfunding.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;


@Repository
public class UsersDao implements CrudRepository<Users, Integer> {

    private Session session;

    public UsersDao(Session session) {
        this.session = session;
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

        //language=HQL
        String hql = "from Users";
        Query<Users> query = this.session.createQuery(hql, Users.class);
        List<Users> resultList = query.getResultList();

        return resultList;
    }

}
