/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.service;

import com.resturant.managment.system.entity.UserLogin;
import com.resturant.managment.system.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author suman
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserLogin loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserLogin> findByUsername = userRepository.findByUsername(username);
        return findByUsername.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
