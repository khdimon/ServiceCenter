package com.softserve.edu.servicecenter.dao;

import com.softserve.edu.servicecenter.entity.Service;

public class ServiceDAO extends ElementDAOImpl<Service> {
    public ServiceDAO() {
        super(Service.class);
    }
}
