/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.repository;

import com.resturant.managment.system.entity.UserLogin;

/**
 *
 * @author suman
 */
public interface CustomUserRepository<T,S> {

    public UserLogin findByUsername(String username);
    
}
