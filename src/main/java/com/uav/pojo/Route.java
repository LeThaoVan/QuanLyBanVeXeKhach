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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id"),
    @NamedQuery(name = "Route.findByName", query = "SELECT r FROM Route r WHERE r.name = :name"),
    @NamedQuery(name = "Route.findByStartProvince", query = "SELECT r FROM Route r WHERE r.startProvince = :startProvince"),
    @NamedQuery(name = "Route.findByDestination", query = "SELECT r FROM Route r WHERE r.destination = :destination"),
    @NamedQuery(name = "Route.findByCreateAt", query = "SELECT r FROM Route r WHERE r.createAt = :createAt"),
    @NamedQuery(name = "Route.findByImage", query = "SELECT r FROM Route r WHERE r.image = :image")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "start_province")
    private Integer startProvince;
    @Column(name = "destination")
    private Integer destination;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "routeId")
    private Collection<RouteBus> routeBusCollection;
    @OneToMany(mappedBy = "routeId")
    private Collection<RouteStation> routeStationCollection;

    public Route() {
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartProvince() {
        return startProvince;
    }

    public void setStartProvince(Integer startProvince) {
        this.startProvince = startProvince;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<RouteBus> getRouteBusCollection() {
        return routeBusCollection;
    }

    public void setRouteBusCollection(Collection<RouteBus> routeBusCollection) {
        this.routeBusCollection = routeBusCollection;
    }

    @XmlTransient
    public Collection<RouteStation> getRouteStationCollection() {
        return routeStationCollection;
    }

    public void setRouteStationCollection(Collection<RouteStation> routeStationCollection) {
        this.routeStationCollection = routeStationCollection;
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
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Route[ id=" + id + " ]";
    }
    
}
