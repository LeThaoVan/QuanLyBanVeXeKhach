/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Buses;
import java.util.List;

/**
 *
 * @author pc
 */
public interface BusService {
      List<Buses> getBus();
    int countBus();
    boolean deleteBus(int id);
    boolean addBus(Buses p);
    Buses getBusById(int garaId);
    boolean updateBusStatus(int id, int bstatus);
    boolean updateBusName(int id, String newname);
    boolean updateBusDriver(int id, int newuserid);
}
