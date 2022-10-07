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
@Table(name = "star")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Star.findAll", query = "SELECT s FROM Star s"),
    @NamedQuery(name = "Star.findById", query = "SELECT s FROM Star s WHERE s.id = :id"),
    @NamedQuery(name = "Star.findByMark", query = "SELECT s FROM Star s WHERE s.mark = :mark")})
public class Star implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mark")
    private Double mark;
    @JoinColumn(name = "route_bus_id", referencedColumnName = "id")
    @ManyToOne
    private RouteBus routeBusId;

    public Star() {
    }

    public Star(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
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
        if (!(object instanceof Star)) {
            return false;
        }
        Star other = (Star) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Star[ id=" + id + " ]";
    }
    
}
