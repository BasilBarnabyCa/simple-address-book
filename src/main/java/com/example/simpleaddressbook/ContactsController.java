package com.example.simpleaddressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ContactsController {

    @FXML
    private TableColumn<Contact, Integer> contactIDColumn;

    @FXML
    private TableView<Contact> contactsTableView;

    @FXML
    private TableColumn<Contact, Country> countryColumn;

    @FXML
    private TableColumn<Contact, String> emailColumn;

    @FXML
    private TableColumn<Contact, String> firstNameColumn;

    @FXML
    private TableColumn<Contact, String> lastNameColumn;

    @FXML
    private Label messageLabel;

    @FXML
    private TableColumn<Contact, ?> phoneColumn;

    @FXML
    void viewAddContact(ActionEvent event) {

    }

    private ArrayList<Contact> allContacts;
    @FXML void initialize() {
        messageLabel.setText("");

        allContacts = DBUtility.getContacts();
        contactIDColumn.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        contactsTableView.getItems().addAll(allContacts);

    }
}
