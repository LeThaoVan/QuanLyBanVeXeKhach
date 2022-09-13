/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "plxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plxe.findAll", query = "SELECT p FROM Plxe p"),
    @NamedQuery(name = "Plxe.findByLid", query = "SELECT p FROM Plxe p WHERE p.lid = :lid"),
    @NamedQuery(name = "Plxe.findByLoaiXe", query = "SELECT p FROM Plxe p WHERE p.loaiXe = :loaiXe"),
    @NamedQuery(name = "Plxe.findBySoGhe", query = "SELECT p FROM Plxe p WHERE p.soGhe = :soGhe"),
    @NamedQuery(name = "Plxe.findByHangXe", query = "SELECT p FROM Plxe p WHERE p.hangXe = :hangXe")})
public class Plxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "lid")
    private Integer lid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LoaiXe")
    private String loaiXe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoGhe")
    private int soGhe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "HangXe")
    private String hangXe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaixeID")
    private Collection<Buses> busesCollection;

    public Plxe() {
    }

    public Plxe(Integer lid) {
        this.lid = lid;
    }

    public Plxe(Integer lid, String loaiXe, int soGhe, String hangXe) {
        this.lid = lid;
        this.loaiXe = loaiXe;
        this.soGhe = soGhe;
        this.hangXe = hangXe;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
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
        hash += (lid != null ? lid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plxe)) {
            return false;
        }
        Plxe other = (Plxe) object;
        if ((this.lid == null && other.lid != null) || (this.lid != null && !this.lid.equals(other.lid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Plxe[ lid=" + lid + " ]";
    }
    
}
