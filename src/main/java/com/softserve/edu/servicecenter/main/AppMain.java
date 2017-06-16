package com.softserve.edu.servicecenter.main;

import com.softserve.edu.servicecenter.application.MenuController;
import com.softserve.edu.servicecenter.dao.HibernateSessionFactory;

public class AppMain {
    public static void main(String[] args) {

        try {
            MenuController menuController = new MenuController();
            menuController.start();

        } finally {
            HibernateSessionFactory.shutdown();
        }
    }
}
