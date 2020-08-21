/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.controller;

import com.resturant.managment.system.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suman
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    
    @Autowired
    DashboardService dashboardService;
    @GetMapping("/data")
    public ResponseEntity<?> counts() {
        return ResponseEntity.ok(dashboardService.getCounts());
    }
    
    
}
