/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.repository;

import com.resturant.managment.system.entity.Orders;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author suman
 */
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    
}
