package com.softserve.edu.servicecenter.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "services")
public class Service {
    private long id;
    private String name;
    private Collection<Order> ordersById;
    private Collection<Team> teamsById;
    //private Collection<TeamService> teamServicesById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service that = (Service) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }

    /*@OneToMany(mappedBy = "serviceByServiceId")
    public Collection<TeamService> getTeamServicesById() {
        return teamServicesById;
    }

    public void setTeamServicesById(Collection<TeamService> teamServicesById) {
        this.teamServicesById = teamServicesById;
    }*/

    @ManyToMany(targetEntity = Team.class,
            fetch = FetchType.LAZY)
    @JoinTable(name="teams_services", joinColumns={@JoinColumn(name="Services_id")},
            inverseJoinColumns={@JoinColumn(name="Teams_id")})
    public Collection<Team> getTeamsById() {
        return teamsById;
    }

    public void setTeamsById(Collection<Team> teamsById) {
        this.teamsById = teamsById;
    }
}
