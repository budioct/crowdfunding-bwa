package com.bwa.crowdfunding.dao;

import com.bwa.crowdfunding.entity.Campaign;
import com.bwa.crowdfunding.repository.CrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Slf4j
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

        //language=HQL
        String hql = "delete from Campaign where idcampaign = :id";
        Query query = this.session.createQuery(hql)
                .setParameter("id", value);
        int data = query.executeUpdate();

        // malvin
//        Optional<Campaign> byId = findById(value);
//        if (byId.isPresent()) {
//        }
//        log.info("info getPerks(): {}", byId.get().getPerks());
//        log.info("info getName(): {}", byId.get().getName());
//        log.info("Info Campaign", byId.get().toString());
//
//        return byId != null ? true : false;
//            if (!byId.isEmpty()){s
//                log.info("byId exist {}");
//                int data = query.executeUpdate();
//                return data >= 0 ? true : false;
//            }else {
//                return false;
//            }

        return data >= 0 ? true : false;

    }

    @Override
    public Optional<Campaign> findById(Integer value) {

        try {
            //language=HQL
            String hql = "from Campaign where idcampaign = :id";
            Query<Campaign> query = this.session.createQuery(hql, Campaign.class)
                    .setParameter("id", value);
            Campaign data = query.getSingleResult();
            return data != null ? Optional.of(data) : Optional.empty();

        } catch (NoResultException e) {
            //log.info("Error findById(): {}", Optional.of(e));
            return Optional.empty();
        }
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
