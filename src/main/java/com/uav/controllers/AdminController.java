/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Buses;
import com.uav.pojo.Routebuses;
import com.uav.pojo.Routestation;
import com.uav.pojo.Ticket;
import com.uav.pojo.Tram;
import com.uav.pojo.Users;
import com.uav.service.BusesService;
import com.uav.service.TramService;
import com.uav.service.RouteBusesService;
import com.uav.service.RouteService;
import com.uav.service.RoutestationService;
import com.uav.service.TicketService;
import com.uav.service.UserService;
import com.uav.service.WardService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pc
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Environment env;

    @Autowired
    private RouteService routeService;

    @Autowired
    private BusesService busesService;

    @Autowired
    private RoutestationService routestationService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TramService tramService;

    @Autowired
    private RouteBusesService routebusesService;

//ĐƯỜNG DẪN WEB THÊM CHUYẾN XE
    @GetMapping("/buses")
    public String list(Model model, @RequestParam(value = "tenchuyenxe", defaultValue = "") String nameB,
            @RequestParam(value = "idBuses", defaultValue = "0") int id,
            @RequestParam(value = "status", defaultValue = "0") int id3) 
    {
        model.addAttribute("buses", new Buses());
        
        this.busesService.updateBuses(id, nameB, id3);
        
        return "buses";
    }

    @PostMapping("/buses")
    public String add(@ModelAttribute(value = "buses") @Valid Buses p,
            BindingResult r) {

        if (r.hasErrors()) {
            return "buses";
        }

        if (this.busesService.addBuses(p) == true) {
            return "redirect:/admin/buses";
        }

        return "buses";
    }

//ĐƯỜNG DẪN THÊM CHUYẾN XE CHO TUYẾN XE
    @GetMapping("/routebuses")
    public String listRB(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("routebuses", new Routebuses());
        model.addAttribute("routebuses2", this.routebusesService.getRouteBuses(params, 0, 0));
        return "routebuses";
    }

    @PostMapping("/routebuses")
    public String addRB(@ModelAttribute(value = "routebuses") @Valid Routebuses k,
            BindingResult r) {

        if (r.hasErrors()) {
            return "routebuses";
        }

        if (this.routebusesService.addRBuses(k) == true) {
            return "redirect:/admin/routebuses";
        }

        return "routebuses";
    }

//danh sách 
    @GetMapping("/listbuses")
    public String list(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        int size = Integer.parseInt(env.getProperty("page.size").toString());
        model.addAttribute("routebuses", this.routebusesService.getRouteBuses(params, 0, 0));
        //model.addAttribute("tramxe", this.tramService.getTram(params));
        return "listbuses";
    }

    // Thống kê
    @GetMapping("/stats")
    public String stats(Model model,
            @RequestParam(value = "qm", defaultValue = "") String qm,
            @RequestParam(value = "mth", defaultValue = "1") int m,
            @RequestParam(value = "year", defaultValue = "2022") int year) {
        model.addAttribute("routebusesStats", this.routebusesService.routebusesStats());
        model.addAttribute("ticketStats", this.ticketService.ticketStats(qm, year, m));
        return "stats";
    }

    //thêm trạm
    @GetMapping("/tram")
    public String listT(Model model) {
        model.addAttribute("tram", new Tram());
        return "tram";
    }

    @PostMapping("/tram")
    public String addT(@ModelAttribute(value = "tram") @Valid Tram d,
            BindingResult k) {

        if (k.hasErrors()) {
            return "tram";
        }

        if (this.tramService.addTram(d) == true) {
            return "redirect:/admin/tram";
        }

        return "tram";
    }

    @GetMapping("/routestation")
    public String listRS(Model model) {
        model.addAttribute("routestation", new Routestation());
        return "routestation";
    }

    @PostMapping("/routestation")
    public String addRS(@ModelAttribute(value = "routestation") @Valid Routestation r,
            BindingResult e) {

        if (e.hasErrors()) {
            return "routestation";
        }

        if (this.routestationService.addRS(r) == true) {
            return "redirect:/admin/routestation";
        }

        return "routestation";
    }

    @Autowired
    private UserService usersService;

    @GetMapping("/users")
    public String listU(Model model, @RequestParam(value = "newrode", defaultValue = "") String rode,
            @RequestParam(value = "idU", defaultValue = "0") int id) {

        this.usersService.updateUser(id, rode);

        return "users";
    }

    @GetMapping("/admin-ticket")
    public String listTicket(Model model) {
        return "admin-ticket";
    }

}
