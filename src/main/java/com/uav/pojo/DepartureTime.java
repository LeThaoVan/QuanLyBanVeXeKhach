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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "departure_time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartureTime.findAll", query = "SELECT d FROM DepartureTime d"),
    @NamedQuery(name = "DepartureTime.findById", query = "SELECT d FROM DepartureTime d WHERE d.id = :id"),
    @NamedQuery(name = "DepartureTime.findByDepartureDate", query = "SELECT d FROM DepartureTime d WHERE d.departureDate = :departureDate")})
public class DepartureTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @OneToMany(mappedBy = "departureTimeId")
    private Collection<RouteBusDepartureTime> routeBusDepartureTimeCollection;
    @JoinColumn(name = "time_slot_id", referencedColumnName = "id")
    @ManyToOne
    private TimeSlot timeSlotId;

    public DepartureTime() {
    }

    public DepartureTime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @XmlTransient
    public Collection<RouteBusDepartureTime> getRouteBusDepartureTimeCollection() {
        return routeBusDepartureTimeCollection;
    }

    public void setRouteBusDepartureTimeCollection(Collection<RouteBusDepartureTime> routeBusDepartureTimeCollection) {
        this.routeBusDepartureTimeCollection = routeBusDepartureTimeCollection;
    }

    public TimeSlot getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(TimeSlot timeSlotId) {
        this.timeSlotId = timeSlotId;
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
        if (!(object instanceof DepartureTime)) {
            return false;
        }
        DepartureTime other = (DepartureTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.DepartureTime[ id=" + id + " ]";
    }
    
}
