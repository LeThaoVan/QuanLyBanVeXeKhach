/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
    @NamedQuery(name = "Ticket.findByAmount", query = "SELECT t FROM Ticket t WHERE t.amount = :amount"),
    @NamedQuery(name = "Ticket.findByTotal", query = "SELECT t FROM Ticket t WHERE t.total = :total"),
    @NamedQuery(name = "Ticket.findByPayStatus", query = "SELECT t FROM Ticket t WHERE t.payStatus = :payStatus"),
    @NamedQuery(name = "Ticket.findByCreateAt", query = "SELECT t FROM Ticket t WHERE t.createAt = :createAt")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "total")
    private Integer total;
    @Column(name = "pay_status")
    private Short payStatus;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @JoinColumn(name = "route_bus_departure_time_id", referencedColumnName = "id")
    @ManyToOne
    private RouteBusDepartureTime routeBusDepartureTimeId;
    @JoinColumn(name = "route_bus_station_id", referencedColumnName = "id")
    @ManyToOne
    private RouteBusStation routeBusStationId;
    @JoinColumn(name = "pickup_station_id", referencedColumnName = "id")
    @ManyToOne
    private Station pickupStationId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @OneToMany(mappedBy = "ticketId")
    private Collection<TicketChair> ticketChairCollection;
    @OneToMany(mappedBy = "ticketId")
    private Collection<DiscountTicket> discountTicketCollection;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public RouteBusDepartureTime getRouteBusDepartureTimeId() {
        return routeBusDepartureTimeId;
    }

    public void setRouteBusDepartureTimeId(RouteBusDepartureTime routeBusDepartureTimeId) {
        this.routeBusDepartureTimeId = routeBusDepartureTimeId;
    }

    public RouteBusStation getRouteBusStationId() {
        return routeBusStationId;
    }

    public void setRouteBusStationId(RouteBusStation routeBusStationId) {
        this.routeBusStationId = routeBusStationId;
    }

    public Station getPickupStationId() {
        return pickupStationId;
    }

    public void setPickupStationId(Station pickupStationId) {
        this.pickupStationId = pickupStationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<TicketChair> getTicketChairCollection() {
        return ticketChairCollection;
    }

    public void setTicketChairCollection(Collection<TicketChair> ticketChairCollection) {
        this.ticketChairCollection = ticketChairCollection;
    }

    @XmlTransient
    public Collection<DiscountTicket> getDiscountTicketCollection() {
        return discountTicketCollection;
    }

    public void setDiscountTicketCollection(Collection<DiscountTicket> discountTicketCollection) {
        this.discountTicketCollection = discountTicketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Ticket[ id=" + id + " ]";
    }
    
}
