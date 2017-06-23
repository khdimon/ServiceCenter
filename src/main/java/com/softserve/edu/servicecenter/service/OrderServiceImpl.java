package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.dao.OrderDAO;
import com.softserve.edu.servicecenter.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        DAOFactory.getInstance().getOrderDAO().addElement(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        DAOFactory.getInstance().getOrderDAO().updateElement(order);
    }

    @Override
    @Transactional
    public Order getOrderById(Long orderId) {
        return DAOFactory.getInstance().getOrderDAO()
                .getElementByID(orderId);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return DAOFactory.getInstance().getOrderDAO()
                .getAllElements();
    }

    @Override
    @Transactional
    public void deleteOrder(Order order) {
        DAOFactory.getInstance().getOrderDAO()
                .deleteElement(order);
    }
}
