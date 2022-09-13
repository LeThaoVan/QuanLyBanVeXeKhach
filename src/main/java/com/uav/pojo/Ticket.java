/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTid", query = "SELECT t FROM Ticket t WHERE t.tid = :tid"),
    @NamedQuery(name = "Ticket.findByUsername", query = "SELECT t FROM Ticket t WHERE t.username = :username"),
    @NamedQuery(name = "Ticket.findByAmount", query = "SELECT t FROM Ticket t WHERE t.amount = :amount"),
    @NamedQuery(name = "Ticket.findByTotal", query = "SELECT t FROM Ticket t WHERE t.total = :total"),
    @NamedQuery(name = "Ticket.findByTstatusPay", query = "SELECT t FROM Ticket t WHERE t.tstatusPay = :tstatusPay"),
    @NamedQuery(name = "Ticket.findByPickupStationId", query = "SELECT t FROM Ticket t WHERE t.pickupStationId = :pickupStationId"),
    @NamedQuery(name = "Ticket.findByArriveStationId", query = "SELECT t FROM Ticket t WHERE t.arriveStationId = :arriveStationId"),
    @NamedQuery(name = "Ticket.findByCreatedatetime", query = "SELECT t FROM Ticket t WHERE t.createdatetime = :createdatetime"),
    @NamedQuery(name = "Ticket.findByEmail", query = "SELECT t FROM Ticket t WHERE t.email = :email"),
    @NamedQuery(name = "Ticket.findBySdt", query = "SELECT t FROM Ticket t WHERE t.sdt = :sdt"),
    @NamedQuery(name = "Ticket.findByCusName", query = "SELECT t FROM Ticket t WHERE t.cusName = :cusName")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Column(name = "TstatusPay")
    private Short tstatusPay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pickupStationId")
    private int pickupStationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arriveStationId")
    private int arriveStationId;
    @Column(name = "createdatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdatetime;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "sdt")
    private String sdt;
    @Size(max = 45)
    @Column(name = "cusName")
    private String cusName;
    @JoinColumn(name = "busesId", referencedColumnName = "bid")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Buses busesId;
    @JoinColumn(name = "userId", referencedColumnName = "userid")
    @ManyToOne
    @JsonIgnore
    private Users userId;

    public Ticket() {
    }

    public Ticket(Integer tid) {
        this.tid = tid;
    }

    public Ticket(Integer tid, int amount, int total, int pickupStationId, int arriveStationId) {
        this.tid = tid;
        this.amount = amount;
        this.total = total;
        this.pickupStationId = pickupStationId;
        this.arriveStationId = arriveStationId;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Short getTstatusPay() {
        return tstatusPay;
    }

    public void setTstatusPay(Short tstatusPay) {
        this.tstatusPay = tstatusPay;
    }

    public int getPickupStationId() {
        return pickupStationId;
    }

    public void setPickupStationId(int pickupStationId) {
        this.pickupStationId = pickupStationId;
    }

    public int getArriveStationId() {
        return arriveStationId;
    }

    public void setArriveStationId(int arriveStationId) {
        this.arriveStationId = arriveStationId;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Buses getBusesId() {
        return busesId;
    }

    public void setBusesId(Buses busesId) {
        this.busesId = busesId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Ticket[ tid=" + tid + " ]";
    }
    
}
