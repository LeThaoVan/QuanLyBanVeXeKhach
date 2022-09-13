/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Plxe;
import com.uav.repository.PlxeRepository;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class PlxeRepositoryImpl implements PlxeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Plxe> getPlxes() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Plxe");

        return q.getResultList();
    }

}
