/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Ward;
import com.uav.repository.WardRepository;
import com.uav.service.WardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class WardServiceImpl implements WardService{

    @Autowired
    private WardRepository wardRepository;
    
    @Override
    public List<Ward> getWard() {
        return this.wardRepository.getWard();
    }
    
}
