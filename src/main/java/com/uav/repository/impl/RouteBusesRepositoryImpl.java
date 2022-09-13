/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Buses;
import com.uav.pojo.Routebuses;
import com.uav.repository.RouteBusesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class RouteBusesRepositoryImpl implements RouteBusesRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Routebuses> getRouteBuses(Map<String, String> params, int page, int routeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Routebuses> q = b.createQuery(Routebuses.class);
        Root root = q.from(Routebuses.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (routeId != 0) {
            Predicate p = b.equal(root.get("routeId"), routeId);
            predicates.add(p);
        }

        if (params != null) {
            String kw = params.get("kw3");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("buses_id").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String date = params.get("ngaymuondi");
            if (date != null) {
                Predicate p = b.like(root.get("ngaydi").as(String.class),
                        String.format("%%%s%%", date));
                predicates.add(p);
            }

            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(tp));
                predicates.add(p);
            }

        }

        q.where(predicates.toArray(new Predicate[]{}));

        q.orderBy(b.desc(root.get("rbid")));

        org.hibernate.query.Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countRBuses() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("select Count(*) FROM Routebuses");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteRBuses(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Routebuses p = session.get(Routebuses.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addRBuses(Routebuses p) {
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
    public Routebuses getRoutebusesById(int RoutebusesId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Routebuses.class, RoutebusesId);
    }

    @Override
    public List<Routebuses> getRoutebusesByRouteId(int RouteId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Routebuses> q = builder.createQuery(Routebuses.class);
        Root root = q.from(Routebuses.class);

//        q.select(root);
        q.where(builder.equal(root.get("routeId"), RouteId));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> routebusesStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rD = q.from(Routebuses.class);
        Root rP = q.from(Buses.class);

        q.where(b.equal(rD.get("busesId"), rP.get("bid")));
        q.multiselect(rP.get("bid"), rP.get("busesName"), b.count(rP.get("bid")));
        q.groupBy(rP.get("bid"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean updateSoghe(int rbid, int soghe) {

        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Routebuses> update = b.createCriteriaUpdate(Routebuses.class);
            Root routeBuses = update.from(Routebuses.class);

            update.set("soghe", soghe);
            update.where(b.equal(routeBuses.get("rbid"), rbid));
            int query = session.createQuery(update).executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}


