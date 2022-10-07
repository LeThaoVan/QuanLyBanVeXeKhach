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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "type_of_bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeOfBus.findAll", query = "SELECT t FROM TypeOfBus t"),
    @NamedQuery(name = "TypeOfBus.findById", query = "SELECT t FROM TypeOfBus t WHERE t.id = :id"),
    @NamedQuery(name = "TypeOfBus.findByContext", query = "SELECT t FROM TypeOfBus t WHERE t.context = :context"),
    @NamedQuery(name = "TypeOfBus.findByCarBrand", query = "SELECT t FROM TypeOfBus t WHERE t.carBrand = :carBrand"),
    @NamedQuery(name = "TypeOfBus.findByChair", query = "SELECT t FROM TypeOfBus t WHERE t.chair = :chair")})
public class TypeOfBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "context")
    private String context;
    @Size(max = 45)
    @Column(name = "car_brand")
    private String carBrand;
    @Size(max = 45)
    @Column(name = "chair")
    private String chair;
    @OneToMany(mappedBy = "typeOfBusId")
    private Collection<Buses> busesCollection;

    public TypeOfBus() {
    }

    public TypeOfBus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    @XmlTransient
    public Collection<Buses> getBusesCollection() {
        return busesCollection;
    }

    public void setBusesCollection(Collection<Buses> busesCollection) {
        this.busesCollection = busesCollection;
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
        if (!(object instanceof TypeOfBus)) {
            return false;
        }
        TypeOfBus other = (TypeOfBus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.TypeOfBus[ id=" + id + " ]";
    }
    
}
