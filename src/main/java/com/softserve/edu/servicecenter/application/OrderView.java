package com.softserve.edu.servicecenter.application;

import com.softserve.edu.servicecenter.entity.Order;
import com.softserve.edu.servicecenter.entity.Team;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderView {

    public void printOrders(List<Order> orders) {
        Collections.sort(orders, Comparator.comparingLong(Order::getId));

        System.out.printf("%-11s", "№ ЗАКАЗА");
        System.out.printf("%-30s", "КЛИЕНТ");
        System.out.printf("%-60s", "АДРЕС");
        System.out.printf("%-30s", "УСЛУГА");
        System.out.printf("%-17s", "СТАТУС");
        System.out.printf("%-15s", "БРИГАДА");
        System.out.printf("%-20s", "ДАТА ПОСТУПЛЕНИЯ");
        System.out.printf("%-20s", "ДАТА ВЫПОЛНЕНИЯ");

        for (Order order : orders) {
            String id = String.format("%-12d", order.getId());
            String clientName = String.format("%-30s",
                    order.getClientByClientId().getName());
            String address = String.format("%-60s",
                    order.getClientByClientId().getAddressByAddressId().toString());
            String service = String.format("%-30s",
                    order.getServiceByServiceId().getName());
            String state = String.format("%-17s",
                    order.getStateByStateId().getName());
            Team team = order.getTeamByTeamId();
            String teamName = (team != null) ? team.getName() : "Не назначено";
            teamName = String.format("%-15s", teamName);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            String orderDate = dateFormat.format(order.getDateOrder());
            orderDate = String.format("%-20s", orderDate);
            Timestamp executeDate = order.getDateExecution();
            String executeDateStr =
                    (executeDate != null) ? dateFormat.format(executeDate) : "Не назначено";
            executeDateStr = String.format("%-20s", executeDateStr);

            System.out.println(id + clientName + address + service + state + teamName
                    + orderDate + executeDateStr);
        }
    }
}
