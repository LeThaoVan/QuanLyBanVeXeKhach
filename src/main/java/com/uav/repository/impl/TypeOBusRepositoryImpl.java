/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.TypeOfBus;
import com.uav.repository.TypeOBusRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
public class TypeOBusRepositoryImpl implements TypeOBusRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<TypeOfBus> getTOBus() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM TypeOfBus");
        return q.getResultList();
    }

}
