package com.softserve.edu.servicecenter.dao;

import com.softserve.edu.servicecenter.entity.Order;

public class OrderDAO extends ElementDAOImpl<Order> {
    public OrderDAO() {
        super(Order.class);
    }
}
