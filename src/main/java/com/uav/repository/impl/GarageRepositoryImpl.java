/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Garage;
import com.uav.repository.GarageRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
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
public class GarageRepositoryImpl implements GarageRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Override
    public List<Garage> getGarage() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Garage");
        return q.getResultList();
    }

    @Override
    public int countGarage() {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("select Count(*) FROM Garage");

        return Integer.parseInt(q.getSingleResult().toString());  
    }

    @Override
    public boolean deleteGarage(int id) {
         Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Garage p = session.get(Garage.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addGarage(Garage p) {
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
    public Garage getGarageById(int garaId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Garage.class, garaId);
    }

    @Override
    public boolean updateGarageStatus(int id, int bstatus) {
       try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Garage> update = b.createCriteriaUpdate(Garage.class);
            Root gara = update.from(Garage.class);

            update.set("status", bstatus);
            update.where(b.equal(gara.get("id"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean updateGarageName(int id, String newname) {
       try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Garage> update = b.createCriteriaUpdate(Garage.class);
            Root gara = update.from(Garage.class);

            update.set("name", newname);
            update.where(b.equal(gara.get("id"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean updateGarageUsers(int id, int newuserid) {
     try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Garage> update = b.createCriteriaUpdate(Garage.class);
            Root gara = update.from(Garage.class);

            update.set("idUser", newuserid);
            update.where(b.equal(gara.get("id"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
}
