/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.service;

import com.resturant.managment.security.JwtToken;
import com.resturant.managment.system.dto.LoginDto;
import com.resturant.managment.system.entity.UserLogin;
import com.resturant.managment.system.repository.UserRepository;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author suman
 */
@Service
public class UserAuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public void saveUser(UserLogin user) {
        userRepository.save(user);
    }

    public ResponseEntity authenticate(LoginDto loginDto) {
        UserLogin userLogin = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        try {
            Authentication auth = authenticationManager.authenticate(authReq);
            if (auth.isAuthenticated()) {
                String token = JwtToken.getToken(userLogin);
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("Authorization", token);
                return ResponseEntity.ok()
                        .headers(responseHeaders).build();
            }
        } catch (BadCredentialsException | JoseException ex) {
            ex.printStackTrace();
            //throw exception
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username/password");
    }

}
