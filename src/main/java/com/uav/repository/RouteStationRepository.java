/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.repository;

import com.uav.pojo.Routestation;
import java.util.List;

/**
 *
 * @author HP
 */
public interface RouteStationRepository {
    List<Routestation> getPickupStationByRouteId(int routeId);
    List<Routestation> getArriveStationByRouteId(int routeId);
    boolean addRS(Routestation p);
}
