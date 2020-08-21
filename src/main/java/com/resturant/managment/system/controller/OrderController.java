/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.controller;

import com.resturant.managment.system.dto.OrderDto;
import com.resturant.managment.system.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suman
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @PostMapping("/create")
    public void create(@RequestBody OrderDto orderDto) {
        orderService.create(orderDto);
    }
    
    @GetMapping("/getAll")
    public List<OrderDto> getAll() {
       return orderService.getAll();
    }
    
}
