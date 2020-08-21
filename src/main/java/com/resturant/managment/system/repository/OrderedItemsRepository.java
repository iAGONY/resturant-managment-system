/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.repository;

import com.resturant.managment.system.constant.StatusConstant;
import com.resturant.managment.system.entity.OrderedItem;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suman
 */
@Repository
public interface OrderedItemsRepository extends CrudRepository<OrderedItem, Integer> {
    
    @Query("SELECT SUM(oi.price) from OrderedItem oi WHERE oi.order.requestedDate = ?1 AND oi.order.status = ?2")
    public Long totalPendingAmount(Date date, StatusConstant status);
    

}
