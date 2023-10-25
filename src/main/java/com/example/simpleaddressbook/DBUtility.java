package com.example.simpleaddressbook;

import java.sql.*;
import java.util.ArrayList;


public class DBUtility {
    private static final String dbUser = "root";
    private static final String dbPassword = "grafic@R00t!";

    private static final String connectSting = "jdbc:mysql://localhost:3306/simpleaddressbook";

    /**
     * This method will get all contacts from the database
     * @return ArrayList<Contact> of type Contact
     */
    public static ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        ArrayList<Country> countries = DBUtility.getCountries();
        ArrayList<StateProvince> stateProvinces = DBUtility.getStateProvinces();

        String sql = "SElECT * FROM contacts;";

        try (
                Connection conn = DriverManager.getConnection(connectSting, dbUser, dbPassword);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                ) {
            while(resultSet.next()) {
                int contactId = resultSet.getInt("contactID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address1 = resultSet.getString("address1");
                String address2 = resultSet.getString("address2");
                String cityTown = resultSet.getString("cityTown");
                String zipcodePostal = resultSet.getString("zipcodePostal");

                int countryID = resultSet.getInt("countryID");
                Country country =  getCountry(countryID, countries);

                int stateProvinceID = resultSet.getInt("stateProvinceID");
                StateProvince stateProvince = getStateProvince(stateProvinceID, stateProvinces);

                Contact newContact = new Contact(contactId, firstName, lastName, email, phone, address1, address2, cityTown, zipcodePostal, country, stateProvince);

                contacts.add(newContact);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contacts;
    }

    /**
     * This method will get all countries from the database
     * @return ArrayList<Country> of type Country
     */
    public static ArrayList<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        String sql = "SELECT * FROM countries;";

        try (
                Connection conn = DriverManager.getConnection(connectSting, dbUser, dbPassword);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);

                ) {
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Create new country and add it to countries list
                Country newCountry = new Country(id, name);
                countries.add(newCountry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * This method will get a country if it exists in the database
     * @param id The id of the country
     * @param countries ArrayList<Country> of type Country
     * @return country of type Country
     */
    private static Country getCountry(int id, ArrayList<Country> countries) {
        for(Country country: countries) {
            if(country.getId() == id)
                return country;
        }
        return null;
    }

    /**
     * This method will get all state provinces from the database
     * @return ArrayList<StateProvince> of type StateProvince
     */
    public static ArrayList<StateProvince> getStateProvinces() {
        ArrayList<StateProvince> stateProvinces = new ArrayList<>();
        ArrayList<Country> countries = DBUtility.getCountries();
        String sql = "SELECT * FROM stateProvinces;";

        try(
                Connection conn = DriverManager.getConnection(connectSting, dbUser, dbPassword);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                ) {
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                int countryID = resultSet.getInt("countryID");
                Country country =  getCountry(countryID, countries);

                StateProvince newSateProvince = new StateProvince(id, name, country);
                stateProvinces.add(newSateProvince);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stateProvinces;
    }

    /**
     * This method will get a state a province if it exists in the database
     * @param id The id of the state or province
     * @param stateProvinces ArrayList<StateProvince> of type StateProvince
     * @return stateProvince of type StateProvince
     */
    private static StateProvince getStateProvince(int id, ArrayList<StateProvince> stateProvinces) {
        for(StateProvince stateProvince : stateProvinces) {
            if(stateProvince.getId() == id)
                return stateProvince;
        }
        return null;
    }
}
