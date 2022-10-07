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
@Table(name = "route_bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteBus.findAll", query = "SELECT r FROM RouteBus r"),
    @NamedQuery(name = "RouteBus.findById", query = "SELECT r FROM RouteBus r WHERE r.id = :id")})
public class RouteBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "routeBusId")
    private Collection<RouteBusStation> routeBusStationCollection;
    @OneToMany(mappedBy = "routeBusId")
    private Collection<Star> starCollection;
    @OneToMany(mappedBy = "routeBusId")
    private Collection<RouteBusDepartureTime> routeBusDepartureTimeCollection;
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    @ManyToOne
    private Buses busId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne
    private Route routeId;
    @OneToMany(mappedBy = "routeBusId")
    private Collection<Comment> commentCollection;

    public RouteBus() {
    }

    public RouteBus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<RouteBusStation> getRouteBusStationCollection() {
        return routeBusStationCollection;
    }

    public void setRouteBusStationCollection(Collection<RouteBusStation> routeBusStationCollection) {
        this.routeBusStationCollection = routeBusStationCollection;
    }

    @XmlTransient
    public Collection<Star> getStarCollection() {
        return starCollection;
    }

    public void setStarCollection(Collection<Star> starCollection) {
        this.starCollection = starCollection;
    }

    @XmlTransient
    public Collection<RouteBusDepartureTime> getRouteBusDepartureTimeCollection() {
        return routeBusDepartureTimeCollection;
    }

    public void setRouteBusDepartureTimeCollection(Collection<RouteBusDepartureTime> routeBusDepartureTimeCollection) {
        this.routeBusDepartureTimeCollection = routeBusDepartureTimeCollection;
    }

    public Buses getBusId() {
        return busId;
    }

    public void setBusId(Buses busId) {
        this.busId = busId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
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
        if (!(object instanceof RouteBus)) {
            return false;
        }
        RouteBus other = (RouteBus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.RouteBus[ id=" + id + " ]";
    }
    
}
