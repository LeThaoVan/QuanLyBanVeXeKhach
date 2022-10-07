/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "route_bus_departure_time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteBusDepartureTime.findAll", query = "SELECT r FROM RouteBusDepartureTime r"),
    @NamedQuery(name = "RouteBusDepartureTime.findById", query = "SELECT r FROM RouteBusDepartureTime r WHERE r.id = :id")})
public class RouteBusDepartureTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "routeBusDepartureTimeId")
    private Collection<Ticket> ticketCollection;
    @JoinColumn(name = "departure_time_id", referencedColumnName = "id")
    @ManyToOne
    private DepartureTime departureTimeId;
    @JoinColumn(name = "route_bus_id", referencedColumnName = "id")
    @ManyToOne
    private RouteBus routeBusId;

    public RouteBusDepartureTime() {
    }

    public RouteBusDepartureTime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public DepartureTime getDepartureTimeId() {
        return departureTimeId;
    }

    public void setDepartureTimeId(DepartureTime departureTimeId) {
        this.departureTimeId = departureTimeId;
    }

    public RouteBus getRouteBusId() {
        return routeBusId;
    }

    public void setRouteBusId(RouteBus routeBusId) {
        this.routeBusId = routeBusId;
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
        if (!(object instanceof RouteBusDepartureTime)) {
            return false;
        }
        RouteBusDepartureTime other = (RouteBusDepartureTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.RouteBusDepartureTime[ id=" + id + " ]";
    }
    
}
