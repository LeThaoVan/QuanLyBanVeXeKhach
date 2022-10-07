/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Buses;
import com.uav.pojo.Garage;
import com.uav.pojo.TypeOfBus;
import com.uav.pojo.User;
import com.uav.repository.BusRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class BusRepositoryImpl implements BusRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Buses> getBus() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Buses");
        return q.getResultList();
    }

    @Override
    public int countBus() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("select Count(*) FROM Buses");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteBus(int id) {
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
    public boolean addBus(Buses p) {
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
    public boolean updateBusStatus(int id, int bstatus) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Buses> update = b.createCriteriaUpdate(Buses.class);
            Root bus = update.from(Buses.class);

            update.set("active", bstatus);
            update.where(b.equal(bus.get("id"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBusName(int id, String newname) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Buses> update = b.createCriteriaUpdate(Buses.class);
            Root bus = update.from(Buses.class);

            update.set("name", newname);
            update.where(b.equal(bus.get("id"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBusDriver(int id, int newuserid) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Buses> update = b.createCriteriaUpdate(Buses.class);
            Root bus = update.from(Buses.class);

            update.set("driverId", newuserid);
            update.where(b.equal(bus.get("id"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
