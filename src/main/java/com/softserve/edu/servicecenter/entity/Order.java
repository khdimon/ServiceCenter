package com.softserve.edu.servicecenter.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {
    private long id;
    private Timestamp dateOrder;
    private Timestamp dateExecution;
    private String clientComment;
    private String masterComment;
    private Client clientByClientId;
    private Service serviceByServiceId;
    private State stateByStateId;
    private Team teamByTeamId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_order", nullable = false)
    public Timestamp getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Basic
    @Column(name = "date_execution", nullable = true)
    public Timestamp getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(Timestamp dateExecution) {
        this.dateExecution = dateExecution;
    }

    @Basic
    @Column(name = "client_comment", nullable = true, length = 255)
    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    @Basic
    @Column(name = "master_comment", nullable = true, length = 255)
    public String getMasterComment() {
        return masterComment;
    }

    public void setMasterComment(String masterComment) {
        this.masterComment = masterComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (id != that.id) return false;
        if (dateOrder != null ? !dateOrder.equals(that.dateOrder) : that.dateOrder != null) return false;
        if (dateExecution != null ? !dateExecution.equals(that.dateExecution) : that.dateExecution != null)
            return false;
        if (clientComment != null ? !clientComment.equals(that.clientComment) : that.clientComment != null)
            return false;
        if (masterComment != null ? !masterComment.equals(that.masterComment) : that.masterComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (dateOrder != null ? dateOrder.hashCode() : 0);
        result = 31 * result + (dateExecution != null ? dateExecution.hashCode() : 0);
        result = 31 * result + (clientComment != null ? clientComment.hashCode() : 0);
        result = 31 * result + (masterComment != null ? masterComment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Clients_id", referencedColumnName = "id", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientsByClientsId) {
        this.clientByClientId = clientsByClientsId;
    }

    @ManyToOne
    @JoinColumn(name = "Services_id", referencedColumnName = "id", nullable = false)
    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(Service servicesByServicesId) {
        this.serviceByServiceId = servicesByServicesId;
    }

    @ManyToOne
    @JoinColumn(name = "States_id", referencedColumnName = "id", nullable = false)
    public State getStateByStateId() {
        return stateByStateId;
    }

    public void setStateByStateId(State statesByStatesId) {
        this.stateByStateId = statesByStatesId;
    }

    @ManyToOne
    @JoinColumn(name = "Teams_id", referencedColumnName = "id")
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }
}
