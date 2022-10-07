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
@Table(name = "route_station")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteStation.findAll", query = "SELECT r FROM RouteStation r"),
    @NamedQuery(name = "RouteStation.findById", query = "SELECT r FROM RouteStation r WHERE r.id = :id"),
    @NamedQuery(name = "RouteStation.findByTypeOfStation", query = "SELECT r FROM RouteStation r WHERE r.typeOfStation = :typeOfStation")})
public class RouteStation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type_of_station")
    private Short typeOfStation;
    @OneToMany(mappedBy = "routeStationId")
    private Collection<RouteBusStation> routeBusStationCollection;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne
    private Route routeId;
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    @ManyToOne
    private Station stationId;

    public RouteStation() {
    }

    public RouteStation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getTypeOfStation() {
        return typeOfStation;
    }

    public void setTypeOfStation(Short typeOfStation) {
        this.typeOfStation = typeOfStation;
    }

    @XmlTransient
    public Collection<RouteBusStation> getRouteBusStationCollection() {
        return routeBusStationCollection;
    }

    public void setRouteBusStationCollection(Collection<RouteBusStation> routeBusStationCollection) {
        this.routeBusStationCollection = routeBusStationCollection;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Station getStationId() {
        return stationId;
    }

    public void setStationId(Station stationId) {
        this.stationId = stationId;
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
        if (!(object instanceof RouteStation)) {
            return false;
        }
        RouteStation other = (RouteStation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.RouteStation[ id=" + id + " ]";
    }
    
}
