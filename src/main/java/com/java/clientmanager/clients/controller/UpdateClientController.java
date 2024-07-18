package com.java.clientmanager.clients.controller;

import com.java.clientmanager.MenuController;
import com.java.clientmanager.clients.Client;
import com.java.clientmanager.clients.ClientBuilder;
import com.java.clientmanager.clients.ClientCollection;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UpdateClientController {

    private Client currentClient;

    private final ClientCollection clientCollection;

    private final MenuController menuController;

    @Autowired
    public UpdateClientController(ClientCollection clientCollection, MenuController menuController){
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
    public void updateClient(){
                Client client = ClientBuilder.builder()
                        .withId(currentClient.getId())
                .withCompanyName(companyNameField.getText())
                .withOwnerName(ownerNameField.getText())
                .withOwnerSurname(ownerSurnameField.getText())
                .withPhoneNumber(phoneNumberField.getText())
                .withEmailAddress(emailField.getText())
                .withEstimatedValue(new BigDecimal(estimatedValueField.getText()))
                .withCreationDate(datePicker.getValue())
                .build();
        clientCollection.updateClientById(client);
        currentClient = null;
        menuController.showClients();
    }

    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }
}
