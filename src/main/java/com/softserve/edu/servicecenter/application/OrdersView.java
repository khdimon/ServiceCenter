package com.softserve.edu.servicecenter.application;

import com.softserve.edu.servicecenter.entity.Order;
import com.softserve.edu.servicecenter.entity.Team;
import com.softserve.edu.servicecenter.service.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdersView implements TableView {

    private OrderService service = new OrderService();

    @Override
    public void printTable() {
        List<Order> orders = service.getAllOrder();
        Collections.sort(orders, Comparator.comparingLong(Order::getId));

        System.out.printf("%-11s", "№ ЗАКАЗА");
        System.out.printf("%-30s", "КЛИЕНТ");
        System.out.printf("%-60s", "АДРЕСС");
        System.out.printf("%-30s", "УСЛУГА");
        System.out.printf("%-17s", "СТАТУС");
        System.out.printf("%-15s", "БРИГАДА");
        System.out.printf("%-20s", "ДАТА ПОСТУПЛЕНИЯ");
        System.out.printf("%-20s", "ДАТА ВЫПОЛНЕНИЯ");
        System.out.printf("%-120s%n", "КОММЕНТАРИЙ");

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
            String clientComment = order.getClientComment();
            clientComment = (clientComment != null) ? "КЛИЕНТ: " + clientComment : "";
            String masterComment = order.getMasterComment();
            masterComment = (masterComment != null) ? ", МАСТЕР: " + masterComment : "";
            String comment = String.format("%-120s", clientComment + masterComment);

            System.out.println(id + clientName + address + service + state + teamName
                    + orderDate + executeDateStr + comment);
        }
    }

    @Override
    public void updateOrder() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insert order id:");
            long id = Long.parseLong(reader.readLine());
            System.out.println("Insert new client name or ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
