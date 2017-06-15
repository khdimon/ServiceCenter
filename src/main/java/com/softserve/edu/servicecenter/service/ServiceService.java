package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.entity.Service;

import java.util.List;

public class ServiceService {
    public void addService(Service service) {
        DAOFactory.getInstance().getServiceDAO().addElement(service);
    }

    public void updateService(Service service) {
        DAOFactory.getInstance().getServiceDAO().updateElement(service);
    }

    public Service getServiceById(Long serviceId) {
        return DAOFactory.getInstance().getServiceDAO()
                .getElementByID(serviceId);
    }

    public List<Service> getAllService() {
        return DAOFactory.getInstance().getServiceDAO()
                .getAllElements();
    }

    public void deleteService(Service service) {
        DAOFactory.getInstance().getServiceDAO()
                .deleteElement(service);
    }
}
