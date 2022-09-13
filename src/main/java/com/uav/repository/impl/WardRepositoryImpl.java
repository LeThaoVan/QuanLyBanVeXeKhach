package com.uav.repository.impl;

import com.uav.pojo.Ward;
import com.uav.repository.WardRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
@Repository
@Transactional
public class WardRepositoryImpl implements WardRepository{
@Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Ward> getWard() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Ward");
        return q.getResultList();
    }
    
}
