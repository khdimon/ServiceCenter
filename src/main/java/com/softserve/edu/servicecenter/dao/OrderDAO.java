package com.softserve.edu.servicecenter.dao;

import com.softserve.edu.servicecenter.entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO extends ElementDAOImpl<Order> {
    public OrderDAO() {
        super(Order.class);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
