/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Buses;
import com.uav.repository.BusRepository;
import com.uav.service.BusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Buses> getBus() {
      return this.busRepository.getBus();
    }

    @Override
    public int countBus() {
      return this.busRepository.countBus();
    }

    @Override
    public boolean deleteBus(int id) {
    return this.busRepository.deleteBus(id);
    }

    @Override
    public boolean addBus(Buses p) {
     return this.busRepository.addBus(p);
    }

    @Override
    public Buses getBusById(int garaId) {
     return this.busRepository.getBusById(garaId);
    }

    @Override
    public boolean updateBusStatus(int id, int bstatus) {
     return this.busRepository.updateBusStatus(id, bstatus);
    }

    @Override
    public boolean updateBusName(int id, String newname) {
    return this.busRepository.updateBusName(id, newname); }

    @Override
    public boolean updateBusDriver(int id, int newuserid) {
     return this.busRepository.updateBusDriver(id, newuserid);
    }

}
