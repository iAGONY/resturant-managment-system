/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.security;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Arrays;
import static jdk.nashorn.internal.objects.NativeObject.keys;
import org.jose4j.keys.HmacKey;
import org.springframework.stereotype.Component;

/**
 *
 * @author suman
 */
@Component
public class JwtKeyProvider {
    
    String keys = "Fdh9u8rINxfivbrianbbasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfsVT1u232VhQBZYKx1HG";
    
    public Key getKey() {
        HmacKey key;
        try {
            key = new HmacKey(keys.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
//            logger.log(Level.SEVERE, "Couldn't Create Key");
            return null;
        }
        return key;
    }

    public Key getKey2() {
        HmacKey key;
        try {
            key = new HmacKey(Arrays.copyOf(keys.getBytes("UTF-8"),32));
        } catch (UnsupportedEncodingException ex) {
//            logger.log(Level.SEVERE, "Couldn't Create Key");
            return null;
        }
        return key;
    }

    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
