/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Garage;
import java.util.List;

/**
 *
 * @author pc
 */
public interface GarageService {
        List<Garage> getGarage();
    int countGarage();
    boolean deleteGarage(int id);
    boolean addGarage(Garage p);
    Garage getGarageById(int garaId);
    boolean updateGarageStatus(int id, int bstatus);
    boolean updateGarageName(int id, String newname);
    boolean updateGarageUsers(int id, int newuserid);
}
