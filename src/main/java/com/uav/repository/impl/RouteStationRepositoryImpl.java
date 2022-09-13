/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Routestation;
import com.uav.repository.RouteStationRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
public class RouteStationRepositoryImpl implements RouteStationRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Routestation> getPickupStationByRouteId(int routeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Routestation> q = b.createQuery(Routestation.class);
        Root root = q.from(Routestation.class);
        
        Predicate p1 = b.equal(root.get("routeId"), routeId);
        Predicate p2 = b.equal(root.get("state"), 1);
        
         q = q.where(b.and(p1,p2));
         
         
        
        Query query = session.createQuery(q);
        
//        List<Routestation> rs =query.getResultList();
//        rs.forEach(r -> System.out.println(rs));
        return query.getResultList();
    }

    @Override
    public List<Routestation> getArriveStationByRouteId(int routeId) {
        
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Routestation> q = b.createQuery(Routestation.class);
        Root root = q.from(Routestation.class);
        
        Predicate p1 = b.equal(root.get("routeId"), routeId);
        Predicate p2 = b.equal(root.get("state"), 2);
        
         q = q.where(b.and(p1,p2));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public boolean addRS(Routestation p) {
          Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(p);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
