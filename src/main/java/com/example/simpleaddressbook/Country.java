package com.example.simpleaddressbook;

import java.time.LocalDate;

public class Country {
    private int id;
    private String name;
    private LocalDate createdAt;

    // Constructors
    // Default constructor
    public Country(){}

    /**
     * This constructor will be used when we are retrieving a country from the database
     * @param id The ID of the country
     * @param name The name of the country
     * @param createdAt The creation date of the country
     */
    public Country(int id, String name, LocalDate createdAt) {
        setId(id);
        setName(name);
        setCreatedAt(createdAt);
    }

    /**
     * This constructor will be used when we are retrieving a country from the database
     * @param id The ID of the country
     * @param name The name of the country
     */
    public Country(int id, String name) {
        setId(id);
        setName(name);
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

    @Override
    public String toString() {
        return String.format("%d - %s", getId(), getName());
    }
}
