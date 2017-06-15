package com.softserve.edu.servicecenter.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "teams")
public class Team {
    private long id;
    private String name;
    private Collection<Master> mastersById;
    private Collection<Order> ordersById;
    private Collection<Service> servicesById;
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

        Team that = (Team) o;

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

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<Master> getMastersById() {
        return mastersById;
    }

    public void setMastersById(Collection<Master> masterssById) {
        this.mastersById = masterssById;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }

    /*@OneToMany(mappedBy = "teamByTeamId")
    public Collection<TeamService> getTeamServicesById() {
        return teamServicesById;
    }

    public void setTeamServicesById(Collection<TeamService> teamServicesById) {
        this.teamServicesById = teamServicesById;
    }*/

    @ManyToMany(targetEntity = Service.class,
            fetch = FetchType.LAZY)
    @JoinTable(name="teams_services", joinColumns={@JoinColumn(name="Teams_id")},
            inverseJoinColumns={@JoinColumn(name="Services_id")})
    public Collection<Service> getServicesById() {
        return servicesById;
    }

    public void setServicesById(Collection<Service> servicesById) {
        this.servicesById = servicesById;
    }
}
