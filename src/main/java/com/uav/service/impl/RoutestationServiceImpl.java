/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Routestation;
import com.uav.repository.RouteStationRepository;
import com.uav.service.RoutestationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutestationServiceImpl implements RoutestationService {

    @Autowired
    private RouteStationRepository routeStationRepository;

    @Override
    public List<Routestation> getPickupStationByRouteId(int routeId) {
        return this.routeStationRepository.getPickupStationByRouteId(routeId);
    }

    @Override
    public List<Routestation> getArriveStationByRouteId(int routeId) {
        return this.routeStationRepository.getArriveStationByRouteId(routeId);
    }

    @Override
    public boolean addRS(Routestation p) {
        return this.routeStationRepository.addRS(p);
    }
}
