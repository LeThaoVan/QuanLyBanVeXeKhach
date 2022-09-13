/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Route;
import com.uav.repository.RouteRepository;
import com.uav.service.RouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getRoutes(Map<String, String> params, int page) {
        return this.routeRepository.getRoutes(params, page);
    }

    @Override
    public long countRoute() {
        return this.routeRepository.countRoute();
    }

    @Override
    public boolean deleteRoute(int id) {
        return this.routeRepository.deleteRoute(id);
    }

    @Override
    public boolean addRoute(Route p) {
        return this.routeRepository.addRoute(p);
    }

    @Override
    public Route getRouteById(int routeId) {
        return this.routeRepository.getRouteById(routeId);
    }

}
