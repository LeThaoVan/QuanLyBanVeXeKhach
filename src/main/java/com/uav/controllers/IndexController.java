/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.service.BusService;
import com.uav.service.GarageService;
import com.uav.service.ProvinceService;
import com.uav.service.RouteService;
import com.uav.service.TypeOBusService;
import com.uav.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pc
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class IndexController {
 @Autowired
    private ProvinceService provinceService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private UserService usersService;
    @Autowired
    private BusService busService;
    @Autowired
    private TypeOBusService typeobusesService;
    @Autowired
    private GarageService garageSevice;

     
     @ModelAttribute
    public void commonAttr(Model model, @RequestParam Map<String, String> params,
                            HttpSession session) {
        model.addAttribute("nguoidung", this.usersService.getUsers());
        model.addAttribute("routes", this.routeService.getRoutes(params, 0));
        model.addAttribute("provinces", this.provinceService.getProvinces());
        model.addAttribute("chuyenxe", this.busService.getBus());
        model.addAttribute("loaixe", this.typeobusesService.getTOBus());
         model.addAttribute("nhaxe", this.garageSevice.getGarage());
    }
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}


