/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.User;
import com.uav.repository.UserRepository;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Stateless
@LocalBean
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM User");

        return q.getResultList();
    }

//    @Override
//    public boolean addUser(User user) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        try {
//            session.save(user);
//            return true;
//        } catch (HibernateException ex) {
//            System.err.println("===========" + ex.getMessage());
//            ex.printStackTrace();
//            return false;
//        }
//    }

    @Override
    public List<User> getUser(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if (!username.isEmpty()) {
            Predicate p = b.equal(root.get("userName"), username.trim());
            q = q.where(p);
        }

        org.hibernate.query.Query query = session.createQuery(q);
        return query.getResultList();

    }

    @Override
    public boolean deleteUsers(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            User p = session.get(User.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(int id, String newrode) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<User> update = b.createCriteriaUpdate(User.class);
            Root users = update.from(User.class);

            update.set("role", newrode);
            update.where(b.equal(users.get("id"), id));
            int query = session.createQuery(update).executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
