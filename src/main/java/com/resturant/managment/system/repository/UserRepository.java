/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.repository;

import com.resturant.managment.system.entity.UserLogin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sumanCustomUserRepository
 */
public interface UserRepository extends CrudRepository<UserLogin, Integer>,CustomUserRepository<UserLogin, String> {
    
}
