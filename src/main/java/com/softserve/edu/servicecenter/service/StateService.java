package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.entity.State;

import java.util.List;

public class StateService {
    public void addState(State state) {
        DAOFactory.getInstance().getStateDAO().addElement(state);
    }

    public void updateState(State state) {
        DAOFactory.getInstance().getStateDAO().updateElement(state);
    }

    public State getStateById(Long stateId) {
        return DAOFactory.getInstance().getStateDAO()
                .getElementByID(stateId);
    }

    public List<State> getAllState() {
        return DAOFactory.getInstance().getStateDAO()
                .getAllElements();
    }

    public void deleteState(State state) {
        DAOFactory.getInstance().getStateDAO()
                .deleteElement(state);
    }
}
