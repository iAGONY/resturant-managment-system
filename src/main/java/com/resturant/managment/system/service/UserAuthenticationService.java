/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.service;

import com.resturant.managment.system.entity.UserLogin;
import com.resturant.managment.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author suman
 */
@Service
public class UserAuthenticationService implements UserDetailsService {
    
    @Autowired
    UserRepository userRepository;
    
    public void saveUser(UserLogin user) {
        System.out.println("==>>" + user.getUsername() + " " + user.getPassword());
        userRepository.save(user);
    }

    @Override
    public UserLogin loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin findByUsername = userRepository.findByUsername(username);
        if (findByUsername == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return findByUsername;
    }
    
}
