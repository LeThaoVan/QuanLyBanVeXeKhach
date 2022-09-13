/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Tram;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public interface TramService {
    List<Tram> getTram(Map<String, String> params);
    boolean deleteTram(int id);
    boolean addTram(Tram p);
}
