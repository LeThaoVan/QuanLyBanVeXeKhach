
package com.uav.repository;

import com.uav.pojo.Ticket;
import java.util.List;


public interface TicketRepository {
    boolean addTicket(Ticket p);
     List<Object[]> ticketStats(String qm, int y, int m);
     Ticket findTicketById(int ticketId);
      boolean updateStatusTicket(int ticketId);
      List<Ticket> getTicket();
      boolean deleteTicket(int id);
}
