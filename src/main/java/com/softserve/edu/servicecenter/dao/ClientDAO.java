package com.softserve.edu.servicecenter.dao;

import com.softserve.edu.servicecenter.entity.Client;

public class ClientDAO extends ElementDAOImpl<Client> {
    public ClientDAO() {
        super(Client.class);
    }
}
