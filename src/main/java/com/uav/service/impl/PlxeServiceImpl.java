/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Plxe;
import com.uav.repository.PlxeRepository;
import com.uav.service.PlxeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class PlxeServiceImpl implements PlxeService{

    @Autowired
    private PlxeRepository plxeRepository;
            
    @Override
    public List<Plxe> getPlxes() {
       return this.plxeRepository.getPlxes();
    }
    
}
