/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Buses;
import com.uav.pojo.Routebuses;
import com.uav.pojo.Ticket;
import com.uav.repository.TicketRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
public class TicketRepositoryImpl implements TicketRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    

    @Override
    public boolean addTicket(Ticket p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(p);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object[]> ticketStats(String qm, int y, int m) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        
        Root rB = q.from(Buses.class);
        Root rT = q.from(Ticket.class);
       
        q.where(b.equal(rT.get("busesId"), rB.get("bid")),
                b.equal(b.function(qm, Integer.class, rT.get("createdatetime")), m),
                b.equal(b.function("YEAR", Integer.class, rT.get("createdatetime")), y));
         
        q.multiselect(rB.get("bid"), rB.get("busesName"), b.sum(rT.get("total")), 
                b.sum(rT.get("amount")));
        
        q.groupBy(rB.get("bid"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Ticket findTicketById(int ticketId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Ticket.class, ticketId);
    }

    @Override
    public boolean updateStatusTicket(int ticketId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaUpdate<Ticket> update = b.createCriteriaUpdate(Ticket.class);
            Root routeBuses = update.from(Ticket.class);

            update.set("tstatusPay", Short.parseShort("1"));
            update.where(b.equal(routeBuses.get("tid"), ticketId));
            int query = session.createQuery(update).executeUpdate();

            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Ticket> getTicket() {
       Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Ticket");

        return q.getResultList();}

    @Override
    public boolean deleteTicket(int id) {
         Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Ticket p = session.get(Ticket.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } }
    
}
