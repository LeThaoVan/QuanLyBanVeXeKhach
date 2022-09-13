/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "routebuses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routebuses.findAll", query = "SELECT r FROM Routebuses r"),
    @NamedQuery(name = "Routebuses.findByRbid", query = "SELECT r FROM Routebuses r WHERE r.rbid = :rbid"),
    @NamedQuery(name = "Routebuses.findByNgaydi", query = "SELECT r FROM Routebuses r WHERE r.ngaydi = :ngaydi"),
    @NamedQuery(name = "Routebuses.findByGiodi", query = "SELECT r FROM Routebuses r WHERE r.giodi = :giodi"),
    @NamedQuery(name = "Routebuses.findByPrice", query = "SELECT r FROM Routebuses r WHERE r.price = :price"),
    @NamedQuery(name = "Routebuses.findBySoghe", query = "SELECT r FROM Routebuses r WHERE r.soghe = :soghe")})
public class Routebuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rbid")
    private Integer rbid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ngaydi")
    private String ngaydi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "giodi")
    private String giodi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Column(name = "soghe")
    private Integer soghe;
    @JoinColumn(name = "buses_id", referencedColumnName = "bid")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Buses busesId;
    @JoinColumn(name = "route_id", referencedColumnName = "rid")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Route routeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bid")
    @JsonIgnore
    private Collection<Comment> commentCollection;

    public Routebuses() {
    }

    public Routebuses(Integer rbid) {
        this.rbid = rbid;
    }

    public Routebuses(Integer rbid, String ngaydi, String giodi, int price) {
        this.rbid = rbid;
        this.ngaydi = ngaydi;
        this.giodi = giodi;
        this.price = price;
    }

    public Integer getRbid() {
        return rbid;
    }

    public void setRbid(Integer rbid) {
        this.rbid = rbid;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getGiodi() {
        return giodi;
    }

    public void setGiodi(String giodi) {
        this.giodi = giodi;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getSoghe() {
        return soghe;
    }

    public void setSoghe(Integer soghe) {
        this.soghe = soghe;
    }

    public Buses getBusesId() {
        return busesId;
    }

    public void setBusesId(Buses busesId) {
        this.busesId = busesId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rbid != null ? rbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routebuses)) {
            return false;
        }
        Routebuses other = (Routebuses) object;
        if ((this.rbid == null && other.rbid != null) || (this.rbid != null && !this.rbid.equals(other.rbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Routebuses[ rbid=" + rbid + " ]";
    }
    
}
