/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.entity;

import com.resturant.managment.system.constant.StatusConstant;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author suman
 */
@Table(name = "ORDERS")
@Entity
public class Orders implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ORDER_NAME", nullable = false)
    private String orderName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private StatusConstant status;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "REQUESTED_DATE")
    private Date requestedDate;
    
    @JoinColumn(name = "USER_LOGIN", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserLogin orderRecievedBy;
    
    @JoinColumn(name = "PAYMENT")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderedItem> orderedItems;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public List<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public StatusConstant getStatus() {
        return status;
    }

    public void setStatus(StatusConstant status) {
        this.status = status;
    }

    public UserLogin getOrderRecievedBy() {
        return orderRecievedBy;
    }

    public void setOrderRecievedBy(UserLogin orderRecievedBy) {
        this.orderRecievedBy = orderRecievedBy;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
    
}
