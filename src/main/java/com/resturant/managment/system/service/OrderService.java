/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resturant.managment.system.service;

import com.resturant.managment.system.constant.StatusConstant;
import com.resturant.managment.system.dto.OrderDto;
import com.resturant.managment.system.dto.OrderedItemDto;
import com.resturant.managment.system.entity.Orders;
import com.resturant.managment.system.entity.OrderedItem;
import com.resturant.managment.system.entity.UserLogin;
import com.resturant.managment.system.repository.OrderRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author suman
 */
@Controller
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void create(OrderDto orderDto) {
        Orders order = new Orders();
        List<OrderedItem> orderedItems = new ArrayList<>();
        order.setOrderedItems(orderedItems);
        setOrder(orderDto, order);
        setOrderItems(orderDto.getItems(), orderedItems, order);
        orderRepository.save(order);
    }

    private void setOrder(OrderDto orderDto, Orders order) {
        order.setOrderName(orderDto.getOrderName());
        order.setOrderRecievedBy(getLoggedInUser());
        order.setRequestedDate(new Date());
        order.setStatus(StatusConstant.OREDER_RECEIVED);
    }

    private void setOrderItems(List<OrderedItemDto> orderedItemDtos, List<OrderedItem> orderedItems, Orders order) {
        orderedItemDtos.forEach(item -> {
            OrderedItem orderedItem = new OrderedItem();
            orderedItem.setItemName(item.getItemName());
            orderedItem.setPrice(item.getPrice());
            orderedItem.setIsActive(true);
            orderedItem.setOrder(order);
            orderedItems.add(orderedItem);
        });
    }

    private UserLogin getLoggedInUser() {
        UserLogin userLogin = new UserLogin();
        userLogin.setId(1);
        return userLogin;
    }

    public List<OrderDto> getAll() {
        Iterable<Orders> findAll = orderRepository.findAll();
        return StreamSupport
                .stream(findAll.spliterator(), false)
//                .filter(e -> Objects.equals(e.getOrderRecievedBy().getId(), getLoggedInUser().getId()))
                .map((Orders e) -> {
                    OrderDto orderDto = new OrderDto();
                    List<OrderedItemDto> orderedItemDtos = new ArrayList<>();
                    orderDto.setId(e.getId());
                    orderDto.setOrderName(e.getOrderName());
                    orderDto.setStatus(e.getStatus().name());
                    orderDto.setOrderedDate(e.getRequestedDate());
                    orderDto.setItems(orderedItemDtos);
                    e.getOrderedItems().forEach(item -> {
                        OrderedItemDto orderedItemDto = new OrderedItemDto();
                        orderedItemDto.setId(item.getId());
                        orderedItemDto.setItemName(item.getItemName());
                        orderedItemDto.setPrice(item.getPrice());
                        orderedItemDtos.add(orderedItemDto);
                    });
                    return orderDto;
                })
                .collect(Collectors.toList());
    }

}
