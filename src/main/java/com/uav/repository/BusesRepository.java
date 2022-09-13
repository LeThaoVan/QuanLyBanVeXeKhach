/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.repository;

import com.uav.pojo.Buses;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public interface BusesRepository {

    List<Buses> getBuses(Map<String, String> params, int page);
    int countBuses();
    boolean deleteBuses(int id);
    boolean addBuses(Buses p);
    Buses getBusById(int busId);
    boolean updateBuses(int id, String newname, int bstatus);
}
