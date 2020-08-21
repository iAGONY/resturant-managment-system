/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.repository;

import com.resturant.managment.system.constant.StatusConstant;
import com.resturant.managment.system.entity.Orders;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suman
 */
@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    
    @Query("SELECT COUNT(o) from Orders o WHERE o.requestedDate = ?1")
    public Long countAll(Date date);
    
    @Query("SELECT SUM(o.payment.totalPrice) from Orders o WHERE o.requestedDate = ?1")
    public Long totalPaidAmount(Date date);
    
    @Query("SELECT COUNT(o) from Orders o WHERE o.requestedDate = ?1 AND o.status = ?2")
    public Long countPaymentPendingOrder(Date date, StatusConstant status);
    
    @Query("SELECT COUNT(o) from Orders o WHERE o.requestedDate = ?1 AND o.status = ?2")
    public Long totalPaidOrders(Date date, StatusConstant status);
    
}
