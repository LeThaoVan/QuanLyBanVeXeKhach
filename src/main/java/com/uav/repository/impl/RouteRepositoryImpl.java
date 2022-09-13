/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Route;
import com.uav.repository.RouteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Route> getRoutes(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Route> q = b.createQuery(Route.class);
        Root root = q.from(Route.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("routename").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }
            String st = params.get("st");
            if (st != null && !st.isEmpty()) {
                Predicate p = b.equal(root.get("startingpoint"), Integer.parseInt(st));
                predicates.add(p);
            }
             String st2 = params.get("st2");
            if (st != null && !st.isEmpty()) {
                Predicate p = b.equal(root.get("destination"), Integer.parseInt(st2));
                predicates.add(p);
            }
            
            q.where(predicates.toArray(new Predicate[]{}));

        }

        q.orderBy(b.desc(root.get("rid")), b.desc(root.get("routename")), b.desc(root.get("startingpoint")), b.desc(root.get("destination")));

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
    public long countRoute() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Route");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteRoute(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Route p = session.get(Route.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addRoute(Route p) {
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
    public Route getRouteById(int routeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Route.class, routeId);
    }

}
