package com.softserve.edu.servicecenter.controller;

import com.softserve.edu.servicecenter.entity.Order;
import com.softserve.edu.servicecenter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    @Qualifier(value = "orderService")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "orders")
    public ModelAndView getAllOrders() {
        ModelAndView modelAndView = new ModelAndView("/orders");
        List<Order> orders = orderService.getAllOrders();
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}
