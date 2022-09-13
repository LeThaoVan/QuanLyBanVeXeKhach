/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Route.findByRid", query = "SELECT r FROM Route r WHERE r.rid = :rid"),
    @NamedQuery(name = "Route.findByRoutename", query = "SELECT r FROM Route r WHERE r.routename = :routename"),
    @NamedQuery(name = "Route.findByCreatedatetime", query = "SELECT r FROM Route r WHERE r.createdatetime = :createdatetime"),
    @NamedQuery(name = "Route.findByImage", query = "SELECT r FROM Route r WHERE r.image = :image")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rid")
    private Integer rid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "routename")
    private String routename;
    @Column(name = "createdatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdatetime;
    @Size(max = 500)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<Routestation> routestationCollection;
    @JoinColumn(name = "destination", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Province destination;
    @JoinColumn(name = "startingpoint", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Province startingpoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<Routebuses> routebusesCollection;

    public Route() {
    }

    public Route(Integer rid) {
        this.rid = rid;
    }

    public Route(Integer rid, String routename) {
        this.rid = rid;
        this.routename = routename;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Routestation> getRoutestationCollection() {
        return routestationCollection;
    }

    public void setRoutestationCollection(Collection<Routestation> routestationCollection) {
        this.routestationCollection = routestationCollection;
    }

    public Province getDestination() {
        return destination;
    }

    public void setDestination(Province destination) {
        this.destination = destination;
    }

    public Province getStartingpoint() {
        return startingpoint;
    }

    public void setStartingpoint(Province startingpoint) {
        this.startingpoint = startingpoint;
    }

    @XmlTransient
    public Collection<Routebuses> getRoutebusesCollection() {
        return routebusesCollection;
    }

    public void setRoutebusesCollection(Collection<Routebuses> routebusesCollection) {
        this.routebusesCollection = routebusesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Route[ rid=" + rid + " ]";
    }
    
}
