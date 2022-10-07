/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.TypeOfBus;
import com.uav.repository.TypeOBusRepository;
import com.uav.service.TypeOBusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class TypeOBusServiceImpl implements TypeOBusService{

    @Autowired
    private TypeOBusRepository typeobusRepository;
    
    @Override
    public List<TypeOfBus> getTOBus() {
        return this.typeobusRepository.getTOBus();
    }
    
}
