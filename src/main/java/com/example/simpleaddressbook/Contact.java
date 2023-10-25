package com.example.simpleaddressbook;

import java.util.regex.Pattern;

public class Contact {
    private int contactID;
    private String firstName, lastName, email, phone, address1, address2, cityTown, zipcodePostal;
    private Country country;
    private StateProvince stateProvince;

    // Default Constructor
    public Contact() {};

    /**
     * @param firstName The first name of contact
     * @param lastName The last name of contact
     * @param email The email of contact
     * @param phone The phone of contact
     * @param address1 The address line 1 of contact
     * @param address2 The address line 2 of contact
     * @param cityTown  the city or town of contact
     * @param zipcodePostal The Zipcode or Postal Code of contact
     * @param country The country of contact
     * @param stateProvince The state or province of contact
     */
    public Contact(String firstName, String lastName, String email, String phone, String address1, String address2, String cityTown, String zipcodePostal, Country country, StateProvince stateProvince) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setAddress1(address1);
        setAddress2(address2);
        setCityTown(cityTown);
        setZipcodePostal(zipcodePostal);
        this.country = country;
        this.stateProvince = stateProvince;
    }

    /**
     * Constructor for DBUtility
     * @param firstName The first name of contact
     * @param lastName The last name of contact
     * @param email The email of contact
     * @param phone The phone of contact
     * @param address1 The address line 1 of contact
     * @param address2 The address line 2 of contact
     * @param cityTown  the city or town of contact
     * @param zipcodePostal The Zipcode or Postal Code of contact
     * @param country The country of contact
     * @param stateProvince The state or province of contact
     */
    public Contact(int contactID, String firstName, String lastName, String email, String phone, String address1, String address2, String cityTown, String zipcodePostal, Country country, StateProvince stateProvince) {
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setAddress1(address1);
        setAddress2(address2);
        setCityTown(cityTown);
        setZipcodePostal(zipcodePostal);
        this.country = country;
        this.stateProvince = stateProvince;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(String cityTown) {
        this.cityTown = cityTown;
    }

    public String getZipcodePostal() {
        return zipcodePostal;
    }

    public void setZipcodePostal(String zipcodePostal) {
        this.zipcodePostal = zipcodePostal;
    }

    public StateProvince getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(StateProvince stateProvince) {
        this.stateProvince = stateProvince;
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
