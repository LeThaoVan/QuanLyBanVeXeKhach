/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Tram;
import com.uav.repository.TramRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
@Repository
@Transactional
public class TramRepositoryImpl implements TramRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Tram> getTram(Map<String, String> params) {
    Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Tram> q = b.createQuery(Tram.class);
        Root root = q.from(Tram.class);
        q.select(root);  
         if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw5");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("tenTram").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }
        }
        Query query = session.createQuery(q);
        
         return query.getResultList();
    }

    @Override
    public boolean deleteTram(int id) {
       Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Tram p = session.get(Tram.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } }

    @Override
    public boolean addTram(Tram p) {
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
