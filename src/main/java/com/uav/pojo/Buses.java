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
@Table(name = "buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b"),
    @NamedQuery(name = "Buses.findByBid", query = "SELECT b FROM Buses b WHERE b.bid = :bid"),
    @NamedQuery(name = "Buses.findByBusesName", query = "SELECT b FROM Buses b WHERE b.busesName = :busesName"),
    @NamedQuery(name = "Buses.findByDriverID", query = "SELECT b FROM Buses b WHERE b.driverID = :driverID"),
    @NamedQuery(name = "Buses.findByBstatus", query = "SELECT b FROM Buses b WHERE b.bstatus = :bstatus"),
    @NamedQuery(name = "Buses.findByImage", query = "SELECT b FROM Buses b WHERE b.image = :image"),
    @NamedQuery(name = "Buses.findByCreatedatetime", query = "SELECT b FROM Buses b WHERE b.createdatetime = :createdatetime")})
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid")
    private Integer bid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "BusesName")
    private String busesName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "driverID")
    private int driverID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Bstatus")
    private boolean bstatus;
    @Size(max = 500)
    @Column(name = "image")
    private String image;
    @Column(name = "createdatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdatetime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busesId")
    @JsonIgnore
    private Collection<Ticket> ticketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busesId")
    @JsonIgnore
    private Collection<Busesstatus> busesstatusCollection;
    @JoinColumn(name = "loaixeID", referencedColumnName = "lid")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Plxe loaixeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busesId")
    @JsonIgnore
    private Collection<Routebuses> routebusesCollection;

    public Buses() {
    }

    public Buses(Integer bid) {
        this.bid = bid;
    }

    public Buses(Integer bid, String busesName, int driverID, boolean bstatus) {
        this.bid = bid;
        this.busesName = busesName;
        this.driverID = driverID;
        this.bstatus = bstatus;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBusesName() {
        return busesName;
    }

    public void setBusesName(String busesName) {
        this.busesName = busesName;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public boolean getBstatus() {
        return bstatus;
    }

    public void setBstatus(boolean bstatus) {
        this.bstatus = bstatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }


    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @XmlTransient
    public Collection<Busesstatus> getBusesstatusCollection() {
        return busesstatusCollection;
    }

    public void setBusesstatusCollection(Collection<Busesstatus> busesstatusCollection) {
        this.busesstatusCollection = busesstatusCollection;
    }

    public Plxe getLoaixeID() {
        return loaixeID;
    }

    public void setLoaixeID(Plxe loaixeID) {
        this.loaixeID = loaixeID;
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
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Buses[ bid=" + bid + " ]";
    }
    
}
