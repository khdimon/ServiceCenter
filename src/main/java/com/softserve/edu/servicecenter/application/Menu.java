package com.softserve.edu.servicecenter.application;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int pointNumber;
    private String menuHeader;
    private List<String> points;

    public Menu(String menuHeader, List<String> points) {
        this.pointNumber = points.size();
        this.menuHeader = menuHeader;
        this.points = points;
    }

    public void print() {
        System.out.println(menuHeader + ":");
        for (String string : points) {
            System.out.println(string);
        }
    }

    public int selectPoint() {
        int result;
        while (true) {
            try {
                String message = ConsoleHelper.readMessage();
                result = Integer.parseInt(message);
                if (result > 0 && result <= pointNumber) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Некорректный ввод");
        }
        return result;
    }
}
