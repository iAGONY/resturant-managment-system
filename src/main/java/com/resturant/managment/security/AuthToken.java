/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.security;

import javax.annotation.PostConstruct;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author suman
 */
@RequestScope
public class AuthToken {
    
    
    @PostConstruct
    public void init() {
        
    }
    
}
