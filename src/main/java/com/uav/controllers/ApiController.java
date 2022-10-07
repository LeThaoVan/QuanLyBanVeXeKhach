/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;


import com.uav.pojo.Buses;
import com.uav.pojo.Garage;
import com.uav.service.BusService;
import com.uav.service.GarageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("/api")
public class ApiController {
     @Autowired
    private BusService busesService;
    
     @Autowired
    private GarageService garageService;
     
    @GetMapping("/buses")
    public ResponseEntity<List<Buses>> list() {
        return new ResponseEntity<>(this.busesService.getBus(), HttpStatus.OK);
    }
    
  
    
    @DeleteMapping("/buses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.busesService.deleteBus(id);
    }
    
    @GetMapping("/garage")
    public ResponseEntity<List<Garage>> listGara() {
        return new ResponseEntity<>(this.garageService.getGarage(), HttpStatus.OK);
    }
    
    @DeleteMapping("/garage/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGara(@PathVariable(value = "id") int id) {
        this.busesService.deleteBus(id);
    }
}
