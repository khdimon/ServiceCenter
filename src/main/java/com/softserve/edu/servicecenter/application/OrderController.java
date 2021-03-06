package com.softserve.edu.servicecenter.application;

import com.softserve.edu.servicecenter.entity.Client;
import com.softserve.edu.servicecenter.entity.Order;
import com.softserve.edu.servicecenter.entity.Service;
import com.softserve.edu.servicecenter.service.OrderServiceImpl;
import com.softserve.edu.servicecenter.service.ServiceService;

import java.util.List;
import java.util.stream.Collectors;

public class OrderController {
    public void printAllOrders() {
        OrderServiceImpl service = new OrderServiceImpl();
        List<Order> orders = service.getAllOrders();
        OrderView orderView = new OrderView();
        orderView.printOrders(orders);
    }

    public void addOrder() {
        ClientController clientController = new ClientController();
        Client client = clientController.getNewClient();

        ServiceService serviceService = new ServiceService();
        List<Service> services = serviceService.getAllService();
        List<String> servicesStr = services.stream()
                .map((s) -> s.getId() + ". " + s.getName())
                .collect(Collectors.toList());
        Menu menu = new Menu("Выберите сервис:", servicesStr);
        menu.print();
        int serviceId = menu.selectPoint();

    }
}
