package com.java.clientmanager.clients.controller;


import com.java.clientmanager.MenuController;
import com.java.clientmanager.clients.Client;
import com.java.clientmanager.clients.ClientBuilder;
import com.java.clientmanager.clients.ClientCollection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AddClientController {

    private final ClientCollection clientCollection;

    private final MenuController menuController;

    @Autowired
    public AddClientController(ClientCollection clientCollection, MenuController menuController){
        this.clientCollection = clientCollection;
        this.menuController = menuController;
    }

    @FXML
    private TextField companyNameField;
    @FXML
    private TextField ownerNameField;
    @FXML
    private  TextField ownerSurnameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField estimatedValueField;


    public void displayClientView() {
        menuController.showClients();
    }

    public void addClient() {
        if(companyNameField.getText().isBlank()
                && ownerNameField.getText().isBlank()
                && ownerSurnameField.getText().isBlank()
                && phoneNumberField.getText().isBlank()
                && emailField.getText().isBlank()
                && estimatedValueField.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter correct information");
            alert.showAndWait();
            return;
        }
        Client client = ClientBuilder.builder()
                .withCompanyName(companyNameField.getText())
                .withOwnerName(ownerNameField.getText())
                .withOwnerSurname(ownerSurnameField.getText())
                .withPhoneNumber(phoneNumberField.getText())
                .withEmailAddress(emailField.getText())
                .withEstimatedValue(new BigDecimal(estimatedValueField.getText()))
                .withCreationDate(datePicker.getValue())
                .build();
        clientCollection.addClient(client);
        menuController.showClients();
    }


}
