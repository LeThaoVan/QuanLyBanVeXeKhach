/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Province;
import com.uav.repository.ProvinceRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
/**
 *
 * @author pc
 */
@Repository
@Transactional
public class ProvinceRepositoryImpl implements ProvinceRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    
    @Override
    public List<Province> getProvinces() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Province");
        return q.getResultList();
    }
}
