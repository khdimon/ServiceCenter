package com.softserve.edu.servicecenter.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "addresses")
public class Address {
    private long id;
    private String city;
    private String street;
    private String house;
    private Integer flat;
    private String entrance;
    private Integer floor;
    private Collection<Client> clientsById;
    private Collection<Master> mastersById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street", nullable = false, length = 45)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "house", nullable = false, length = 8)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Basic
    @Column(name = "flat", nullable = true)
    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    @Basic
    @Column(name = "entrance", nullable = true, length = 8)
    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    @Basic
    @Column(name = "floor", nullable = true)
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        if (id != that.id) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        if (flat != null ? !flat.equals(that.flat) : that.flat != null) return false;
        if (entrance != null ? !entrance.equals(that.entrance) : that.entrance != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        result = 31 * result + (entrance != null ? entrance.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Client> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Collection<Client> clientsById) {
        this.clientsById = clientsById;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Master> getMastersById() {
        return mastersById;
    }

    public void setMastersById(Collection<Master> mastersById) {
        this.mastersById = mastersById;
    }

    @Override
    public String toString() {
        String flatStr = (flat != null) ? ", кв. " + flat : "";
        String entranceStr = (entrance != null) ? ", подъезд " + entrance : "";
        String floorStr = (floor != null) ? ", этаж " + floor : "";
        return city + ", " + street + ", " + house + flatStr + entranceStr + floorStr;
    }
}
