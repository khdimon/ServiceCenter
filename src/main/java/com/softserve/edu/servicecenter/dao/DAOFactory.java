package com.softserve.edu.servicecenter.dao;

public class DAOFactory {
    private AddressDAO addressDAO = null;
    private ClientDAO clientDAO = null;
    private MasterDAO masterDAO = null;
    private OrderDAO orderDAO = null;
    private ServiceDAO serviceDAO = null;
    private StateDAO stateDAO = null;
    private TeamDAO teamDAO = null;

    private static DAOFactory instance = null;

    public DAOFactory() {
        this.addressDAO = new AddressDAO();
        this.clientDAO = new ClientDAO();
        this.masterDAO = new MasterDAO();
        this.orderDAO = new OrderDAO();
        this.serviceDAO = new ServiceDAO();
        this.stateDAO = new StateDAO();
        this.teamDAO = new TeamDAO();
    }

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public AddressDAO getAddressDAO() {
        return addressDAO;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public MasterDAO getMasterDAO() {
        return masterDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public ServiceDAO getServiceDAO() {
        return serviceDAO;
    }

    public StateDAO getStateDAO() {
        return stateDAO;
    }

    public TeamDAO getTeamDAO() {
        return teamDAO;
    }
}
