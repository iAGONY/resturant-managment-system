///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.resturant.managment.security;
//
//import com.resturant.managment.system.entity.UserLogin;
//import com.resturant.managment.system.service.UserAuthenticationService;
//import java.io.IOException;
//import java.security.Key;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.jose4j.jwt.JwtClaims;
//import org.jose4j.jwt.consumer.InvalidJwtException;
//import org.jose4j.jwt.consumer.JwtConsumer;
//import org.jose4j.jwt.consumer.JwtConsumerBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
///**
// *
// * @author suman
// */
//@Component
//public class JwtTokenFilter extends OncePerRequestFilter {
//
//    @Autowired
//    UserAuthenticationService authenticationService;
//
//    protected JwtClaims jwtClaims;
//    protected boolean isAuthenicated;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        this.setIsAuthenicated(false);
//        String token = request.getHeader("Authorization");
//        Key key = jwtKeyProvider.getKey();
//        Key key2 = jwtKeyProvider.getKey2();
//        if (null != key && token != null && !token.isEmpty()) {
//
//            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
//                    .setRequireExpirationTime()
//                    .setAllowedClockSkewInSeconds(30)
//                    .setExpectedIssuer("RMS")
//                    .setExpectedAudience("UserLogin")
//                    .setExpectedSubject("Authentication")
//                    .setDecryptionKey(key2)
//                    .setVerificationKey(key)
//                    .setRelaxVerificationKeyValidation()
//                    .setRelaxDecryptionKeyValidation()
//                    .build();
//
//            try {
//                this.jwtClaims = jwtConsumer.processToClaims(token);
//                this.setIsAuthenicated(true);
//            } catch (InvalidJwtException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        UserLogin userLogin = authenticationService.loadUserByUsername("admin");
//        if (isAuthenicated) {
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                    userLogin, null, userLogin.getAuthorities());
//            usernamePasswordAuthenticationToken
//                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        }
//        
//        chain.doFilter(request, response);
//    }
//
//    private void setIsAuthenicated(boolean isAuthenicated) {
//        this.isAuthenicated = isAuthenicated;
//    }
//
//}
