package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.entity.Address;

import java.util.List;

public class AddressService {
    public void addAddress(Address address) {
       DAOFactory.getInstance().getAddressDAO().addElement(address);
    }

    public void updateAddress(Address address) {
        DAOFactory.getInstance().getAddressDAO().updateElement(address);
    }

    public Address getAddressById(Long addressId) {
        return DAOFactory.getInstance().getAddressDAO()
                .getElementByID(addressId);
    }

    public List<Address> getAllAddress() {
        return DAOFactory.getInstance().getAddressDAO()
                .getAllElements();
    }

    public void deleteAddress(Address address) {
        DAOFactory.getInstance().getAddressDAO()
                .deleteElement(address);
    }
}
