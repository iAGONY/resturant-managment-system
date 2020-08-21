/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.controller;

import com.resturant.managment.system.entity.UserLogin;
import com.resturant.managment.system.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suman
 */
@RestController
public class UserAuthenticationController {

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @PostMapping("/save")
    public int saveUser(@RequestBody UserLogin user) {
        userAuthenticationService.saveUser(user);
        return user.getId();
    }
    
     @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLogin user) {
       
        return ResponseEntity.ok(user);
    }

}
