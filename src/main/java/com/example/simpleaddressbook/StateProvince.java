package com.example.simpleaddressbook;

import java.time.LocalDate;

public class StateProvince {
    private int id;
    private String name;
    private LocalDate createdAt;
    private Country country;

    //Constructors
    StateProvince(){}

    /**
     * This constructor will be used when we are retrieving a state or province from the database
     * @param id The ID of the state or province
     * @param name The name of the state or province
     * @param createdAt The creation date of the state or province
     * @param country The country of the state or province
     */
    public StateProvince(int id, String name, LocalDate createdAt, Country country) {
        setId(id);
        setName(name);
        setCreatedAt(createdAt);
        setCountry(country);
    }

    /**
     * This constructor will be used when we are retrieving a state or province from the database
     * @param id The ID of the state or province
     * @param name The name of the state or province
     * @param country The country of the state or province
     */
    public StateProvince(int id , String name, Country  country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("%d - %s (%s)", getId(), getName(), getCountry().getName());
    }
}
