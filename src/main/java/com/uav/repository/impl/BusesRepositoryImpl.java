/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Buses;
import com.uav.repository.BusesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class BusesRepositoryImpl implements BusesRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Buses> getBuses(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Buses> q = b.createQuery(Buses.class);
        Root root = q.from(Buses.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw2");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("busesName").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }
        }

        q.orderBy(b.desc(root.get("bid")), b.desc(root.get("busesName")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countBuses() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select Count(*) FROM Buses");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteBuses(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Buses p = session.get(Buses.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBuses(Buses p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(p);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    
    }

    @Override
    public Buses getBusById(int busId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Buses.class, busId);
    }

    @Override
    public boolean updateBuses(int id, String newname, int bstatus) {
       try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Buses> update = b.createCriteriaUpdate(Buses.class);
            Root users = update.from(Buses.class);

            update.set("busesName", newname);
            update.set("bstatus", bstatus);
            update.where(b.equal(users.get("bid"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }



}
