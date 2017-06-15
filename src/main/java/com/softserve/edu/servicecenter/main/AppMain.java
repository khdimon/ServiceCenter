package com.softserve.edu.servicecenter.main;

import com.softserve.edu.servicecenter.application.OrdersView;
import com.softserve.edu.servicecenter.application.TableView;
import com.softserve.edu.servicecenter.dao.HibernateSessionFactory;

public class AppMain {
    public static void main(String[] args) {

        try {
            TableView tableView = new OrdersView();
            tableView.printTable();

        } finally {
            HibernateSessionFactory.shutdown();
        }
    }
}
