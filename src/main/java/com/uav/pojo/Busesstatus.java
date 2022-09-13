/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "busesstatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Busesstatus.findAll", query = "SELECT b FROM Busesstatus b"),
    @NamedQuery(name = "Busesstatus.findByBsid", query = "SELECT b FROM Busesstatus b WHERE b.bsid = :bsid"),
    @NamedQuery(name = "Busesstatus.findByLeavingtime", query = "SELECT b FROM Busesstatus b WHERE b.leavingtime = :leavingtime")})
public class Busesstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bsid")
    private Integer bsid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "leavingtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leavingtime;
    @JoinColumn(name = "busesId", referencedColumnName = "bid")
    @ManyToOne(optional = false)
    private Buses busesId;
    @JoinColumn(name = "staffconfirm", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private Users staffconfirm;

    public Busesstatus() {
    }

    public Busesstatus(Integer bsid) {
        this.bsid = bsid;
    }

    public Busesstatus(Integer bsid, Date leavingtime) {
        this.bsid = bsid;
        this.leavingtime = leavingtime;
    }

    public Integer getBsid() {
        return bsid;
    }

    public void setBsid(Integer bsid) {
        this.bsid = bsid;
    }

    public Date getLeavingtime() {
        return leavingtime;
    }

    public void setLeavingtime(Date leavingtime) {
        this.leavingtime = leavingtime;
    }

    public Buses getBusesId() {
        return busesId;
    }

    public void setBusesId(Buses busesId) {
        this.busesId = busesId;
    }

    public Users getStaffconfirm() {
        return staffconfirm;
    }

    public void setStaffconfirm(Users staffconfirm) {
        this.staffconfirm = staffconfirm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bsid != null ? bsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Busesstatus)) {
            return false;
        }
        Busesstatus other = (Busesstatus) object;
        if ((this.bsid == null && other.bsid != null) || (this.bsid != null && !this.bsid.equals(other.bsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Busesstatus[ bsid=" + bsid + " ]";
    }
    
}
