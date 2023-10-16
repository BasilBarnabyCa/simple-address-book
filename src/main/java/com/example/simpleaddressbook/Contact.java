package com.example.simpleaddressbook;

import java.util.regex.Pattern;

public class Contact {
    private int contactID;
    private String firstName, lastName, email, phone;
    private Country country;

//    private Occupation occupation;

    // Default Constructor
    public Contact() {};

    public Contact(String firstName, String lastName, String email, String phone, Country country) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        this.country = Country.CANADA;
    }

    public Contact(int contactID, String firstName, String lastName, String email, String phone, Country country) {
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        this.country = Country.CANADA;
    }

    // Getters and Setters
    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName.trim();

        if(isNameValid(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name can only contain letters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName.trim();

        if(isNameValid(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name can only contain letters");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();

        if(isEmailValid(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("You must enter a valid email");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone.trim().replaceAll("[^0-9]", "");

        if(isValidPhoneNumber(phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone must be 10 digits following the North American Dialling plan");
        }
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isNameValid(String name) {
        return name.matches("[A-z]+");
    }

    public boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }

    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("[2-9]][0-9]{2}][2-9]{3}[0-9]{4}");
    }

}
