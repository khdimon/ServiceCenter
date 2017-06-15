package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.entity.Master;

import java.util.List;

public class MasterService {
    public void addMaster(Master master) {
        DAOFactory.getInstance().getMasterDAO().addElement(master);
    }

    public void updateMaster(Master master) {
        DAOFactory.getInstance().getMasterDAO().updateElement(master);
    }

    public Master getMasterById(Long masterId) {
        return DAOFactory.getInstance().getMasterDAO()
                .getElementByID(masterId);
    }

    public List<Master> getAllMaster() {
        return DAOFactory.getInstance().getMasterDAO()
                .getAllElements();
    }

    public void deleteMaster(Master master) {
        DAOFactory.getInstance().getMasterDAO()
                .deleteElement(master);
    }
}
