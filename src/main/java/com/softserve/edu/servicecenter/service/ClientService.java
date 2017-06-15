package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.entity.Client;

import java.util.List;

public class ClientService {
    public void addClient(Client client) {
        DAOFactory.getInstance().getClientDAO().addElement(client);
    }

    public void updateClient(Client client) {
        DAOFactory.getInstance().getClientDAO().updateElement(client);
    }

    public Client getClientById(Long clientId) {
        return DAOFactory.getInstance().getClientDAO()
                .getElementByID(clientId);
    }

    public List<Client> getAllClient() {
        return DAOFactory.getInstance().getClientDAO()
                .getAllElements();
    }

    public void deleteClient(Client client) {
        DAOFactory.getInstance().getClientDAO()
                .deleteElement(client);
    }
}
