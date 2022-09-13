/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Buses;
import com.uav.repository.BusesRepository;
import com.uav.service.BusesService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class BusesServiceImpl implements BusesService {

    @Autowired
    private BusesRepository busesRepository;
    

    @Override
    public List<Buses> getBuses(Map<String, String> params, int page) {
        return this.busesRepository.getBuses(params, page);
    }

    @Override
    public int countBuses() {
        return this.busesRepository.countBuses();
    }

    @Override
    public boolean deleteBuses(int id) {
        return this.busesRepository.deleteBuses(id);
    }

    @Override
    public boolean addBuses(Buses buses) {
        buses.setImage("https://res.cloudinary.com/dfkf0cjct/image/upload/v1641994146/a0otbfzs3rinppqwxsau.jpg");
        return this.busesRepository.addBuses(buses);

    }

    @Override
    public Buses getBusById(int busId) {
        return this.busesRepository.getBusById(busId);
    }

    @Override
    public boolean updateBuses(int id, String newname, int bstatus) {
        return this.busesRepository.updateBuses(id, newname, bstatus);
    }

}
