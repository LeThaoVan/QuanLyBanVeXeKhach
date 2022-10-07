/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Buses;
import com.uav.pojo.Garage;
import com.uav.service.BusService;
import com.uav.service.GarageService;
import com.uav.service.TypeOBusService;
import com.uav.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pc
 */
@Controller
public class AdminController {

    @Autowired
    private Environment env;
    @Autowired
    private BusService busesService;
     @Autowired
    private GarageService garageSevice;

    @RequestMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping("/admin/buses")
    public String list(Model model,
            @RequestParam(value = "idBuses", defaultValue = "0") int id,
            @RequestParam(value = "tenchuyen", defaultValue = "null") String nameB,
            @RequestParam(value = "newdriver", defaultValue = "0") int id4) {
        model.addAttribute("buses", new Buses());
        if (nameB != "null")
                 this.busesService.updateBusName(id, nameB);
        
        this.busesService.updateBusDriver(id, id4);
        return "admin-bus";
    }

    @PostMapping("/admin/buses")
    public String add(@ModelAttribute(value = "buses") @Valid Buses p,
            BindingResult r) {

        if (r.hasErrors()) {
            return "admin-bus";
        }

        if (this.busesService.addBus(p) == true) {
            return "redirect:/admin/buses";
        }

        return "admin-bus";
    }

    @GetMapping("/admin/garage")
    public String list(Model model, 
            @RequestParam(value = "idGara", defaultValue = "0") int id,
            @RequestParam(value = "garagename", defaultValue = "null") String nameG) {
        
        model.addAttribute("garage", new Garage());
        this.garageSevice.updateGarageName(id, nameG);
        return "admin-garage";
    }
    @PostMapping("/admin/garage")
    public String addGarage(@ModelAttribute(value = "garage") @Valid Garage p,
            BindingResult r) {

        if (r.hasErrors()) {
            return "admin-garage";
        }

        if (this.garageSevice.addGarage(p) == true) {
            return "redirect:/admin/garage";
        }

        return "admin-garage";
    }
    
    @GetMapping("/admin/confirm")
    public String list(Model model,
            @RequestParam(value = "newactive", defaultValue = "0") int id3,
            @RequestParam(value = "idBuses2", defaultValue = "0") int id,
            @RequestParam(value = "newstatus", defaultValue = "0") int id4,
            @RequestParam(value = "idGara", defaultValue = "0") int id2) {
        this.busesService.updateBusStatus(id, id3);
        this.garageSevice.updateGarageStatus(id2, id4);
        return "admin-confirm";
    }

}
