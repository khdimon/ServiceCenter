package com.softserve.edu.servicecenter.application;

import com.softserve.edu.servicecenter.entity.Address;
import com.softserve.edu.servicecenter.entity.Client;

public class ClientController {
    public Client getNewClient() {
        System.out.println("Укажите ваше ФИО:");
        String name = ConsoleHelper.readMessage();
        System.out.println("Введите номер телефона:");
        String phone = ConsoleHelper.readMessage();
        AddressController addressController = new AddressController();
        Address address = addressController.getNewAddress();
        Client client = new Client();
        client.setName(name);
        client.setPhone(phone);

        return client;
    }
}
