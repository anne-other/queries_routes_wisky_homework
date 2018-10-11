package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> ofYear(int year){
        List<Whisky> whiskiesOfYear = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            whiskiesOfYear = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskiesOfYear;
    }

    @Transactional
    public List<Whisky> ofRegion(String region) {
        List<Whisky> whiskiesOfRegion = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class, "whisky");
            cr.createAlias("whisky.distillery", "distillery");
            cr.add(Restrictions.eq("distillery.region", region));
            whiskiesOfRegion = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskiesOfRegion;
    }

    @Transactional
    public List<Whisky> distilleryAndAge(int distillery, int age) {
        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class, "whisky");
            cr.createAlias("whisky.distillery", "distillery");
            cr.add(Restrictions.eq("distillery.id", new Long(distillery)));
            cr.add(Restrictions.eq("age", age));
            whiskies = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskies;
    }
}
