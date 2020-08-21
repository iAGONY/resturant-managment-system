/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.controller;

import com.resturant.managment.system.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suman
 */
@RestController
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;
    
    @PostMapping("/perfomPayment/{orderId}")
    public void perfomPayment(@PathVariable("orderId") Integer orderId) {
        paymentService.perfromPayment(orderId);
    }
}
