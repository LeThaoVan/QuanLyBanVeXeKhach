/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Buses;
import com.uav.pojo.Route;
import com.uav.pojo.Routebuses;
import com.uav.pojo.Ticket;
import com.uav.repository.CommentRepository;
import com.uav.service.BusesService;
import com.uav.service.RouteService;
import com.uav.service.RouteBusesService;
import com.uav.service.RoutestationService;
import com.uav.service.TicketService;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PropertySource("classpath:messages.properties")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private RoutestationService routestationService;

    @Autowired
    private RouteBusesService routebusesService;
    
    @Autowired
    private TicketService ticketService;

    @Autowired
    private BusesService busesService;
    
    @Autowired
    private CommentRepository commentRepository;

    
    @Autowired
    private Environment env;
    
    @GetMapping("/route/{routeId}")
    public String RouteDetail(Model model, @PathVariable(value = "routeId") int routeId, 
            @ModelAttribute(value = "buses") Buses buses,
            @RequestParam Map<String, String> params) {
        Route rId = this.routeService.getRouteById(routeId);
        model.addAttribute("startingpoint", rId.getStartingpoint().getName());
        model.addAttribute("destination", rId.getDestination().getName());
        model.addAttribute("route", this.routeService.getRouteById(routeId));
//      model.addAttribute("routeBuses01", this.routebusesService.getRoutebusesByRouteId(routeId));
        model.addAttribute("routeBuses", this.routebusesService.getRouteBuses(params, 0,routeId));
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        int size = Integer.parseInt(env.getProperty("page.size").toString());
        model.addAttribute("page_size",size);
        model.addAttribute("routebCounter", this.routebusesService.countRBuses());
        return "route-details";
    }

    @GetMapping("/route/{routeId}/{routeBusID}")
    public String SoleTicket(Model model,@RequestParam Map<String, String> params, @PathVariable(value = "routeId") int routeId,
            @PathVariable(value = "routeBusID") int routeBusID,
            HttpSession session,
            @RequestParam(value = "soghe", required = false, defaultValue = "") String soghe) {
        model.addAttribute("route", this.routeService.getRouteById(routeId));
        model.addAttribute("routeBus", this.routebusesService.getRoutebusesById(routeBusID));
        model.addAttribute("pickupStations", this.routestationService.getPickupStationByRouteId(routeId));
        model.addAttribute("arriveStations", this.routestationService.getArriveStationByRouteId(routeId));
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("countComment", this.commentRepository.countComment(routeBusID));
        
        int page = 1;
        if(params !=null)
        {
             page = Integer.parseInt(params.getOrDefault("page","1"));
        }
        model.addAttribute("comments", this.commentRepository.getCommentsByRouteBusesId(routeBusID, page));
        
        int size = Integer.parseInt(env.getProperty("page.comment").toString());
        model.addAttribute("page_comment",size);
        
        return "sole-ticket";
    }

    @RequestMapping(value = "/route/addTicket/{busId}/{routeBusID}", method = RequestMethod.POST)
    public String addTicket(ModelMap model,
            @ModelAttribute(value = "ticket") Ticket ticket,
            HttpServletRequest request,
            @PathVariable(value = "busId") int busId,
            @PathVariable(value = "routeBusID") int routeBusID) {
        
        Routebuses routBus = this.routebusesService.getRoutebusesById(routeBusID);
        int amount = ticket.getAmount();
        Buses bus = this.busesService.getBusById(busId);
        ticket.setBusesId(bus);
        
        int total = ticket.getAmount() * routBus.getPrice();
        ticket.setTotal(total);
        ticket.setTstatusPay(Short.parseShort("0"));
        ticket.setCreatedatetime(new Date());
        this.ticketService.addTicket(ticket);
        
        try{
            //sau khi add vé thành công trừ lai số ghế
            int sogheUpdate = routBus.getSoghe() - amount;
            this.routebusesService.updateSoghe(routeBusID, sogheUpdate);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        model.addAttribute("ticket01", ticket);
        return "pay";
    }
    
    @RequestMapping("/pay/{ticketId}")
    public String pay(Model model,@PathVariable(value = "ticketId") int ticketId){
        String statusPay ="";
        if(this.ticketService.updateStatusTicket(ticketId))
        {
            statusPay = "Thanh toan thanh cong";
        }
        
        model.addAttribute("statusPay", statusPay);
        return "pay"; 
    }
    
    @GetMapping("/findTicket/")
    public String findTicket(Model model,
            @RequestParam Map<String, String> params
            )
    {
             int ticketId = Integer.parseInt(params.getOrDefault("ticketId","0"));
             model.addAttribute("ticket",this.ticketService.findTicketById(ticketId));
        
        return "pay";
    }
}
