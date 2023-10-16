package com.example.simpleaddressbook;

import java.sql.*;
import java.util.ArrayList;


public class DBUtility {
    private static final String dbUser = "root";
    private static final String dbPassword = "grafic@R00t!";

    private static final String connectSting = "jdbc:mysql://localhost:3306/simpleAddressBook";

    public static ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();

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
                Country country = Country.valueOf(resultSet.getString("country"));

                Contact newContact = new Contact(contactId, firstName, lastName, email, phone, country);

                contacts.add(newContact);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contacts;
    }
}
