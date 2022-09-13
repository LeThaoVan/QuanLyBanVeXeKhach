/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Ticket;
import java.util.List;

/**
 *
 * @author HP
 */
public interface TicketService {
    boolean addTicket(Ticket p);
    List<Object[]> ticketStats(String qm, int y, int m);
    Ticket findTicketById(int ticketId);
    boolean updateStatusTicket(int ticketId);
    
      List<Ticket> getTicket();
      boolean deleteTicket(int id);
}
