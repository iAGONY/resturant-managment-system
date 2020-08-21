/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.service;

import com.resturant.managment.system.constant.StatusConstant;
import com.resturant.managment.system.entity.OrderedItem;
import com.resturant.managment.system.entity.Orders;
import com.resturant.managment.system.entity.Payment;
import com.resturant.managment.system.repository.OrderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author suman
 */
@Controller
public class PaymentService {
    
    @Autowired
    OrderRepository orderRepository;
    
    public void perfromPayment(Integer orderId) {
        Optional<Orders> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()) {
            Orders order = optionalOrder.get();
            Payment payment = new Payment();
            order.setPayment(payment);
            order.setStatus(StatusConstant.PAID);
            payment.setTotalPrice(order.getOrderedItems().stream().map(OrderedItem::getPrice).reduce(0.0D, Double::sum));
            orderRepository.save(order);
        }
    }
    
}
