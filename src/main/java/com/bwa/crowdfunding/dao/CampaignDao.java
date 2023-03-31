package com.bwa.crowdfunding.dao;

import com.bwa.crowdfunding.entity.Campaign;
import com.bwa.crowdfunding.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class CampaignDao implements CrudRepository<Campaign, Integer> {

    private Session session;

    public CampaignDao(Session session) {
        this.session = session;
    }

    @Override
    public Campaign save(Campaign value) throws HibernateException {
        Integer save = (Integer) this.session.save(value);
        value.setIdcampaign(save);
        return value;
    }

    @Override
    public Campaign update(Campaign value) throws HibernateException {
        return null;
    }

    @Override
    public boolean removeById(Integer value) throws HibernateException {
        return false;
    }

    @Override
    public Optional<Campaign> findById(Integer value) {
        return Optional.empty();
    }

    @Override
    public List<Campaign> findAll() {

        //language=HQL
        String hql = "select cpg from Campaign cpg join Users usr on (usr.iduser = cpg.users.iduser)";
        Query<Campaign> query = this.session.createQuery(hql, Campaign.class);
        List<Campaign> campaignList = query.getResultList();
        return campaignList;
    }
}
