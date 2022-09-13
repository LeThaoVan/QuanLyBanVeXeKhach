/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Route;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public interface RouteService {
    List<Route> getRoutes(Map<String, String> params, int page);

    long countRoute();

    boolean deleteRoute(int id);

    boolean addRoute(Route p);
    
    Route getRouteById (int routeId);
}
