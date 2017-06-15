package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.entity.Order;

import java.util.List;

public class OrderService {
    public void addOrder(Order order) {
        DAOFactory.getInstance().getOrderDAO().addElement(order);
    }

    public void updateOrder(Order order) {
        DAOFactory.getInstance().getOrderDAO().updateElement(order);
    }

    public Order getOrderById(Long orderId) {
        return DAOFactory.getInstance().getOrderDAO()
                .getElementByID(orderId);
    }

    public List<Order> getAllOrder() {
        return DAOFactory.getInstance().getOrderDAO()
                .getAllElements();
    }

    public void deleteOrder(Order order) {
        DAOFactory.getInstance().getOrderDAO()
                .deleteElement(order);
    }
}
