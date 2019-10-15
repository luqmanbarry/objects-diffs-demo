package com.hamidou;

import org.javers.core.metamodel.annotation.Id;
import org.javers.core.metamodel.annotation.TypeName;

import java.util.Objects;
import java.util.StringJoiner;

@TypeName("Address")
public class Address {
    @Id
    private int id;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Address() {
    }

    public Address(int id, String street, String city, String state, int zipCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("street='" + street + "'")
                .add("city='" + city + "'")
                .add("state='" + state + "'")
                .add("zipCode=" + zipCode)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                zipCode == address.zipCode &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, state, zipCode);
    }
}
