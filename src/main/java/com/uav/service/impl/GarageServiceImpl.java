/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Garage;
import com.uav.repository.GarageRepository;
import com.uav.service.GarageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class GarageServiceImpl implements GarageService {

    @Autowired
    private GarageRepository garageRepository;

    @Override
    public List<Garage> getGarage() {
        return this.garageRepository.getGarage();
    }

    @Override
    public int countGarage() {
        return this.garageRepository.countGarage();
    }

    @Override
    public boolean deleteGarage(int id) {
        return this.garageRepository.deleteGarage(id);
    }

    @Override
    public boolean addGarage(Garage p) {
        return this.garageRepository.addGarage(p);
    }

    @Override
    public Garage getGarageById(int garaId) {
        return this.garageRepository.getGarageById(garaId);
    }

    @Override
    public boolean updateGarageStatus(int id, int bstatus) {
        return this.garageRepository.updateGarageStatus(id, bstatus);
    }

    @Override
    public boolean updateGarageName(int id, String newname) {
        return this.garageRepository.updateGarageName(id, newname);
    }

    @Override
    public boolean updateGarageUsers(int id, int newuserid) {
        return this.garageRepository.updateGarageUsers(id, newuserid);
    }

}
