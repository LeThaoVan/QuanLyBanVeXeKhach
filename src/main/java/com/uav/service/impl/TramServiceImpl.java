/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Tram;
import com.uav.repository.TramRepository;
import com.uav.service.TramService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class TramServiceImpl implements TramService{

    @Autowired
    private TramRepository tramRepository;
    
    @Override
    public boolean deleteTram(int id) {
        return this.tramRepository.deleteTram(id);
    }

    @Override
    public boolean addTram(Tram p) {
        return this.tramRepository.addTram(p);
    }

    @Override
    public List<Tram> getTram(Map<String, String> params) {
      return this.tramRepository.getTram(params); 
    }

}
