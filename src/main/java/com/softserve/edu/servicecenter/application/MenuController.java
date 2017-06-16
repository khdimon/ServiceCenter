package com.softserve.edu.servicecenter.application;

import java.util.Arrays;

public class MenuController {

    public void start() {
        Menu menu = new Menu("Выбор роли",
                Arrays.asList("1. Клиент", "2. Оператор"));
        menu.print();
        int result = menu.selectPoint();
        switch (result) {
            case 1:
                client();
                break;
            case 2:
                operator();
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }

    private void client() {
        Menu menu = new Menu("Выбор действия",
                Arrays.asList("1. Создание заявки", "2. Просмотр состояния заявки", "3. Главное меню"));
        menu.print();
        int result = menu.selectPoint();
        switch (result) {
            case 1:
                createOrder();
                break;
            case 2:
                viewOrder();
                break;
            case 3:
                start();
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }

    private void operator() {
        Menu menu = new Menu("Выбор действия",
                Arrays.asList("1. Просмотр всех заявок", "2. Обработка заявки", "3. Главное меню"));
        menu.print();
        int result = menu.selectPoint();
        switch (result) {
            case 1:
                printAllOrders();
                break;
            case 2:
                handleOrder();
                break;
            case 3:
                start();
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }

    private void createOrder() {
        System.out.println("Создание заявки");
        client();
    }

    private void viewOrder() {
        System.out.println("Поиск заявки");
    }

    private void printAllOrders() {
        OrderController orderController = new OrderController();
        orderController.printAllOrders();
        Menu menu = new Menu("Выбор действия",
                Arrays.asList("1. Обработка заявки", "2. Предыдущее меню", "3. Главное меню"));
        menu.print();
        int result = menu.selectPoint();
        switch (result) {
            case 1:
                handleOrder();
                break;
            case 2:
                operator();
                break;
            case 3:
                start();
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }

    private void handleOrder() {
        System.out.println("Обработка заявки");
        operator();
    }
}
