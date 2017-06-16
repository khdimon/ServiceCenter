package com.softserve.edu.servicecenter.application;

import com.softserve.edu.servicecenter.entity.Address;

public class AddressController {
    public Address getNewAddress() {
        System.out.println("Укажите свой адрес:");
        System.out.println("город");
        String city = ConsoleHelper.readMessage();
        System.out.println("улица");
        String street = ConsoleHelper.readMessage();
        System.out.println("номер дома");
        String house = ConsoleHelper.readMessage();
        System.out.println("подъезд");
        String entrance = ConsoleHelper.readMessage();
        if (entrance.equals("")) {
            entrance = null;
        }
        System.out.println("квартира");
        String flatStr = ConsoleHelper.readMessage();
        Integer flat;
        try {
            flat = Integer.parseInt(flatStr);
        } catch (NumberFormatException e) {
            flat = null;
        }
        String floorStr = ConsoleHelper.readMessage();
        Integer floor;
        try {
            floor = Integer.parseInt(flatStr);
        } catch (NumberFormatException e) {
            floor = null;
        }
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(house);
        address.setEntrance(entrance);
        address.setFlat(flat);
        address.setFloor(floor);

        return address;
    }
}
