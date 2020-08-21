/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.service;

import com.resturant.managment.system.constant.StatusConstant;
import com.resturant.managment.system.entity.OrderedItem;
import com.resturant.managment.system.repository.OrderRepository;
import com.resturant.managment.system.repository.OrderedItemsRepository;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author suman
 */
@Service
public class DashboardService {
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    OrderedItemsRepository orderedItemsRepository;
    
    public Map<String, String> getCounts() {
        Date todayDate = new Date();
        Map<String, String> counts = new HashMap<>();
        counts.put("TODAY_TOTAL_ORDER", String.valueOf(orderRepository.countAll(todayDate)));
        counts.put("TODAY_PAYMENT_PENDING_ORDERS", String.valueOf(orderRepository.countPaymentPendingOrder(todayDate, StatusConstant.OREDER_RECEIVED)));
        counts.put("TODAY_TOTAL_PAID_ADMOUNT", String.valueOf(orderRepository.totalPaidAmount(todayDate)));
        counts.put("TODAY_TOTAL_PAID_ORDER", String.valueOf(orderRepository.totalPaidOrders(todayDate, StatusConstant.PAID)));
        counts.put("TODAY_TOTAL_PENDING_AMOUNT", String.valueOf(orderedItemsRepository.totalPendingAmount(todayDate, StatusConstant.OREDER_RECEIVED)));
        return counts;
    }
    
}
    