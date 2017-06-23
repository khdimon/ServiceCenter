package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.entity.Order;

import java.util.List;

public interface OrderService {
   void addOrder(Order order);

    void updateOrder(Order order);

    Order getOrderById(Long orderId) ;

    List<Order> getAllOrders() ;

   void deleteOrder(Order order) ;
}
