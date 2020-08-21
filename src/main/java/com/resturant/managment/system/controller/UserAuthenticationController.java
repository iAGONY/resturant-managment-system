/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.controller;

import com.resturant.managment.system.dto.LoginDto;
import com.resturant.managment.system.service.UserAuthenticationService;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suman
 */
@RestController
public class UserAuthenticationController {
    
    @Autowired
    UserAuthenticationService userAuthenticationService;

//    @PostMapping("/save")
//    public int saveUser(@RequestBody UserLogin user) {
//        userAuthenticationService.saveUser(user);
//        return user.getId();
//    }

    @PermitAll
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody LoginDto loginDto) {
        return userAuthenticationService.authenticate(loginDto);
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

}
