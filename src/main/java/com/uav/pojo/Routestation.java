/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "routestation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routestation.findAll", query = "SELECT r FROM Routestation r"),
    @NamedQuery(name = "Routestation.findById", query = "SELECT r FROM Routestation r WHERE r.id = :id"),
    @NamedQuery(name = "Routestation.findByState", query = "SELECT r FROM Routestation r WHERE r.state = :state")})
public class Routestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "state")
    private Short state;
    @JoinColumn(name = "route_id", referencedColumnName = "rid")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "idTram", referencedColumnName = "idtram")
    @ManyToOne(optional = false)
    private Tram idTram;

    public Routestation() {
    }

    public Routestation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Tram getIdTram() {
        return idTram;
    }

    public void setIdTram(Tram idTram) {
        this.idTram = idTram;
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
        if (!(object instanceof Routestation)) {
            return false;
        }
        Routestation other = (Routestation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Routestation[ id=" + id + " ]";
    }
    
}
