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
@Table(name = "route_bus_station")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteBusStation.findAll", query = "SELECT r FROM RouteBusStation r"),
    @NamedQuery(name = "RouteBusStation.findById", query = "SELECT r FROM RouteBusStation r WHERE r.id = :id"),
    @NamedQuery(name = "RouteBusStation.findByPrice", query = "SELECT r FROM RouteBusStation r WHERE r.price = :price")})
public class RouteBusStation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "price")
    private Integer price;
    @JoinColumn(name = "route_bus_id", referencedColumnName = "id")
    @ManyToOne
    private RouteBus routeBusId;
    @JoinColumn(name = "route_station_id", referencedColumnName = "id")
    @ManyToOne
    private RouteStation routeStationId;
    @OneToMany(mappedBy = "routeBusStationId")
    private Collection<Ticket> ticketCollection;

    public RouteBusStation() {
    }

    public RouteBusStation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public RouteBus getRouteBusId() {
        return routeBusId;
    }

    public void setRouteBusId(RouteBus routeBusId) {
        this.routeBusId = routeBusId;
    }

    public RouteStation getRouteStationId() {
        return routeStationId;
    }

    public void setRouteStationId(RouteStation routeStationId) {
        this.routeStationId = routeStationId;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
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
        if (!(object instanceof RouteBusStation)) {
            return false;
        }
        RouteBusStation other = (RouteBusStation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.RouteBusStation[ id=" + id + " ]";
    }
    
}
