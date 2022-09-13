/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Ticket;
import com.uav.service.TicketService;
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
public class ApiTicketController {
     @Autowired
    private TicketService ticketService;
    
     @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> list() {
        return new ResponseEntity<>(this.ticketService.getTicket(), HttpStatus.OK);
    }
    
    @DeleteMapping("/ticket/{tid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "tid") int id) {
        this.ticketService.deleteTicket(id);
    }
}
