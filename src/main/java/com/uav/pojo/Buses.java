/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b"),
    @NamedQuery(name = "Buses.findById", query = "SELECT b FROM Buses b WHERE b.id = :id"),
    @NamedQuery(name = "Buses.findByName", query = "SELECT b FROM Buses b WHERE b.name = :name"),
    @NamedQuery(name = "Buses.findByImage", query = "SELECT b FROM Buses b WHERE b.image = :image"),
    @NamedQuery(name = "Buses.findByActive", query = "SELECT b FROM Buses b WHERE b.active = :active"),
    @NamedQuery(name = "Buses.findByCreateAt", query = "SELECT b FROM Buses b WHERE b.createAt = :createAt")})
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @Column(name = "active")
    private Short active;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @OneToMany(mappedBy = "busId")
    @JsonIgnore
    private Collection<RouteBus> routeBusCollection;
    @JoinColumn(name = "garage_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Garage garageId;
    @JoinColumn(name = "type_of_bus_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private TypeOfBus typeOfBusId;
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User driverId;

    public Buses() {
    }

    public Buses(Integer id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @XmlTransient
    public Collection<RouteBus> getRouteBusCollection() {
        return routeBusCollection;
    }

    public void setRouteBusCollection(Collection<RouteBus> routeBusCollection) {
        this.routeBusCollection = routeBusCollection;
    }

    public Garage getGarageId() {
        return garageId;
    }

    public void setGarageId(Garage garageId) {
        this.garageId = garageId;
    }

    public TypeOfBus getTypeOfBusId() {
        return typeOfBusId;
    }

    public void setTypeOfBusId(TypeOfBus typeOfBusId) {
        this.typeOfBusId = typeOfBusId;
    }

    public User getDriverId() {
        return driverId;
    }

    public void setDriverId(User driverId) {
        this.driverId = driverId;
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
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Buses[ id=" + id + " ]";
    }
    
}
