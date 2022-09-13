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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tram.findAll", query = "SELECT t FROM Tram t"),
    @NamedQuery(name = "Tram.findByIdtram", query = "SELECT t FROM Tram t WHERE t.idtram = :idtram"),
    @NamedQuery(name = "Tram.findByTenTram", query = "SELECT t FROM Tram t WHERE t.tenTram = :tenTram"),
    @NamedQuery(name = "Tram.findByWardId", query = "SELECT t FROM Tram t WHERE t.wardId = :wardId")})
public class Tram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtram")
    private Integer idtram;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenTram")
    private String tenTram;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ward_id")
    private int wardId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTram")
    private Collection<Routestation> routestationCollection;

    public Tram() {
    }

    public Tram(Integer idtram) {
        this.idtram = idtram;
    }

    public Tram(Integer idtram, String tenTram, int wardId) {
        this.idtram = idtram;
        this.tenTram = tenTram;
        this.wardId = wardId;
    }

    public Integer getIdtram() {
        return idtram;
    }

    public void setIdtram(Integer idtram) {
        this.idtram = idtram;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    @XmlTransient
    public Collection<Routestation> getRoutestationCollection() {
        return routestationCollection;
    }

    public void setRoutestationCollection(Collection<Routestation> routestationCollection) {
        this.routestationCollection = routestationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtram != null ? idtram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tram)) {
            return false;
        }
        Tram other = (Tram) object;
        if ((this.idtram == null && other.idtram != null) || (this.idtram != null && !this.idtram.equals(other.idtram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Tram[ idtram=" + idtram + " ]";
    }
    
}
